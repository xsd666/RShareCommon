package com.run.rshare.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.run.rshare.common.agreement.document.OpenApiUtil;
import com.run.rshare.common.agreement.document.Servers;
import com.run.rshare.config.SystemBizConfig;
import com.run.rshare.controller.ServiceAgreementController;
import com.run.rshare.dao.ServiceAgreementDao;
import com.run.rshare.entity.ServiceAgreement;
import com.run.rshare.model.*;
import com.run.rshare.service.ServiceAgreementService;
import io.swagger.models.HttpMethod;
import ma.glasnost.orika.MapperFacade;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName ServiceAgreementService
 * @Description: 服务规约(ServiceAgreement)表服务接口
 * @Author xsd
 * @Date 2023/8/9
 * @Version V1.0
 **/
@Service("serviceAgreementService")
public class ServiceAgreementServiceImpl implements ServiceAgreementService {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceAgreementServiceImpl.class);


    @Resource
    private ServiceAgreementDao serviceAgreementDao;

    @Resource
    private MapperFacade mapperFacade;

    /**
     * 系统业务配置
     */
    @Resource
    private SystemBizConfig systemBizConfig;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public Boolean delete(Long id) {
        ServiceAgreement serviceAgreement = new ServiceAgreement();
        serviceAgreement.setId(id);
        serviceAgreement.setDeleted(1);
        return serviceAgreementDao.update(serviceAgreement) > 0;
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @Override
    public ServiceAgreementVO detail(Long id) {
        ServiceAgreement serviceAgreement = serviceAgreementDao.queryById(id);
        ServiceAgreementVO serviceAgreementVo = mapperFacade.map(serviceAgreement, ServiceAgreementVO.class);
        return serviceAgreementVo;
    }

    /**
     * 查询分页
     *
     * @param serviceAgreementQueryPageDTO
     * @return
     */
    @Override
    public PageResult<ServiceAgreementVO> list(ServiceAgreementQueryPageDTO serviceAgreementQueryPageDTO) {
        ServiceAgreement serviceAgreement = mapperFacade.map(serviceAgreementQueryPageDTO, ServiceAgreement.class);
        serviceAgreement.setDeleted(0);
        PageHelper.startPage(serviceAgreementQueryPageDTO.getPageNum(), serviceAgreementQueryPageDTO.getCurrentPage());
        List<ServiceAgreement> serviceAgreementList = serviceAgreementDao.query(serviceAgreement);
        PageInfo<ServiceAgreement> pageInfo = new PageInfo<>(serviceAgreementList);
        List<ServiceAgreementVO> serviceAgreementVOList = serviceAgreementList.stream()
                .map(item -> mapperFacade.map(item, ServiceAgreementVO.class))
                .collect(Collectors.toList());
        return PageResult.success(serviceAgreementVOList, pageInfo.getTotal());
    }

    /**
     * 上传接口定义规约excel
     *
     * @param file
     * @param ruleExcelEnum
     * @return
     */
    @Override
    public UploadRuleExcelVO uploadRuleExcel(MultipartFile file, RuleExcelEnum ruleExcelEnum) {
        String xlsxSuffix = ".xlsx";
        String jsonSuffix = ".json";
        String snowflakeNextId = IdUtil.getSnowflakeNextIdStr();
        String agreementExcelFilePath = systemBizConfig.getRuleExcelStorePath() + File.separator + ruleExcelEnum.name() + "_" + snowflakeNextId + xlsxSuffix;
        File agreementExcelFile = new File(agreementExcelFilePath);
        if (!agreementExcelFile.getParentFile().exists()) {
            agreementExcelFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(agreementExcelFile);
        } catch (Exception e) {
            LOG.error("规则描述文件上传失败", e);
            throw new RuntimeException("规则描述文件上传失败" + e.getMessage());
        }
        //规则响应文件 不需要转为规约json
        if (ruleExcelEnum.name().equals(RuleExcelEnum.responseRule.name())) {
            return new UploadRuleExcelVO(RuleExcelEnum.responseRule.name(), agreementExcelFilePath, "");
        }
        JSONObject importExcelRegFile = OpenApiUtil.importExcelRegFile(agreementExcelFile);
        if (!Objects.equals(importExcelRegFile.getString("code"), "200")) {
            throw new RuntimeException(importExcelRegFile.getString("msg"));
        }
        String jsonStoreFilePath = systemBizConfig.getRuleExcelStorePath() + File.separator + snowflakeNextId + jsonSuffix;
        JSONObject reqAndRespData = importExcelRegFile.getJSONObject("data");
        String fileName = file.getName();
        String name = fileName.split(jsonSuffix)[0];
        String operationId = snowflakeNextId;
        String httpMethod = HttpMethod.POST.name();
        String defaultSchema = OpenApiUtil.reqAndRespToOpenApiJson(reqAndRespData, name, name, "1.0", Lists.newArrayList(), operationId, httpMethod);
        FileUtil.writeString(defaultSchema, new File(jsonStoreFilePath), "utf-8");
        return new UploadRuleExcelVO(RuleExcelEnum.interfaceRule.name(), agreementExcelFilePath, jsonStoreFilePath);

    }
}