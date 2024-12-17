package com.zst.website416.mapper;

import com.zst.website416.model.Patent;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface PatentMapper {
    @Select("SELECT * FROM patents")
    List<Patent> findAll();

    @Select("SELECT * FROM patents WHERE patent_id = #{id}")
    Patent findById(Integer id);

    @Select("SELECT * FROM patents WHERE title = #{title}")
    Patent findByTitle(String title);

    @Insert("INSERT INTO patents(title, patent_number, inventors, application_date) VALUES(#{title}, #{patent_number}, #{inventors}, #{application_date})")
    @Options(useGeneratedKeys = true, keyProperty = "patent_id")
    void insert(Patent patent);

    @Update("UPDATE patents SET title = #{title}, patent_number = #{patent_number}, inventors = #{inventors}, application_date = #{application_date} WHERE patent_id = #{patent_id}")
    void update(Patent patent);

    @Delete("DELETE FROM patents WHERE patent_id = #{id}")
    void deleteById(Integer id);
}
