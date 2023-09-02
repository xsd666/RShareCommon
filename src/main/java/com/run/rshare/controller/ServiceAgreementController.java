package com.run.rshare.controller;

import com.run.rshare.model.*;
import com.run.rshare.service.AgreementCounterService;
import com.run.rshare.service.ServiceAgreementService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @ClassName ServiceAgreementController
 * @Description: 异常处理
 * @Author xsd
 * @Date 2023/8/9
 * @Version V1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/agreement")
public class ServiceAgreementController {

    /**
     * 服务对象
     */
    @Resource
    private ServiceAgreementService serviceAgreementService;

    @Resource
    private AgreementCounterService agreementCounterService;

    /**
     * 规约标识生成
     * @return
     */
    @PostMapping(value = "generateAgreementIdentifier")
    public Result<String> generateAgreementIdentifier() {
        String agreementIdentifier = agreementCounterService.generateAgreementIdentifier();
        return Result.success(agreementIdentifier);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/{id:^[1-9][0-9]*$}")
    public Result<Boolean> delete(@PathVariable Long id) {
        serviceAgreementService.delete(id);
        return Result.success(Boolean.TRUE);
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/detail/{id:^[1-9][0-9]*$}")
    public Result<ServiceAgreementVO> detail(@NotNull @Min(value = 1, message = "最小为1") @PathVariable Long id) {
        return Result.success(serviceAgreementService.detail(id));
    }

    /**
     * 分页查询
     *
     * @param serviceAgreementQueryPageDTO
     * @return
     */
    @PostMapping(value = "/list")
    public PageResult<ServiceAgreementVO> list(@Validated @RequestBody ServiceAgreementQueryPageDTO serviceAgreementQueryPageDTO) {
        PageResult<ServiceAgreementVO> pageResult = serviceAgreementService.list(serviceAgreementQueryPageDTO);
        return PageResult.success(pageResult.getData(), pageResult.getTotal());
    }

    /**
     * 上传规则描述文件
     *
     * @param file
     * @param enumRuleExcel
     * @return
     */
    @PostMapping(value = "/uploadRuleExcel")
    public Result<UploadRuleExcelVO> uploadRuleExcel(@RequestParam("file") MultipartFile file, @RequestParam("ruleExcel") EnumRuleExcel enumRuleExcel) {
        if (file.isEmpty()) {
            return Result.fail("文件不能为空");
        }
        String xlsxSuffix = ".xlsx";
        String originalFilename = file.getOriginalFilename();
        if (!originalFilename.endsWith(xlsxSuffix)) {
            return Result.fail("excel暂时只支持xlsx");
        }

        return Result.success(serviceAgreementService.uploadRuleExcel(file, enumRuleExcel));
    }


    /**
     * 规约保存
     *
     * @param serviceAgreementSaveDTO
     * @return
     */
    @PostMapping(value = "/save")
    public Result<Boolean> save(@Validated @RequestBody ServiceAgreementSaveDTO serviceAgreementSaveDTO) {
        serviceAgreementService.save(serviceAgreementSaveDTO);
        return Result.success(Boolean.TRUE);
    }

    /**
     * 规约修改
     *
     * @param serviceAgreementUpdateDTO
     * @return
     */
    @PostMapping(value = "/edit")
    public Result<Boolean> edit(@Validated @RequestBody ServiceAgreementUpdateDTO serviceAgreementUpdateDTO) {
        serviceAgreementService.edit(serviceAgreementUpdateDTO);
        return Result.success(Boolean.TRUE);
    }

}