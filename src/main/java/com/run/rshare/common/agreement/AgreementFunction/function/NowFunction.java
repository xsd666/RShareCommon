package com.run.rshare.common.agreement.AgreementFunction.function;

/**
 * @ClassName NowFunction
 * @Description: now
 * @Author xsd
 * @Date 2023/9/3
 * @Version V1.0
 **/
public class NowFunction implements Function {
    /**
     * 获取值
     *
     * @return
     */
    @Override
    public Object getVal() {
        return System.currentTimeMillis();
    }
}
