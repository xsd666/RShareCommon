package com.run.rshare.common.agreement.AgreementFunction.function;

import cn.hutool.core.lang.UUID;

/**
 * @ClassName NowFunction
 * @Description: 获取时间
 * @Author xsd
 * @Date 2023/9/3
 * @Version V1.0
 **/
public class UuidFunction implements Function {

    /**
     * 获取值
     *
     * @return
     */
    @Override
    public Object getVal() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
