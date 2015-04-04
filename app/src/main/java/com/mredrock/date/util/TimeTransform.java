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
    Calendar currentTime;

    public TimeTransform(long timestamp){
        currentTime=new GregorianCalendar();
        currentTime.setTime(new Date(timestamp*1000));
    }
    public TimeTransform(int year,int month,int day){
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
    public String getString(String formatString){
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

    public String getRecentTimeString(){
        long delta = (System.currentTimeMillis() - currentTime.getTime().getTime())/1000;
        if (delta / 60 < 60){
            return delta / 60+"分钟前";
        }else if(delta / 3600 < 12){
            return delta / 60+"小时前";
        }else{
            return getString("yyyy-MM-dd  hh:mm");
        }
    }

}
