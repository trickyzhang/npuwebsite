// 文件路径: D:\code\website416\src\main\java\com\zst\website416\mapper\PaperMapper.java
package com.zst.website416.mapper;

import com.zst.website416.model.Paper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaperMapper {

    @Select("SELECT * FROM papers")
    List<Paper> findAll();

    @Select("SELECT * FROM papers WHERE paper_id = #{id}")
    Paper findById(Integer id);

    @Select("SELECT * FROM papers WHERE title = #{title}")
    Paper findByTitle(String title);


    @Insert("INSERT INTO papers(title, authors, url, image_url) VALUES(#{title}, #{authors}, #{url}, #{image_url})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Paper paper);

    @Update("UPDATE papers SET title = #{title}, authors = #{authors}, url = #{url}, image_url = #{image_url} WHERE paper_id = #{id}")
    void update(Paper paper);

    @Delete("DELETE FROM papers WHERE paper_id = #{id}")
    void deleteById(Integer id);
}
