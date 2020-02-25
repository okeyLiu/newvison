package site.okliu.newvision.mapper;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.model.Question;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static site.okliu.newvision.mapper.QuestionDynamicSqlSupport.*;

@Repository
public class QuestionExtMapper {

    @Autowired
    private QuestionMapper questionMapper;

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
     * 返回所有问题的条数
     *
     * @return
     */
    public Long countQuestions() {
        SelectStatementProvider countSelect = select(count())
                .from(question)
                .build().render(RenderingStrategies.MYBATIS3);
        return questionMapper.count(countSelect);
    }

    /**
     * 返回所有问题的分页数据
     *
     * @param size
     * @param offset
     * @return
     */
    public List<Question> list(Integer size, Integer offset) {
        SelectStatementProvider pageSelect = select(question.allColumns())
                .from(question)
                .orderBy(gmtCreate.descending())// descending() 降序
                .limit(size)
                .offset(offset)
                .build().render(RenderingStrategies.MYBATIS3);
        return questionMapper.selectMany(pageSelect);
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

}
