package com.run.rshare.dao;

import com.run.rshare.entity.ServiceAgreement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 服务规约(ServiceAgreement)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-31 17:57:58
 */
public interface ServiceAgreementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ServiceAgreement queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param serviceAgreement 实例对象
     * @return 对象列表
     */
    List<ServiceAgreement> query(ServiceAgreement serviceAgreement);

    /**
     * 新增数据
     *
     * @param serviceAgreement 实例对象
     * @return 影响行数
     */
    int insert(ServiceAgreement serviceAgreement);

    /**
     * 修改数据
     *
     * @param serviceAgreement 实例对象
     * @return 影响行数
     */
    int update(ServiceAgreement serviceAgreement);

}