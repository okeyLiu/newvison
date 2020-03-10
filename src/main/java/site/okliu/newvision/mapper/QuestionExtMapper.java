package site.okliu.newvision.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.model.Question;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.*;

@Repository
public class QuestionExtMapper {

    private QuestionMapper questionMapper;
    private QuestionXMLMapper questionXMLMapper;


    @Autowired
    public QuestionExtMapper(QuestionMapper questionMapper, QuestionXMLMapper questionXMLMapper) {
        this.questionMapper = questionMapper;
        this.questionXMLMapper = questionXMLMapper;
    }

    /**
     * 阅读数+1
     *
     * @param questionId
     */
    public void incViewCount(Long questionId) {
        // 此处使用“view_count+1” 含义是 使用执行数据库是 view_count 列的值+1，避免并发错误
        questionMapper.update(c ->
                c.set(viewCount).equalToConstant("view_count+1")
                        .where(id, isEqualTo(questionId))
        );
    }

    /**
     * 回复数+1
     *
     * @param questionId
     */
    public void incCommentCount(Long questionId) {
        // 此处使用“comment_count+1” 含义是 使用执行数据库是 comment_count 列的值+1，避免并发错误
        questionMapper.update(c ->
                c.set(commentCount).equalToConstant("comment_count+1")
                        .where(id, isEqualTo(questionId))
        );
    }

    /**
     * 返回指定userId的问题条数
     *
     * @param userId
     * @return
     */
    public Long countQuestionsByUserId(Long userId) {
        SelectStatementProvider countSelect = select(count())
                .from(question)
                .where(creator, isEqualTo(userId))
                .build().render(RenderingStrategies.MYBATIS3);
        return questionMapper.count(countSelect);
    }

    /**
     * 返回指定userId的问题分页数据
     *
     * @param userId
     * @param size
     * @param offset
     * @return
     */
    public List<Question> listByUserId(Long userId, Integer size, Integer offset) {
        SelectStatementProvider pageSelect = select(question.allColumns())
                .from(question)
                .where(creator, isEqualTo(userId))
                .orderBy(gmtCreate.descending())// descending() 降序
                .limit(size)
                .offset(offset)
                .build().render(RenderingStrategies.MYBATIS3);
        return questionMapper.selectMany(pageSelect);
    }

    /**
     * 查询相关标签的问题
     *
     * @param questionDTO
     * @return
     */
    public List<Question> selectRelated(QuestionDTO questionDTO) {
        return questionXMLMapper.selectRelated(questionDTO);
    }

    public Long countBySearchTag(String search, String tag) {
        return questionXMLMapper.countSearchTag(search, tag);
    }

    public List<Question> listBySearchTag(String search, String tag, Integer size, Integer offset) {
        return questionXMLMapper.listBySearchTag(search, tag, size, offset);
    }

    /**
     * 该接口的存在，只是为了解决MyBatis3动态SQL暂不支持的（或未找到相关使用资料）一些用法，采用原生SQL的写法
     */
    @Mapper
    private interface QuestionXMLMapper {
        @Select("select count(*) from question where title regexp #{search} and tag regexp #{tag}")
        Long countSearchTag(@Param("search") String search, @Param("tag") String tag);

        @Select("select * from question where title regexp #{search} and tag regexp #{tag} order by gmt_create desc,comment_count desc,view_count desc limit #{offset},#{size}")
        List<Question> listBySearchTag(@Param("search") String search, @Param("tag") String tag, @Param("size") Integer size, @Param("offset") Integer offset);

        @Select("select * from question where id != #{id} and tag regexp replace(#{tag}, ',', '|') order by comment_count desc,view_count desc,gmt_create desc limit 0, 10")
        List<Question> selectRelated(QuestionDTO questionDTO);
    }

}
