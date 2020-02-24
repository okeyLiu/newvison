package site.okliu.newvision.service;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.exception.CustomizeErrorCode;
import site.okliu.newvision.exception.CustomizeException;
import site.okliu.newvision.mapper.QuestionMapper;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.Question;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.*;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.viewCount;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        SelectStatementProvider countSelect = select(count())
                .from(question)
                .build().render(RenderingStrategies.MYBATIS3);
        long count = questionMapper.count(countSelect);
        paginationDTO.setPaginationDTO(Math.toIntExact(count), page, size);
        // 优化参数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPages()) {
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        SelectStatementProvider pageSelect = select(question.allColumns())
                .from(question)
                .orderBy(gmtModify.descending())// descending() 降序
                .limit(size)
                .offset(offset)
                .build().render(RenderingStrategies.MYBATIS3);
        List<Question> list = questionMapper.selectMany(pageSelect);
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

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        SelectStatementProvider countByUserId = select(count()).from(question).where(creator, isEqualTo(userId)).build().render(RenderingStrategies.MYBATIS3);
        ;
        Integer count = Math.toIntExact(questionMapper.count(countByUserId));
        paginationDTO.setPaginationDTO(count, page, size);
        // 优化参数
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPages()) {
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        SelectStatementProvider pageSelect = select(question.allColumns())
                .from(question)
                .where(creator, isEqualTo(userId))
                .orderBy(gmtModify.descending())// descending() 降序
                .limit(size)
                .offset(offset)
                .build().render(RenderingStrategies.MYBATIS3);
        List<Question> list = questionMapper.selectMany(pageSelect);
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

    public QuestionDTO findById(Integer id) {
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
            questionObj.setGmtModify(questionObj.getGmtCreate());
            questionMapper.updateByPrimaryKeySelective(questionObj);
        } else {
            // 新增
            questionObj.setGmtCreate(System.currentTimeMillis());
            questionObj.setGmtModify(questionObj.getGmtCreate());
            questionMapper.insert(questionObj);
        }
    }

    public void updateViewCount(Integer questionId, Integer userId) {
        Optional<Question> questionOptional = questionMapper.selectByPrimaryKey(questionId);
        if (questionOptional.isPresent()) {
            Question question1 = questionOptional.get();
            // 只有不是问题的创建者才增加阅读数
            if (!question1.getCreator().equals(userId)) {
                Integer viewCount = question1.getViewCount();
                question1.setViewCount(++viewCount);
                System.out.println("viewCount = " + viewCount);
                questionMapper.updateByPrimaryKeySelective(question1);
            }
        } else {
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
    }
}
