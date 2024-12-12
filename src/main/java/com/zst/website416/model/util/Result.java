package com.zst.website416.model.util;


import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
public class Result {
    private int code;
    private Object data;
    private String msg;

    public Result(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Result success(Object data) {
        return new Result(200, data, null);
    }

    public static Result fail(String msg) {
        return new Result(400, null, msg);
    }

    // Getters and Setters
}
