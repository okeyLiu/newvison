package site.okliu.newvision.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.okliu.newvision.dto.QuestionDTO;
import site.okliu.newvision.model.Question;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modify,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModify},#{creator},#{tag} )")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator=${userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Long userId, @Param("offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question where creator=${userId}")
    Integer countByUserId(@Param("userId") Long userId);

    @Select("select * from question where id=${id}")
    Question findById(@Param("id") Long id);
}
