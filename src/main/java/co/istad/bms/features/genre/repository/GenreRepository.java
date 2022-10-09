package co.istad.bms.features.genre.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import co.istad.bms.features.genre.model.Genre;

@Repository
public interface GenreRepository {


    @InsertProvider(type = GenreProvider.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("genre") Genre genre);


    @UpdateProvider(type = GenreProvider.class, method = "buildUpdateSql")
    void update(@Param("id") Integer id, @Param("genre") Genre genre);


    @Delete("DELETE FROM genres WHERE id = #{id}")
    void delete(@Param("id") Integer id);
    

    // Inline SQL
    @SelectProvider(type = GenreProvider.class, method = "buildSelectSql")
    @Results(id = "genreResultMapper", value = {
        @Result(column = "is_enabled", property = "isEnabled")
    })
    List<Genre> select();


    @SelectProvider(type = GenreProvider.class, method = "buildSelectByIdSql")
    @ResultMap(value = "genreResultMapper")
    Genre selectById(@Param("id") Integer id);


}
