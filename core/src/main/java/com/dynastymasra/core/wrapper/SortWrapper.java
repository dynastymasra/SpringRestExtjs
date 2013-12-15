package com.dynastymasra.core.wrapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;

/**
 * Deny Prasetyo, S.T.
 * jasoet87@gmail.com
 * [at] jasoet
 * github.com/jasoet
 * bitbucket.org/jasoet
 */
public class SortWrapper {

    private String direction;
    private String property;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public static Sort convertToSort(String sortJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<SortWrapper> sorts = null;
        try {
            sorts = objectMapper.readValue(sortJson, new TypeReference<List<SortWrapper>>() {
            });
        } catch (IOException e) {

        }
        Sort result = null;

        for (SortWrapper sw : sorts) {
            if (result == null) {
                result = new Sort(Sort.Direction.valueOf(sw.direction), sw.property);
            } else {
                result = result.and(new Sort(Sort.Direction.valueOf(sw.direction), sw.property));
            }
        }

        return result;
    }

}
