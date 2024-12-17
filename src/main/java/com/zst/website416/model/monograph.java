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
public class monograph {
    private Integer monograph_id;
    private String title;
    private String authors;
    private Date publication_date;
}
