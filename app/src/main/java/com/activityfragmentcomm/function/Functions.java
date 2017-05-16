package com.activityfragmentcomm.function;


import java.util.HashMap;

/**
 * key为Fragment的标示
 * value为回调函数
 */
public class Functions{

    private HashMap<String,FunctionWithParamAndResult> mFunctionWithParamAndResults ;

    public static class Function{
        String functionName;
        public Function(String functionName){
            this.functionName = functionName;
        }
    }

    /**带有参数和返回值的抽象方法的类*/
    public static abstract class FunctionWithParamAndResult<Param,Result> extends Function{

        public FunctionWithParamAndResult(String functionName) {
            super(functionName);
        }

        public abstract Result function(Param param);
    }


    /**添加带参数的函数*/
    public Functions addFunction(FunctionWithParamAndResult function){
        if(function == null){
            return this;
        }
        if(mFunctionWithParamAndResults == null){
            mFunctionWithParamAndResults = new HashMap<>();
        }
        mFunctionWithParamAndResults.put(function.functionName,function);
        return this;
    }

    /** 调用具有参数的函数*/
    public <Param, Result> Result invokeFunction(String funcName, Class<Result> classofR,
                                                 Param param)throws NoFunctionException {
        FunctionWithParamAndResult func = null;
        if(mFunctionWithParamAndResults != null){
            func = mFunctionWithParamAndResults.get(funcName);
            if(func != null){
                if(classofR != null){
                    return classofR.cast(func.function(param));//安全的
                }
                return (Result)func.function(param);
            } else {
                throw new NoFunctionException("has no Function：" + funcName
                        + "found in FunctionWithParamAndResult");
            }
        }
        return null;
    }
}


