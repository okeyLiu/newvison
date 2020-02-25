package site.okliu.newvision.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.QuestionExtMapper;
import site.okliu.newvision.mapper.QuestionMapper;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.Question;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(questionExtMapper.countQuestions(), page, size);
        // 优化参数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPages()) {
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> list = questionExtMapper.list(size,offset);
        for (Question question : list) {
            User user = userMapper.selectByPrimaryKey(question.getCreator()).get();
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(Long userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(questionExtMapper.countQuestionsByUserId(userId), page, size);
        // 优化参数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPages()) {
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> list = questionExtMapper.listByUserId(userId,size,offset);
        for (Question qes : list) {
            User u1 = userMapper.selectByPrimaryKey(qes.getCreator()).get();
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(qes, questionDTO);
            questionDTO.setUser(u1);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO findById(Long id) {
        Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(id);
        if (!questionOptional.isPresent()) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        Question question1 = questionOptional.get();
        BeanUtils.copyProperties(question1, questionDTO);
        User user = userMapper.selectByPrimaryKey(question1.getCreator()).get();
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question questionObj) {
        if (questionObj.getId() != null) {
            // 更新
            questionObj.setGmtModify(System.currentTimeMillis());
            questionMapper.updateByPrimaryKeySelective(questionObj);
        } else {
            // 新增
            questionObj.setGmtCreate(System.currentTimeMillis());
            questionObj.setGmtModify(questionObj.getGmtCreate());
            questionObj.setViewCount(0);
            questionObj.setLikeCount(0);
            questionObj.setCommentCount(0);
            questionMapper.insert(questionObj);
        }
    }

    public void updateViewCount(Long questionId, Long userId) {
        Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(questionId);
        if (questionOptional.isPresent()) {
            Question question1 = questionOptional.get();
            // 只有不是问题的创建者(未登录用户、游客)才增加阅读数
            if (!question1.getCreator().equals(userId)) {
                questionExtMapper.incViewCount(questionId);
            }
        } else {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
    }
}
