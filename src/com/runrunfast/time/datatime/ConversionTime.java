package com.runrunfast.time.datatime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>@Author: james</p>
 * <p>@Description: date普通时间格式转换类</P>
 * <p>@Date: 创建日期 2018/11/13 17:12</P>
 * <p>@version V1.0</p>
 **/
public class ConversionTime {


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   date 自定义时间 </p>
     * <p> @param       |   format 使用者给定时间格式 </p>
     * <p>@return       |   java.lang.String</P>
     * <p>@date         |   2018/11/13 17:45</P>
     * <p>@description  |   此方法是getStringDate()和getIntDate()的返回值封装方法</p>
     ***/
    private static String getStr(Date date,String format){
        //返回的时间
        String time = null;
        //判断format是否为空
        if(null == format || "".equals(format)){
            //知道默认的时间格式
            format = "yyyy年MM月dd日";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        //判断有没有date
        if(null == date){
            time = formatter.format(new Date());
        }else{
            time = formatter.format(date);
        }
        return time;
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   format 自定义时间 </p>
     * <p>@return       |   java.lang.String</P>
     * <p>@date         |   2018/11/13 17:17</P>
     * <p>@description  |   传入Date参数和时间格式，返回String时间</p>
     ***/
    public static String getStringDate(Date date,String format) {
        return ConversionTime.getStr(date,format);
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   date 系统时间 </p>
     * <p> @param       |   format 转换的时间格式 </p>
     * <p>@return       |   java.lang.Integer</P>
     * <p>@date         |   2018/11/13 17:43</P>
     * <p>@description  |   传入Date参数，返回Integer时间</p>
     ***/
    public static Integer getIntDate(Date date) {
        return Integer.valueOf(ConversionTime.getStr(date,"yyyyMMdd"));
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   format 时间格式 </p>
     * <p> @param       |   value 字符串时间 </p>
     * <p>@return       |   java.util.Date</P>
     * <p>@date         |   2018/11/13 18:04</P>
     * <p>@description  |   根据时间格式和字符串时间，返回Date格式的时间</p>
     ***/
    public static Date getDate(String format,String value) throws ParseException {
        DateFormat df=new SimpleDateFormat(format);
        return df.parse(value);
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   format 时间格式 </p>
     * <p>@return       |   java.util.Date</P>
     * <p>@date         |   2018/11/13 18:09</P>
     * <p>@description  |   传入时间格式，放回当前系统日期，date格式</p>
     ***/
    public static Date getSystemDate(String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.parse(df.format(new Date()));
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   format 时间格式 </p>
     * <p>@return       |   java.util.Date</P>
     * <p>@date         |   2018/11/13 18:09</P>
     * <p>@description  |   传入时间格式，放回当前系统日期，date格式</p>
     ***/
    public static String getSystemDateStr(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   nowTime     当前时间 </p>
     * <p> @param       |   startTime   开始时间 </p>
     * <p> @param       |   endTime     结束时间 </p>
     * <p>@return       |   boolean</P>
     * <p>@date         |   2018/11/13 18:20</P>
     * <p>@description  |   判断当前时间是否在[startTime, endTime]区间，时间格式要保持一致</p>
     ***/
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime() || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        //当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        //开始时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        //结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        //判断当前时间是否在开始时间之后并且当前时间是否在结束时间之前
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   nowTime 当前时间 </p>
     * <p> @param       |   endTime 结束时间 </p>
     * <p>@return       |   boolean</P>
     * <p>@date         |   2018/11/13 18:25</P>
     * <p>@description  |   判断当前时间是否在结束时间之前</p>
     ***/
    public static boolean isBefore(Date nowTime ,Date endTime){
        if (nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        //当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        //结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        //当前时间 < 结束时间 返回true
        if (date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   nowTime 当前时间 </p>
     * <p> @param       |   endTime 结束时间 </p>
     * <p>@return       |   boolean</P>
     * <p>@date         |   2018/11/13 18:31</P>
     * <p>@description  |   判断当前时间是否在结束时间之后</p>
     ***/
    public static boolean isAfter(Date nowTime ,Date endTime){
        if (nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        //当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        //结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        //当前时间 > 结束时间 返回true
        if (date.after(end)) {
            return true;
        } else {
            return false;
        }
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   date UTC时间 </p>
     * <p>@return       |   java.util.Date</P>
     * <p>@date         |   2018/11/13 18:34</P>
     * <p>@description  |   将UTC时间转换成yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ时间格式</p>
     ***/
    public static Date getTransitionTimeZone(Date date) throws ParseException {
        //注意是空格+UTC
        String dates = date.toString().replace("Z", " UTC");
        //注意格式化的表达式
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ");
        try {
            Date d = format.parse(dates);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   date 当前系统时间 </p>
     * <p>@return       |   int</P>
     * <p>@date         |   2018/11/13 18:45</P>
     * <p>@description  |   获取年份</p>
     ***/
    public static int getYear(Date date){
        Calendar cal = Calendar.getInstance();
        //如果date为空，就取当前年
        if(date == null){
            return cal.get(Calendar.YEAR);
        }
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   date 当前系统时间 </p>
     * <p>@return       |   int</P>
     * <p>@date         |   2018/11/13 18:45</P>
     * <p>@description  |   获取月份</p>
     ***/
    public static int getMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   date 当前系统时间 </p>
     * <p>@return       |   int</P>
     * <p>@date         |   2018/11/13 18:46</P>
     * <p>@description  |   获取天</p>
     ***/
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   minDate 开始时间 </p>
     * <p> @param       |   maxDate 结束时间 </p>
     * <p>@return       |   java.util.List<java.lang.String></P>
     * <p>@date         |   2018/11/13 18:49</P>
     * <p>@description  |   获取两个时间之间所有的月份</p>
     ***/
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        //格式化为年月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }


    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p> @param       |   bigtime 开始时间 </p>
     * <p> @param       |   endtime 结束时间 </p>
     * <p>@return       |   java.util.List<java.util.Date> </P>
     * <p>@date         |   2018/11/13 18:47</P>
     * <p>@description  |   获取两个时间区间的每一天 </p>
     ***/
    public static List<Date> getDateIntervalString(Date bigtime, Date endtime){
        //定义一个接受时间的集合
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(bigtime);
        Calendar calBegin = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(bigtime);
        Calendar calEnd = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(endtime);
        //测试此日期是否在指定日期之后
        while (endtime.after(calBegin.getTime()))  {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p>@param        |   beginDate 开始时间 </p>
     * <p>@param        |   endDate 结束时间 </p>
     * <p>@return       |   long</P>
     * <p>@date         |   2018/11/14 9:28</P>
     * <p>@description  |   返回两个时间相距有多少天</p>
     ***/
    public static long getDaySub(Date beginDate, Date endDate) {
        long day = 0;
        try {
            if (endDate == null) {
                return day;
            }
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    /*** \_____________________________/
     * <p>@author       |   James</p>
     * <p>@param        |   datetime 格式：yyyy-MM-dd 或 yyyy/MM/dd </p>
     * <p>@return       |   java.lang.String</P>
     * <p>@date         |   2018/11/14 9:33</P>
     * <p>@description  |   根据时间，获取所属季度</p>
     ***/
    public static String dataToQuarter(String datetime){
        //开始校验时间格式长度
        if(datetime.length() > 10){
            return "传入的时间格式错误";
        }
        //获取时间的月份
        String month = datetime.substring(5,7);
        //判断使用者输入的月份格式是否错误
        String regex = "^(0[1-9])|(1[0-2])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(month);
        if(!matcher.matches()){
            return "传入的时间格式错误";
        }
        String quarter = null;
        String[][] quarters = {{"01,02,03","04,05,06","07,08,09","10,11,12"},{"一季度","二季度","三季度","四季度"}};
        for(int i = 0;i < quarters[0].length; i++){
            //判断一维数组的值
            if(quarters[0][i].contains(month)){
                //获取二位数组的值
                quarter = quarters[1][i];
                break;
            }
        }
        return quarter;
    }

    public static String dateToWeek(String datetime) throws ParseException {

        String[] weekDays = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

        // 获得一个日历
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date datet = simpleDateFormat.parse(datetime);

        cal.setTime(datet);

        // 指示一个星期中的某天。
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;

        if (w < 0) {
            w = 0;
        }

        return weekDays[w];
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(dateToWeek("2018-11-02 10:10"));
    }
}
