package com.example.webmagic.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 尹欣
 * @version V1.0
 * @Title: GsonFactory
 * @Package com.lk.sydn.knowledge.util
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/3/16 15:30
 **/
public class GsonFactory {
    private static final GsonBuilder gsonBuilder = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            if (field.getAnnotation(GsonSkip.class) instanceof GsonSkip) {
                return true;
            }
            return false;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            if (clazz.getAnnotation(GsonSkip.class) instanceof GsonSkip) {
                return true;
            }
            return false;
        }
    }).serializeNulls().disableHtmlEscaping();

    private static final Gson gson = gsonBuilder.create();

    public static GsonBuilder getGsonBuilder() {
        return gsonBuilder;
    }

    public static Gson getGson() {
        return gson;
    }

    public static String getJson(String key,Object object) {
        Map<String, Object> map = new HashMap<>();
        map.put(key,object);
        String json = "";
        if (map != null) {
            json = getGson().toJson(map);
        }
        return json;
    }
}
