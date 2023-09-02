package com.run.rshare.service;

import com.run.rshare.model.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName ServiceAgreementService
 * @Description: 服务规约(ServiceAgreement)表服务接口
 * @Author xsd
 * @Date 2023/8/9
 * @Version V1.0
 **/
public interface ServiceAgreementService {

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Boolean delete(Long id);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    ServiceAgreementVO detail(Long id);

    /**
     * 查询分页
     *
     * @param serviceAgreementQueryPageDTO
     * @return
     */
    PageResult<ServiceAgreementVO> list(ServiceAgreementQueryPageDTO serviceAgreementQueryPageDTO);

    /**
     * 上传接口定义规约excel
     *
     * @param file
     * @param enumRuleExcel
     * @return
     */
    UploadRuleExcelVO uploadRuleExcel(MultipartFile file, EnumRuleExcel enumRuleExcel);

    /**
     * 规约保存
     * @param serviceAgreementSaveDTO
     */
    void save(ServiceAgreementSaveDTO serviceAgreementSaveDTO);
}