package com.zst.website416.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String nickname;
    private String phone;
    private String role;
    private String password;
    private Date createdAt;
    private Date updatedAt;
}