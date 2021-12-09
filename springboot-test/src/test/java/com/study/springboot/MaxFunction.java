package com.study.springboot;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Arrays;
import java.util.Map;

public class MaxFunction extends AbstractVariadicFunction {
    @Override
    public AviatorObject variadicCall(Map<String, Object> map, AviatorObject... aviatorObjects) {
        double v = Arrays.stream(aviatorObjects).map(arg -> {
            return FunctionUtils.getNumberValue(arg, map).doubleValue();
        }).mapToDouble(Double::doubleValue).max().getAsDouble();

        return AviatorDecimal.valueOf(v);
    }

    @Override
    public String getName() {
        return "max";
    }
}
