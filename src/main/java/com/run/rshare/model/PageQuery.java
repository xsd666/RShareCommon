package com.run.rshare.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * @ClassName PageQuery
 * @Description: 分页
 * @Author xsd
 * @Date 2023/8/15
 * @Version V1.0
 **/
@ApiModel("分页对象")
public class PageQuery {

    @ApiModelProperty("页码（从1开始）")
    @Min(value = 1,message = "最小页码必须大于等于1")
    private int pageNum = 1;

    @ApiModelProperty("每页数量")
    @NotNull
    @Min(value = 1,message = "每页数量必须大于等于1")
    private int currentPage = 100;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
