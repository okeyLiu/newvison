package site.okliu.newvision.service;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.okliu.newvision.dto.PaginationDTO;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.mapper.QuestionMapper;
import site.okliu.newvision.mapper.UserMapper;
import site.okliu.newvision.model.Question;
import site.okliu.newvision.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.creator;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.question;

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
        SelectStatementProvider countByUserId = select(count()).from(question).where(creator,isEqualTo(userId)).build().render(RenderingStrategies.MYBATIS3);;
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
                .where(creator,isEqualTo(userId))
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

    public QuestionDTO findById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(Math.toIntExact(id)).get();
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator()).get();
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question questionObj) {
        if(questionObj.getId() != null){
            // 更新
            questionObj.setGmtModify(questionObj.getGmtCreate());
            questionMapper.updateByPrimaryKey(questionObj);
        }else{
            // 新增
            questionObj.setGmtCreate(System.currentTimeMillis());
            questionObj.setGmtModify(questionObj.getGmtCreate());
            questionMapper.insert(questionObj);
        }
    }
}
