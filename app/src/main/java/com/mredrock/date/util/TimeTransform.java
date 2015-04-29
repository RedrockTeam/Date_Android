package com.mredrock.date.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Mr.Jude on 2015/4/3.
 */
public class TimeTransform {
    public static final int SECOND = 60;
    public static final int HOUR = 3600;
    public static final int DAY = 86400;
    public static final int WEEK = 604800;


    Calendar currentTime;

    public TimeTransform(){
        currentTime=new GregorianCalendar();
        currentTime.setTime(new Date());
    }
    public TimeTransform(long timestamp){
        currentTime=new GregorianCalendar();
        currentTime.setTime(new Date(timestamp*1000));
    }
    public TimeTransform(int year, int month, int day){
        currentTime=new GregorianCalendar(year,month,day);
    }

    public int getDay(){
        return currentTime.get(Calendar.DATE);
    }
    public int getMonth(){
        return currentTime.get(Calendar.MONTH)+1;
    }
    public int getYear(){
        return currentTime.get(Calendar.YEAR);
    }
    public long getTimestamp(){
        return currentTime.getTime().getTime()/1000;
    }

    /**
     * 格式化输出日期
     * 年:y		月:M		日:d		时:h(12制)/H(24值)	分:m		秒:s		毫秒:S
     * @param formatString
     */
    public String toString(String formatString){
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        String date = format.format(currentTime.getTime());
        return date;
    }


    /**
     * 格式化解析日期文本
     * 年:y		月:M		日:d		时:h(12制)/H(24值)	分:m		秒:s		毫秒:S
     * @param formatString
     */
    public TimeTransform parse(String formatString,String content){
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        try {
            currentTime.setTime(format.parse(content));
            return this;
        } catch (ParseException e) {
            return null;
        }
    }

    public interface DateFormater{
        public String format(TimeTransform date, long delta);
    }
    public String toString(DateFormater formater){
        long delta = (System.currentTimeMillis() - currentTime.getTime().getTime())/1000;
        return formater.format(this,delta);
    }

    public String getRecentTimeString(String...format){
        long delta = (System.currentTimeMillis() - currentTime.getTime().getTime())/1000;

        switch (format.length){
            case 5:
                long week = delta / 60 /60 / 24 / 7;
                if (week > 0){
                    return week+format[4];
                }
            case 4:
                long day = delta / 60 / 60 / 24;
                if (day > 0){
                    return day+format[3];
                }
            case 3:
                long hour = delta / 60 / 60;
                if (hour > 0){
                    return hour+format[2];
                }
            case 2:
                long minute = delta / 60;
                if (minute > 0){
                    return minute+format[1];
                }
            case 1:
                return delta+format[0];
        }
        return null;
    }

}
