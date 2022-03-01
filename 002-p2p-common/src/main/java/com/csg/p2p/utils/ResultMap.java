package com.csg.p2p.utils;

import java.util.HashMap;

/**
 * ClassName:Result
 * Package:com.csg.p2p.utils
 * Description:
 *
 * @date: 2022/1/5 19:12
 * @author: csg
 */
public class ResultMap extends HashMap<String, Object> {

    /*
    *  前后端交互成功返回的方法
    * */
    public static ResultMap success(){
        ResultMap resultMap = new ResultMap();
        resultMap.put("code",1);
        resultMap.put("message","");
        resultMap.put("success",true);
        return resultMap;
    }

    /*
     *  前后端交互失败返回的方法
     * */
    public static ResultMap error(String msg){
        ResultMap resultMap = new ResultMap();
        resultMap.put("code",-1);
        resultMap.put("message",msg);
        resultMap.put("success",false);
        return resultMap;
    }
}
