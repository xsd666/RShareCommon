package com.run.rshare.model;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description: Result
 * @Author xsd
 * @Date 2023/8/9
 * @Version V1.0
 **/
public class Result<T> implements Serializable {

    private static final Integer SUCCESS = 200;

    private static final Integer ERROR = 500;

    private static final String SUCCESS_MSG = "success";

    private Result() {
    }

    private Integer code;

    private String msg;

    private T data;

    public static <T> Result success(Integer resultCode, String resultMessage, T data) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMsg(resultMessage);
        result.setData(data);
        return result;
    }

    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setMsg(SUCCESS_MSG);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode(ERROR);
        result.setMsg(msg);
        return result;
    }

    public static Result fail(Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMsg(resultMessage);
        return result;
    }

    public static <T> Result fail(Integer resultCode, String resultMessage, T data) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMsg(resultMessage);
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
