package com.run.rshare.dao;

import com.run.rshare.entity.AgreementCounter;

/**
 * @ClassName AgreementCounterDao
 * @Description: 规约计数器
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
public interface AgreementCounterDao {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AgreementCounter queryById(Integer id);

    /**
     * 修改数据
     *
     * @param agreementCounter 实例对象
     * @return 影响行数
     */
    int updateByIdAndVersion(AgreementCounter agreementCounter);

}
