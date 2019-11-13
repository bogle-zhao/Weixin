package com.bogle.weixin.component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * JSON系列化对象
 * Created by lenovo on 2015/11/21.
 */
public class JSONUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 将byte转化为指定的对象
     * @param bytes
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T readValue(byte[] bytes, Class<T> t) {
        try {
            return objectMapper.readValue(bytes, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将byte转化为指定的对象
     * @param src
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public static <T> T readValue(byte[] src, TypeReference valueTypeRef) {
        try {
            return objectMapper.readValue(src, valueTypeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将对象转换为json字符串
     * @param target
     * @return
     */
    public static String writeValueAsString(Object target) {
        try {
            return objectMapper.writeValueAsString(target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
