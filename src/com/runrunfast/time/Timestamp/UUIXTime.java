package com.runrunfast.time.Timestamp;

import java.text.ParseException;

/**
 * <p>@Author: james</p>
 * <p>@Description: UUIX时间戳</P>
 * <p>@Date: 创建日期 2018/11/13 16:08</P>
 * <p>@version V1.0</p>
 **/
public class UUIXTime {


    /*** \_____________________________/
     * <p>@author       |   james</p>
     * <p> @param       |   MaxNumberOfDigits 最大位数 </p>
     * <p>@return       |   java.lang.String</P>
     * <p>@date         |   2018/11/13 16:48</P>
     * <p>@description  |   获取系统时间戳,默认11位</p>
     ***/
    public static String getUUIXTime(){
        return String.valueOf(System.currentTimeMillis() / 1000);
    }


    /*** \_____________________________/
     * <p>@author       |   james</p>
     * <p> @param       |   time uuix时间 </p>
     * <p> @param       |   format 时间格式 </p>
     * <p>@return       |   java.lang.String</P>
     * <p>@date         |   2018/11/13 16:48</P>
     * <p>@description  |   添加说明</p>
     ***/
    public static String ParesUUIX(String time,String format) throws ParseException {
        Long timestamp = Long.parseLong(time) * 1000;
        if(null == format || "".equals(format)){
            format = "yyyy-MM-dd";
        }
        String date = new java.text.SimpleDateFormat(format).format(new java.util.Date(timestamp));
        return date;
    }
}
