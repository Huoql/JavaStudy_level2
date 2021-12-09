package com.study.springboot;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

public class NvlFunction extends AbstractFunction {
    @Override
    public String getName() {
        return "nvl";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number number1 = FunctionUtils.getNumberValue(arg1, env);
        Number number2 = FunctionUtils.getNumberValue(arg2, env);
        if (number1 != null) {
            return new AviatorDecimal(number1);
        }
        return new AviatorDecimal(number2);
    }
}
