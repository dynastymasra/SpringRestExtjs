package com.dynastymasra.core.service;


import com.dynastymasra.core.domain.Property;
import com.dynastymasra.core.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Deny Prasetyo,S.T
 * Java(Script) and Rails Developer
 * Software Engineer | PT. NetXcel Systems Indonesia
 * jasoet87@gmail.com
 * dprasetyo@netxcel.com.sg | www.netxcel.com.sg
 * <p/>
 * http://github.com/jasoet
 * http://bitbucket.com/jasoet
 *
 * @jasoet
 */
@Service(value = "propertyService")
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Date getPropertyValueAsDate(String key, String pattern) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            if (!propertyRepository.exists(key)) {
                propertyRepository.save(new Property(key, ""));
                return null;
            } else {
                Property result = propertyRepository.findOne(key);
                if (result != null) {
                    return sdf.parse(result.getValue());
                } else {
                    return null;
                }
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public String getPropertyValue(String key) {
        try {
            if (!propertyRepository.exists(key)) {
                return propertyRepository.save(new Property(key, "")).getValue();
            } else {
                Property result = propertyRepository.findOne(key);
                if (result != null) {
                    return result.getValue();
                } else {
                    return "";
                }
            }
        } catch (Exception ex) {
            return "";
        }
    }

    public Property setPropertyValue(String key, String value) {
        try {
            if (!propertyRepository.exists(key)) {
                return propertyRepository.save(new Property(key, value));
            } else {
                Property result = propertyRepository.findOne(key);
                if (result != null) {
                    result.setValue(value);
                    propertyRepository.save(result);
                    return result;
                } else {
                    return null;
                }
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public Property setPropertyValueAsDate(String key, Date date, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String value = sdf.format(date);
            if (!propertyRepository.exists(key)) {
                return propertyRepository.save(new Property(key, value));
            } else {
                Property result = propertyRepository.findOne(key);
                if (result != null) {
                    result.setValue(value);
                    propertyRepository.save(result);
                    return result;
                } else {
                    return null;
                }
            }
        } catch (Exception ex) {
            return null;
        }
    }
}
