package com.yy.provider1.enumtest;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yuyi on 2019/1/25.
 */

public class EnumUtils {
    public static <T extends Enum<T>> int getEnumOnValue(Class<T> enumType, int value) throws Exception {
        for (Object obj : enumType.getEnumConstants()) {
            Method m = obj.getClass().getDeclaredMethod("getHigh", null);
            int highscore = (int) m.invoke(obj, null);

            m = obj.getClass().getDeclaredMethod("getLower", null);
            int lowerScore = (int) m.invoke(obj, null);

            m = obj.getClass().getDeclaredMethod("getScore", null);
            int score = (int) m.invoke(obj, null);
            if (value == -1 && lowerScore == -1) {
                return score;
            }
            if (value > lowerScore && value <= highscore) {
                return score;
            }
        }
        return 0;
    }

//传入方法名称  values是值 ，field是 字段mingcheng
    public static <T extends Enum<T>> T getEnumOnValue(Class<T> enumType, String value, String field) throws Exception {

        for (Object obj : enumType.getEnumConstants()) {
            Method m = obj.getClass().getDeclaredMethod("values", null);
            Object[] results = (Object[]) m.invoke(obj, null);
            for (Object result : results) {
                Field codeField = result.getClass().getDeclaredField(field);
                ReflectionUtils.makeAccessible(codeField);
                String fileValue = String.valueOf(ReflectionUtils.getField(codeField, result));
                if (fileValue.equals(value)) {
                    return (T) result;
                }

            }
        }
        return null;
    }
}
