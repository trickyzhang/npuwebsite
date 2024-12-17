package com.zst.website416.mapper;

import com.zst.website416.model.monograph;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MonographMapper {

    @Select("SELECT * FROM monographs WHERE monograph_id = #{monographId}")
    monograph findById(Integer monographId);

    @Select("SELECT * FROM monographs WHERE title = #{title}")
    monograph findByTitle(String title);

    @Select("SELECT * FROM monographs")
    List<monograph> selectAll();

    @Insert("INSERT INTO monographs(title, authors, publication_date) VALUES(#{title}, #{authors}, #{publishDate})")
    @Options(useGeneratedKeys = true, keyProperty = "monographId")
    void insert(monograph monograph);

    @Update("UPDATE monographs SET title = #{title}, authors = #{authors}, publication_date = #{publishDate} WHERE monograph_id = #{monographId}")
    void update(monograph monograph);

    @Delete("DELETE FROM monographs WHERE monograph_id = #{monographId}")
    void deleteById(Integer monographId);
}
