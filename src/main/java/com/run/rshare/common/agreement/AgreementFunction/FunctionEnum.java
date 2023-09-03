package com.run.rshare.common.agreement.AgreementFunction;

import com.run.rshare.common.agreement.AgreementFunction.function.Function;
import com.run.rshare.common.agreement.AgreementFunction.function.NowFunction;
import com.run.rshare.common.agreement.AgreementFunction.function.UuidFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EnumFunction
 * @Description: 函数
 * @Author xsd
 * @Date 2023/9/2
 * @Version V1.0
 **/
public enum FunctionEnum {
    //13位时间戳
    now("now",new UuidFunction()),
    //uuid
    uuid("uuid",new NowFunction());

    private static Logger LOG = LoggerFactory.getLogger(FunctionEnum.class);
    private static Map<String, FunctionEnum> functionEnumMap = new HashMap<>();

    static {
        for (FunctionEnum functionEnum : FunctionEnum.values()) {
            functionEnumMap.put(functionEnum.getCode(), functionEnum);
        }
    }

    private String code;

    private Function function;

    FunctionEnum(String code, Function function) {
        this.code = code;
        this.function = function;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public static Object getVal(String code) {
        if (!functionEnumMap.containsKey(code)) {
            LOG.error("暂时不支持此函数[{}]", code);
            return null;
        }
        return functionEnumMap.get(code).getFunction().getVal();
    }

}
