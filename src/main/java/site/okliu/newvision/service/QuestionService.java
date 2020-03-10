package site.okliu.newvision.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.QuestionExtMapper;
import site.okliu.newvision.mapper.QuestionMapper;
import site.okliu.newvision.model.Question;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionMapper questionMapper;
    private QuestionExtMapper questionExtMapper;
    private UserService userService;

    @Autowired
    public QuestionService(QuestionMapper questionMapper, QuestionExtMapper questionExtMapper, UserService userService) {
        this.questionMapper = questionMapper;
        this.questionExtMapper = questionExtMapper;
        this.userService = userService;
    }

    public PaginationDTO<QuestionDTO> list(String search, Integer page, Integer size) {
        if (StringUtils.isNotBlank(search)) {
            String[] strings = StringUtils.split(search, " {1,}");
            search = StringUtils.join(strings, "|");
        }
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(questionExtMapper.countBySearch(search), page, size);
        // 优化参数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPages()) {
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> list = questionExtMapper.listBySearch(search, size, offset);
        convertQuestions2QuestionDTOs(list, questionDTOList);
        paginationDTO.setData(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO<QuestionDTO> list(Long userId, Integer page, Integer size) {
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO();
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
        List<Question> list = questionExtMapper.listByUserId(userId, size, offset);
        convertQuestions2QuestionDTOs(list, questionDTOList);
        paginationDTO.setData(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO findById(Long id) {
        Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(id);
        if (!questionOptional.isPresent()) {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionOptional.get();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userService.findById(question.getCreator());
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

    public void incViewCount(Long questionId) {
        Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(questionId);
        if (questionOptional.isPresent()) {
            questionExtMapper.incViewCount(questionId);
        } else {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
    }

    public void incCommentCount(Long questionId) {
        Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(questionId);
        if (questionOptional.isPresent()) {
            questionExtMapper.incCommentCount(questionId);
        } else {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
    }

    public List<QuestionDTO> findRelated(QuestionDTO questionDTO) {
        if (StringUtils.isBlank(questionDTO.getTag())) {
            return Collections.EMPTY_LIST;
        }
        List<Question> questions = questionExtMapper.selectRelated(questionDTO);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        convertQuestions2QuestionDTOs(questions, questionDTOList);
        return questionDTOList;
    }

    public void convertQuestions2QuestionDTOs(List<Question> questions, List<QuestionDTO> questionDTOList) {
        for (Question question : questions) {
            User user = userService.findById(question.getCreator());
            QuestionDTO qesDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, qesDTO);
            qesDTO.setUser(user);
            questionDTOList.add(qesDTO);
        }
    }
}
