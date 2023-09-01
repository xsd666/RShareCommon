package com.run.rshare.model;

import java.util.List;

/**
 * @ClassName PageResult
 * @Description: 分页
 * @Author xsd
 * @Date 2023/8/15
 * @Version V1.0
 **/
public class PageResult<T> {

    private static final Integer SUCCESS = 200;

    private static final Integer ERROR = 500;

    private Long total;

    private List<T> data;

    private Integer code;

    private String msg;

    public static PageResult success(List data, Long total) {
        PageResult result = new PageResult();
        result.setCode(SUCCESS);
        result.setData(data);
        result.setTotal(total);
        result.setMsg("ok");
        return result;
    }

    public static PageResult fail(String msg) {
        PageResult result = new PageResult();
        result.setCode(ERROR);
        result.setMsg(msg);
        return result;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
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
}
