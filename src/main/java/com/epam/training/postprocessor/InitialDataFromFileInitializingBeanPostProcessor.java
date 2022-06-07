package com.epam.training.postprocessor;

import com.epam.training.utils.FileParser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.text.ParseException;

public class InitialDataFromFileInitializingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("storage")) {
            Field[] declaredFields = bean.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (field.getName().equals("userStorage")) {
                    try {
                        ReflectionUtils.setField(field, bean, FileParser.parseUsers());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (field.getName().equals("ticketStorage")) {
                    try {
                        ReflectionUtils.setField(field, bean, FileParser.parseTickets());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                if (field.getName().equals("eventStorage")) {
                    try {
                        ReflectionUtils.setField(field, bean, FileParser.parseEvents());
                    } catch (FileNotFoundException | ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
