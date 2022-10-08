package co.istad.bms.features.genre.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import co.istad.bms.features.genre.model.Genre;

@Repository
public interface GenreRepository {

    @Insert("INSERT INTO genres (title, description, icon, is_enabled) " + 
    "VALUES (#{genre.title}, #{genre.description}, #{genre.icon}, #{genre.isEnabled})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("genre") Genre genre);

    @Update("UPDATE genres " + 
    "SET title = #{genre.title}, description = #{genre.description} " + 
    "WHERE id = #{id}")
    void update(@Param("id") Integer id, @Param("genre") Genre genre);

    @Delete("DELETE FROM genres WHERE id = #{id}")
    void delete(@Param("id") Integer id);
    
    // Inline SQL
    @Select("SELECT * FROM genres ORDER BY id DESC")
    @Results(id = "genreResultMapper", value = {
        @Result(column = "is_enabled", property = "isEnabled")
    })
    List<Genre> select();

    @Select("SELECT * FROM genres WHERE id = #{id}")
    @ResultMap(value = "genreResultMapper")
    Genre selectById(@Param("id") Integer id);

}
