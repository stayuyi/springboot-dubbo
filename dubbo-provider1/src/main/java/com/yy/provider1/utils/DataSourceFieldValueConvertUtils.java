package com.yy.provider1.utils;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class DataSourceFieldValueConvertUtils {
    public static final String ARRAY_FLAG="_0_";
    /**
     * 当字段类型 与 值 类型 不匹配时,转换值 类型
     * @param code
     * @param obj
     * @return
     */
    public static Object convertValue2JsonArry(String code,Object obj){
        if(StringUtils.isBlank(code) || obj==null || !code.contains(ARRAY_FLAG)){
            return obj;
        }
        int i=countArryLength(code);
        log.info("convertValue2JsonArry ,field is arry ,code:{},value:{}",code,obj.toString());
        JSONArray newArray=new JSONArray();
        switch (i){
            case 1 :
                if(obj instanceof JSONArray){
                    newArray=(JSONArray)obj;
                }else{
                    newArray.add(obj.toString());
                }
                break;
            case 2 :
                if(obj instanceof JSONArray){
                    JSONArray array=(JSONArray)obj;
                    for(Object o:array){
                        if(null ==o || o instanceof JSONArray){
                            newArray.add(o);
                        }else{
                            JSONArray a=new JSONArray();
                            a.add(o);
                            newArray.add(a);
                        }
                    }
                }else{
                    JSONArray a=new JSONArray();
                    a.add(obj);
                    newArray.add(a);
                }
                break ;
            case 3 :
                if(obj instanceof JSONArray){
                    JSONArray array=(JSONArray)obj;
                    for(Object o1 : array){
                        if(o1==null){
                            newArray.add(o1);
                        } else if(o1 instanceof JSONArray){
                            JSONArray a1=new JSONArray();
                            JSONArray jsonArray=(JSONArray) o1;
                            for(Object o2:jsonArray){
                                if(o2 ==null || o2 instanceof JSONArray){
                                    a1.add(o2);
                                }else{
                                    JSONArray a2=new JSONArray();
                                    a2.add(o2);
                                    a1.add(a2);
                                    newArray.add(a1);
                                }
                            }
                        }else{
                            JSONArray a=new JSONArray();
                            a.add(o1);
                            JSONArray b=new JSONArray();
                            b.add(a);
                            newArray.add(b);
                        }
                    }
                }else{
                    JSONArray a=new JSONArray();
                    a.add(obj);
                    JSONArray b=new JSONArray();
                    b.add(a);
                    newArray.add(b);
                };
            default: break;
        }
        return newArray;
    }

    /**
     * 获取 字段 数组层级 数
     * @param value
     * @return
     */
    public static int countArryLength(String value){
        int count=0;
        if(StringUtils.isBlank(value) || !value.contains(ARRAY_FLAG)){
            return count;
        }
        String[] arr=value.split(ARRAY_FLAG);
        return arr.length-1;
    }

}
