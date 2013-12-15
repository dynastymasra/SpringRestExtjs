package com.dynastymasra.core.wrapper;

import com.dynastymasra.core.domain.JsonStringable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.domain.Page;

import java.util.Map;

public class PageJsonWrapper<T extends JsonStringable> {

    private Page<T> page;
    private Class<T> baseClass;

    public PageJsonWrapper(Page<T> page, Class<T> baseClass) {
        this.page = page;
        this.baseClass = baseClass;
    }

    public PageJsonWrapper(Page<T> page) {
        this.page = page;
    }

    @SuppressWarnings("unchecked")
    public String toJsonString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            if (baseClass != null) {
                Map<Class<?>, Class<?>> mixin = baseClass.newInstance().getDefaultMixin();
                if (mixin != null) {
                    objectMapper.setMixInAnnotations(mixin);
                }
            }

            return objectMapper.writeValueAsString(page);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception " + e.getMessage();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return "Exception " + e.getMessage();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "Exception " + e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public String toJsonString(Map<Class<?>, Class<?>> mixin) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            if (mixin != null) {
                objectMapper.setMixInAnnotations(mixin);
            }

            return objectMapper.writeValueAsString(page);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception " + e.getMessage();
        }
    }

}
