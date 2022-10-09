package co.istad.bms.features.genre.repository;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import co.istad.bms.features.genre.model.Genre;

public class GenreProvider {
    
    public String buildInsertSql(@Param("genre") Genre genre) {
        return new SQL() {{
            // YOUR SQL
            INSERT_INTO("genres");

            if (!genre.getTitle().isBlank()) {
                VALUES("title", "#{genre.title}");
            }

            
            VALUES("description", "#{genre.description}");
            VALUES("icon", "#{genre.icon}");
            VALUES("is_enabled", "#{genre.isEnabled}");
        }}.toString();
    }

    public String buildUpdateSql() {
        return new SQL() {{
            UPDATE("genres");
            SET("title = #{genre.title}");
            SET("description = #{genre.description}");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String buildSelectSql() {
        return new SQL() {{
            SELECT("*");
            FROM("genres");
        }}.toString();
    }

    public String buildSelectByIdSql() {
        return new SQL() {{
            SELECT("*");
            FROM("genres");
            WHERE("id = #{id}");
        }}.toString();
    }

}
