package com.example.SpringBoot.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author lingjun.jlj
 * @date 2017/12/2
 * 时间转换工具类
 */
public class DateFormatUtils {

    /**
     * date转换String方法类
     * @param date
     * @param patter  时间格式
     * @return String
     * */
    public String DateToString(Date date, String patter){
        SimpleDateFormat sdf=new SimpleDateFormat(patter);
        return sdf.format(date);
    }

    /**
     * String转换date方法类
     * @param obj
     * @param patter  时间格式
     * @return date
     * */
    public Date DateToString(String obj, String patter){
        SimpleDateFormat sdf=new SimpleDateFormat(patter);
        Date date = null;
        try {
            date = sdf.parse(obj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Date转LocalDateTime
     * @param date
     * */
    public LocalDateTime DateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * Date转LocalDate
     * @param date
     * */
    public LocalDate DateToLocalDate(Date date){
        return this.DateToLocalDateTime(date).toLocalDate();
    }

    /**
     * LocalDateTime转Date
     * @param time
     * */
    public Date LocalDateTimeToDate(LocalDateTime time){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = time.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     LocalDateTime转Date
     * @param time
     * */
    public Date LocalDateToDate(LocalDate time){
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = time.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * LocalDateTime转String
     * @param localDateTime
     *@param patter
     * */
    public String LocalDateTimeToString(LocalDateTime localDateTime,String patter){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(patter);
        LocalDateTime time = LocalDateTime.now();
        return df.format(localDateTime);
    }

    /**
     * String转LocaDateTime
     * @param obj
     * */
    public LocalDateTime StringToLocalDateTime(String obj){
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(obj,DATEFORMATTER);
        return localDateTime;
    }
    /**
     * String转LocaDate
     * @param obj
     * */
    public LocalDate StringToLocalDate(String obj){
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(obj,DATEFORMATTER);
        return localDate;
    }
}
