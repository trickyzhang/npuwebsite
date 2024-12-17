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
public class Patent {
    private Integer patent_id;
    private String title;
    private String patent_number;
    private String inventors;
    private Date application_date;
}
