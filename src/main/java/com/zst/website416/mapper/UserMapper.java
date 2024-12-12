package com.zst.website416.mapper;

import com.zst.website416.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Integer id);

    @Select("SELECT * FROM users")
    List<User> findAll();

    @Select("SELECT * FROM users WHERE nickname = #{nickname}")
    User findByName(String nickname);

    @Insert("INSERT INTO users(nickname, phone, role, password, created_at, updated_at) " +
            "VALUES(#{nickname}, #{phone}, #{role}, #{password}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Update("UPDATE users SET nickname = #{nickname}, phone = #{phone}, role = #{role}, " +
            "password = #{password}, updated_at = #{updatedAt} WHERE nickname = #{nickname}")
    void updateByNickname(User user);

    @Delete("DELETE FROM users WHERE nickname = #{nickname}")
    void deleteByName(String nickname);

    @Select("SELECT COUNT(*) > 0 FROM users WHERE nickname = #{nickname}")
    boolean existsByNickname(String nickname);
}

