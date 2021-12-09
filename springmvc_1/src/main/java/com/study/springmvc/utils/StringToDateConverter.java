package com.study.springmvc.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器，把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date>{

    /**
     * s指传入进来的字符串
     *
     * @param s
     * @return
     */
    public Date convert(String s) {
        if(s==null) {
            throw new RuntimeException("请您传入数据！");
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                //将字符串转换成日期
                return sdf.parse(s);
            } catch (Exception e) {
                throw new RuntimeException("数据类型转换出现错误");
            }
        }
    }
}
