package com.yy.provider1.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonConverterUtil {
    /*
    把String [{"A":"a1", "B":"a1"}, {"A":"a2", "B":"b2"}, {"A":"a3", "B":"b3"}]  转成 {"A":["a1","a2","a3"],"B":["a1","b2","b3"]} JsonObject
   */
    public static JSONObject jsonForBuilder(String jsonArray) {
        Map<String, List<String>> map = new HashMap<>();
        JSONArray array = JSON.parseArray(jsonArray);
        array.forEach(e -> {
            JSONObject jsonObject = (JSONObject) e;
            jsonObject.forEach((key, value) -> {
                List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
                list.add(jsonObject.getString(key));
            });
        });
        return (JSONObject) JSON.toJSON(map);
    }

}
