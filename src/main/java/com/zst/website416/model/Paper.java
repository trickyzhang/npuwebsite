package com.zst.website416.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paper {
    private Integer id;
    private String title;
    private String authors;
    private String url;
    private String image_url;
}
