package site.okliu.newvision.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import site.okliu.newvision.model.Question;

import java.util.List;

@Repository// 只是为了idea的@AutoWired不报红线
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modify,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModify},#{creator},#{tag} )")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();
}
