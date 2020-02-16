package site.okliu.newvision.service;

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

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer count = questionMapper.count();
        paginationDTO.setPaginationDTO(count,page,size);
        // 优化参数
        if(page<1){
            page = 1;
        }
        if(page > paginationDTO.getTotalPages()){
            page = paginationDTO.getTotalPages();
        }
        Integer offset = size * (page-1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> list = questionMapper.list(offset,size);
        for (Question question : list) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}
