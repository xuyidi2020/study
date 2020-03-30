package com.study.utils;


import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String DATE_FORMAT2 = "yyyy/MM/dd";

    private static final String MONTH_FORMAT = "yyyy-MM";

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String HMS_FORMAT = "HH:mm:ss";

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";

    private static final String DATE_FORMAT3 = "yyyy/MM/dd HH:mm";
    private static final String DATETIMEHM_FORMAT = "yyyyMMddHHmm";

    private static final String CHINADATE_FORMAT = "yyyy年M月dd日";

    private static final String CHINAMONTH_FORMAT = "yyyy年M月";

    private static final String DATETIMEHMS_FORMAT = "yyyyMMddHHmmss";

    private static final String DATETIMEYMD_FORMAT = "yyyyMMdd";

    private static final String TIME_FORMAT_ALL = "yyyy-MM-dd HH:mm:ss SSS";

    private static final String TIME_FORMAT_VERSION = "yyyyMMddHHmmssSSS";

    private static final String CHINADATETIME_FORMAT = "yyyy年MM月dd日HH时mm分ss秒";

    private static final String CHINADATETIME_FORMAT2 = "yyyy年MM月dd日 HH时mm分";

    public static final String DAY = "day";

    public static final String WEEK = "week";

    public static final String MONTH = "month";

    public static final String START = "start";

    public static final String END = "end";

    private static final String YEAR_MONTH_FORMAT = "yyyy-MM";

    private static final String CHINADATE_FORMAT_MONTH = "MM月dd日";

    private static Map<Integer, String> weekMap = Collections
            .synchronizedMap(new HashMap<Integer, String>());

    static {
        weekMap.put(1, "星期一");
        weekMap.put(2, "星期二");
        weekMap.put(3, "星期三");
        weekMap.put(4, "星期四");
        weekMap.put(5, "星期五");
        weekMap.put(6, "星期六");
        weekMap.put(7, "星期日");
    }

    public static String convertToDateTime(Date date) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(date);
    }

    public static Date convertStringToDate(String date) throws ParseException {
        return new SimpleDateFormat(DATETIME_FORMAT).parse(date);
    }

    public static Date convertStringToDate(String date, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(date);
    }

    public static Date converStringToDate1(String date) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT3).parse(date);
    }

    public static Date convertToTime(String value) throws ParseException {
        return new SimpleDateFormat(TIME_FORMAT).parse(value);
    }

    public static String convertToMonth(Date date) {
        return new SimpleDateFormat(MONTH_FORMAT).format(date);
    }

    public static Date convertToDateTimeHMS(String value) throws ParseException {
        return new SimpleDateFormat(DATETIMEHMS_FORMAT).parse(value);
    }

    public static Date convertToTimes(String value) throws ParseException {
        return new SimpleDateFormat(DATE_FORMAT).parse(value);
    }

    public static Date convertToMonth(String value) throws ParseException {
        return new SimpleDateFormat(CHINAMONTH_FORMAT).parse(value);
    }

    public static Date convertDateFormTimestamp(String value) {
        return new Date(Long.valueOf(value));
    }


    public static String convertToDate(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static Date parseDate(String value) throws ParseException {
        if (value.contains("/")) {
            return new SimpleDateFormat(DATE_FORMAT2).parse(value);
        }
        return new SimpleDateFormat(DATE_FORMAT).parse(value);
    }

    public static String convertToTime(Date date) {
        return new SimpleDateFormat(TIME_FORMAT).format(date);
    }

    public static String convertToAllTime(Date date) {
        return new SimpleDateFormat(TIME_FORMAT_ALL).format(date);
    }

    public static String convertToVersion(Date date) {
        return new SimpleDateFormat(TIME_FORMAT_VERSION).format(date);
    }

    public static String convertToAppDateTime(Date date) {
        //设置基础时间为格林威治时间
        TimeZone gmtTz = TimeZone.getTimeZone("GMT");
        //设置时间字符串格式
        SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT_ALL);
        df.setTimeZone(gmtTz);
        //设置目的时间时
        return df.format(date);
    }

    /**
     * 将当前时间转换为格林威志时间
     *
     * @param date
     * @return
     */
    public static Date converToUTCTime(Date date) {
        //设置基础时间为格林威治时间
        TimeZone gmtTz = TimeZone.getTimeZone("GMT");
        //设置时间字符串格式
        SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT_ALL);
        df.setTimeZone(gmtTz);
        //设置目的时间时

        Date resultDate = null;

        String oriDate = df.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_ALL);
        try {
            resultDate = sdf.parse(oriDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("时间转换异常");
        } finally {
            if (resultDate == null) {
                resultDate = new Date();
            }
        }

        return resultDate;
    }

    public static Date convertFromVersion(long version) throws ParseException {
        return new SimpleDateFormat(TIME_FORMAT_VERSION).parse(String.valueOf(version));
    }

    public static String convertToChinaDateTime(Date date) {
        return new SimpleDateFormat(CHINADATETIME_FORMAT).format(date);
    }

    public static String convertToChinaDateTime2(Date date) {
        return new SimpleDateFormat(CHINADATETIME_FORMAT2).format(date);
    }

    public static String convertToYearMonth(Date date) {
        return new SimpleDateFormat(YEAR_MONTH_FORMAT).format(date);
    }

    /**
     * Discription :获取时间的时分秒字符串
     *
     * @param date
     * @return String
     * @throws
     * @author : shendx
     */
    public static String convertToHMS(Date date) {
        return new SimpleDateFormat(HMS_FORMAT).format(date);
    }

    public static String convertToTimeHM(Date date) {
        return new SimpleDateFormat(DATETIMEHM_FORMAT).format(date);
    }

    public static String convertToChinaDate(Date date) {
        return new SimpleDateFormat(CHINADATE_FORMAT).format(date);
    }

    public static String convertToChinaDateMonth(Date date) {
        return new SimpleDateFormat(CHINAMONTH_FORMAT).format(date);
    }

    public static String convertToChinaMonthDate(Date date) {
        return new SimpleDateFormat(CHINADATE_FORMAT_MONTH).format(date);
    }

    public static String dayForWeek(Date pTime) {

        String chinaDate = new SimpleDateFormat(CHINADATE_FORMAT).format(pTime);
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return chinaDate + " " + weekMap.get(dayForWeek);
    }

    public static String getWeek(Date pTime) {

        String chinaDate = new SimpleDateFormat(CHINADATE_FORMAT).format(pTime);
        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return weekMap.get(dayForWeek);
    }

    public static int getWeekDay(Date pTime) {

        Calendar c = Calendar.getInstance();
        c.setTime(pTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    public static Date getFutureDateByDayNum(int num, Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(c.DATE, num);
        return c.getTime();
    }

    public static String convertToDateHMS(Date date) {
        return new SimpleDateFormat(DATETIMEHMS_FORMAT).format(date);
    }

    public static String convertToDateYMD(Date date) {
        return new SimpleDateFormat(DATETIMEYMD_FORMAT).format(date);
    }

    public static String getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.YEAR));

    }

    public static String getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH));
    }

    /**
     * 获取月份份
     * @param date
     * @return
     */
    public static String getFullMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH)+1);
    }

    /**
     * Discription :比较日期 startDate是否早于endDate
     *
     * @param startDate
     * @param endDate
     * @return boolean
     * @throws
     * @author : shendx
     * @date 2013-11-22 上午9:50:42
     */
    public static boolean isBeforeDateCompare(Date startDate, Date endDate) {
        boolean isBefore = false;
        try {
            if (startDate.before(endDate))
                isBefore = true;
        } catch (Exception e) {
            isBefore = false;
            e.printStackTrace();
        }
        return isBefore;
    }

    /**
     * Discription :比较日期 startDate是否晚于endDate
     *
     * @param startDate
     * @param endDate
     * @return boolean
     * @throws
     * @author : shendx
     * @date 2013-11-22 上午9:50:42
     */
    public static boolean isAfterDateCompare(Date startDate, Date endDate) {
        boolean isBefore = false;
        try {
            if (startDate.after(endDate))
                isBefore = true;
        } catch (Exception e) {
            isBefore = false;
            e.printStackTrace();
        }
        return isBefore;
    }

    /**
     * Discription :比较两个日期
     *
     * @param startDate
     * @param endDate
     * @return 0 表示相等 -1表示 start小于end 1表示start大于end int
     * @throws
     * @author : shendx
     * @date 2013-11-22 上午9:55:53
     */
    public static int dateCompare(Date startDate, Date endDate) {
        int result = 0;
        try {
            result = startDate.compareTo(endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public static long subDate(Date startDate, Date endDate) {
        long timeNow = startDate.getTime();
        long timeOld = endDate.getTime();
        long day = (timeNow - timeOld) / (1000 * 60 * 60 * 24);// 化为天
        return day;
    }


    /**
     * Discription : 获取格式化的当前日期（yyyy-MM-dd）
     *
     * @return Date
     * @throws ParseException
     * @throws
     * @author : Wuyk
     */
    public static Date getCurrFormatDate() {
        Calendar calendar = Calendar.getInstance();
        String dateStr = calendar.get(Calendar.YEAR) + "-"
                + (calendar.get(Calendar.MONTH) + 1) + "-"
                + calendar.get(Calendar.DATE);
        Date date = null;
        try {
            date = new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Discription : 获取格式化的昨天日期（yyyy-MM-dd）
     *
     * @return Date
     * @throws ParseException
     * @throws
     * @author : Wuyk
     */
    public static Date getYestFormatDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        String temp = calendar.get(Calendar.YEAR) + "-"
                + (calendar.get(Calendar.MONTH) + 1) + "-"
                + calendar.get(Calendar.DATE);
        return new SimpleDateFormat(DATE_FORMAT).parse(temp);
    }

    /**
     * Discription : 指定日期增加指定天数
     *
     * @param endDate
     * @param i
     * @return Date
     * @throws ParseException
     * @throws
     * @author : Wuyk
     */
    public static Date addDate(Date endDate, int i) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.DATE, i);
        String temp = calendar.get(Calendar.YEAR) + "-"
                + (calendar.get(Calendar.MONTH) + 1) + "-"
                + calendar.get(Calendar.DATE);
        return new SimpleDateFormat(DATE_FORMAT).parse(temp);
    }

    /**
     * Discription :指定日期增加指定小时
     *
     * @param endDate
     * @param i
     * @return
     * @throws ParseException Date
     * @throws
     * @author : shendx
     */
    public static Date addHours(Date endDate, int i) throws ParseException {
        endDate.setHours(endDate.getHours() + i);
        return endDate;
    }

    /**
     * Discription : 获取月份的第一天
     *
     * @param month
     * @return
     * @throws ParseException String
     * @throws
     * @author : Zhough
     */
    public static String getMonStartDay(String month) throws ParseException {
        String startDate = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate(month + "-01"));
        startDate = DateUtils.convertToDate(calendar.getTime()) + " 00:00:00";
        return startDate;
    }

    /**
     * Discription : 获取月份的最后一天
     *
     * @param month
     * @return
     * @throws ParseException String
     * @throws
     * @author : Zhough
     */
    public static String getMonEndDay(String month) throws ParseException {
        String endDate = "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate(month + "-01"));
        calendar.roll(Calendar.DATE, -1);
        endDate = DateUtils.convertToDate(calendar.getTime()) + " 23:59:59";
        return endDate;
    }

    /**
     * Discription : 获取当前的年份，并且获取指定月份的最后一天
     *
     * @param month
     * @return
     * @throws ParseException String
     * @throws
     * @author : shendx
     * @date 2013-12-13 上午11:37:46
     */
    public static String getMonLastDay(String month) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate(calendar.get(Calendar.YEAR) + "-"
                + month + "-01"));
        calendar.roll(Calendar.DATE, -1);
        //TODO
        return "";
    }

    /**
     * Discription : 计算两个日期相差月份
     *
     * @param monthVal1
     * @param monthVal2
     * @return int
     * @throws ParseException
     * @throws
     * @author : Wuyk
     */
    public static int getTimeInervalOfMonth(String monthVal1, String monthVal2)
            throws ParseException {
        int timeInterval = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(monthVal1));
        c2.setTime(sdf.parse(monthVal2));

        timeInterval = (c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH) + 1)
                + (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12;

        return timeInterval;
    }

    public static int getTimeInervalOfMonth(Date firstDate, Date lastDate)
            throws ParseException {
        String monthVal1 = convertToTime(firstDate);
        String monthVal2 = convertToTime(lastDate);
        return getTimeInervalOfMonth(monthVal1, monthVal2);
    }

    /**
     * Discription : 取月份的天数
     *
     * @param flag
     * @param nowMonth
     * @return String
     * @throws
     * @author : Zhough
     */
    public static String countMonthDate(String flag, String nowMonth) {
        String[] times = nowMonth.split("\\-");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.valueOf(times[0]), (Integer.valueOf(times[1]) - 1), 1);
        if ("last".equals(flag)) {
            // 当前月的最后一天
            cal.roll(Calendar.DATE, -1);
        }
        String d = DateUtils.convertToDate(cal.getTime());
        return d;
    }

    /**
     * Discription : 每个季度
     *
     * @return Date
     * @throws
     * @author : Zhough
     */
    public static Date getFirstDayOfQua() {
        Calendar cal = Calendar.getInstance();
        Calendar quaDate = Calendar.getInstance();
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3) { // 一季度
            quaDate.set(Calendar.MONTH, 0);
            quaDate.set(Calendar.DATE, 1);

        } else if (currentMonth >= 4 && currentMonth <= 6) {// 二季度
            quaDate.set(Calendar.MONTH, 3);
            quaDate.set(Calendar.DATE, 1);

        } else if (currentMonth >= 7 && currentMonth <= 9) {// 三季度
            quaDate.set(Calendar.MONTH, 6);
            quaDate.set(Calendar.DATE, 1);

        } else if (currentMonth >= 10 && currentMonth <= 12) {// 四季度
            quaDate.set(Calendar.MONTH, 9);
            quaDate.set(Calendar.DATE, 1);

        }

        Date quaFirstDate = parseTimeToDate(quaDate);

        return quaFirstDate;
    }

    public static Date parseTimeToDate(Calendar dtime) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String temp = dtime.get(Calendar.YEAR) + "-"
                + (dtime.get(Calendar.MONTH) + 1) + "-"
                + dtime.get(Calendar.DATE);
        Date d = null;
        try {
            d = form.parse(temp);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }

    /**
     * Discription : 判断参数时间是否在该月或之后
     *
     * @param monthVal
     * @return boolean
     * @throws
     * @author : Zhough
     */
    public static boolean compareDateIfInThisMonthOrAfter(String monthVal)
            throws ParseException {
        boolean flag = false;
        Calendar calendar = Calendar.getInstance();
        String currMonthString = calendar.get(Calendar.YEAR) + "-"
                + (calendar.get(Calendar.MONTH) + 1) + "-01";
        Date currMonth = DateUtils.parseDate(currMonthString);
        Date searchMonth = DateUtils.parseDate(monthVal);
        if (searchMonth.compareTo(currMonth) >= 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * Discription : 将月份减去 subMonNum
     *
     * @param subNum
     * @return Date
     * @throws
     * @author : shendx
     * @date 2014-4-8 上午10:30:42
     */
    public static Date subMoth(int subMonNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.MONTH, -subMonNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription : 将月份加 subMonNum
     *
     * @param subNum
     * @return Date
     * @throws
     * @author : shendx
     * @date 2014-4-8 上午10:30:42
     */
    public static Date addMoth(int addMonNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.MONTH, addMonNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription :给指定的日期添加年份
     *
     * @param addYearNum
     * @return
     * @throws Exception Date
     * @throws
     * @author : dison
     */
    public static Date addYear(Date date, int addYearNum) throws Exception {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, addYearNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription :
     *
     * @param date
     * @param addMonthNum
     * @return Date
     * @throws
     * @author : dison
     * @see #addMoth(int)
     */
    public static Date addMonth(Date date, int addMonthNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, addMonthNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription :周加减
     *
     * @param date
     * @param addMonthNum
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addWeek(Date date, int addWeekNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.WEEK_OF_YEAR, addWeekNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription :周加减
     *
     * @param date
     * @param addMonthNum
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addDay(Date date, int addDayNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, addDayNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription :秒加减
     *
     * @param date
     * @param addMonthNum
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date addSecond(Date date, int addSecNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.SECOND, addSecNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription :小时加减
     *
     * @param date
     * @param addHourNum
     * @return Date
     * @throws
     * @author : by
     */
    public static Date addHour(Date date, int addHourNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.HOUR_OF_DAY, addHourNum);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription : 获取与当前相差天数的时间
     *
     * @param betVal
     * @return Date
     * @author : han
     */
    public static Date getDayByBetVal(int betVal) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(new Date());
        rightNow.add(Calendar.DAY_OF_YEAR, betVal);
        return new Date(rightNow.getTimeInMillis());
    }

    /**
     * Discription : 获取当前的季度
     *
     * @param cal
     * @return int
     * @throws
     * @author : Zhough
     */
    public static int getQuaNumByCal(int currentMonth) {
        int quaNum = 0;
        if (currentMonth >= 1 && currentMonth <= 3) { // 一季度
            quaNum = 1;
        } else if (currentMonth >= 4 && currentMonth <= 6) {// 二季度
            quaNum = 2;
        } else if (currentMonth >= 7 && currentMonth <= 9) {// 三季度
            quaNum = 3;
        } else if (currentMonth >= 10 && currentMonth <= 12) {// 四季度
            quaNum = 4;
        }
        return quaNum;
    }


    public static long getDaysBetweenTwoDate(String fromDate, String toDate)
            throws Exception {
        long from = parseDate(fromDate).getTime();
        long to = parseDate(toDate).getTime();
        long days = (to - from) / (1000 * 60 * 60 * 24); // 1-31相差30天
        days += 1; // 1-31 实为31天
        return days;
    }

    /**
     * Discription :判断日期字符串类型是否合法
     *
     * @param dateString
     * @return
     * @throws Exception boolean
     * @throws
     * @author : shendx
     */
    public static boolean isValidDate(String dateString) throws Exception {

        return isValidDates(dateString);
    }

    /**
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     *
     * @param startDate
     * @param endDate
     * @param map       map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : fh
     */
    public static String finishStartAndEndDateCQR(String startDate,
                                                  String endDate, Map map) throws ParseException {
        startDate = startDate == null || startDate.equals("null") ? ""
                : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0) {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.parseDate(DateUtils.convertToDate(date)));
            map.put("startDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        } else if (startDate.length() > 0) {
            map.put("startDate", startDate);
        }
        if (map.get("default") == null && endDate.length() == 0) {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.parseDate(DateUtils.convertToDate(date
                    .getTime())));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", date.getTime());
        } else if (endDate.length() > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.parseDate(endDate));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", endDate);
        }
        return startDate + ":" + endDate;
    }

    public static boolean isValidDates(String dateString) throws Exception {

        boolean isValidDate = true;
        try {
            convertToTimes(dateString);
        } catch (Exception e) {
            try {
                parseDate(dateString);
            } catch (Exception e1) {
                isValidDate = false;
            }
        }
        return isValidDate;
    }

    /**
     * Discription :校验字符串时间（年月日格式）是否合法
     *
     * @param dateString
     * @return
     * @throws Exception boolean
     * @throws
     * @author : dison
     */
    public static boolean isValidDateYMD(String dateString) throws Exception {
        boolean isValidDate = true;
        try {
            parseDate(dateString);
        } catch (Exception e) {
            isValidDate = false;
        }
        return isValidDate;
    }

    /**
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     *
     * @param startDate
     * @param endDate
     * @param map       map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : fh
     */
    public static String finishStartAndEndDate(String startDate,
                                               String endDate, Map map) throws ParseException {
        startDate = startDate == null || startDate.equals("null") ? ""
                : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0) {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.parseDate(DateUtils.convertToDate(date)));
            map.put("startDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        } else if (startDate.length() > 0) {
            map.put("startDate", DateUtils.parseDate(startDate));
        }
        if (map.get("default") == null && endDate.length() == 0) {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.parseDate(DateUtils.convertToDate(date
                    .getTime())));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", date.getTime());
        } else if (endDate.length() > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.parseDate(endDate));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", cal.getTime());
        }
        return startDate + ":" + endDate;
    }

    /**
     * @param flag
     * @return date
     * @Description 计算当前月的第一天或者最后一天
     */
    public static Date countMonthDate(String flag) {
        Calendar cal = Calendar.getInstance();
        // 当前月的第一天
        cal.set(Calendar.DATE, 1);
        if ("last".equals(flag)) {
            // 当前月的最后一天
            cal.roll(Calendar.DATE, -1);
        }
        Date d = cal.getTime();
        return d;
    }

    /**
     * Discription : 获取月份的最后一天
     *
     * @param betVal
     * @return Date
     * @author : han
     */
    public static Date getMonthLastDay(int betVal) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, betVal);
        cal.roll(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static Date getMonthFirstDay(int betVal) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, betVal);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * Discription : 根据标识获取时间
     *
     * @param duration (day:当天，week:当周，month:当月)
     * @param flag     (start:初，end:末)
     * @return Date (格式：yyyy-MM-dd)
     * @author : han
     */
    public static Date getDateByCurrDuration(String duration, String flag) {
        Calendar cal = Calendar.getInstance();
        if (DateUtils.DAY.equals(duration)) {

        } else if (DateUtils.WEEK.equals(duration)) {
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            if (DateUtils.END.equals(flag)) {
                cal.add(Calendar.DATE, 6);
            }
        } else if (DateUtils.MONTH.equals(duration)) {
            cal.set(Calendar.DATE, 1);
            if (DateUtils.END.equals(flag)) {
                cal.roll(Calendar.DATE, -1);
            }
        }

        return cal.getTime();
    }

    /**
     * Discription : 获取时间区间的时间字符串（yyyy-MM-dd）
     *
     * @param duration
     * @param flag
     * @return String
     * @author : han
     */
    public static String getDateStringByCurrDuration(String duration,
                                                     String flag) {
        return DateUtils.convertToDate(DateUtils.getDateByCurrDuration(
                duration, flag));
    }

    /**
     * Discription : 是否为一个星期的某天
     *
     * @param day
     * @return boolean
     * @author : han
     */
    public static boolean ifWhichDayOfWeek(int day) {
        boolean flag = false;
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == day) {
            flag = true;
        }
        return flag;
    }

    /**
     * Discription : 判断当前时间是否在条件时间区间内
     *
     * @param begin （类型：字符串，格式：HH:mm）
     * @param end   （类型：字符串，格式：HH:mm）
     * @return boolean
     * @author : han
     */
    public static boolean ifBetweenTimeRegion(String begin, String end) {
        boolean flag = false;
        try {
            if (StringUtils.isNotBlank(begin)
                    || StringUtils.isNotBlank(end)) {
                return false;
            }

            int begin_hour = Integer.valueOf(begin.split(":")[0]);
            int begin_minute = Integer.valueOf(begin.split(":")[1]);
            int end_hour = Integer.valueOf(end.split(":")[0]);
            int end_minute = Integer.valueOf(end.split(":")[1]);
            int begin_all_minute = begin_hour * 60 + begin_minute;
            int end_all_minute = end_hour * 60 + end_minute;

            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int curr_all_minute = hour * 60 + minute;
            // 1:结束时间比开始时间大（都在当天） 2:结束时间比开始时间小(结束时间在第二天)
            if (end_all_minute > begin_all_minute) {
                if (curr_all_minute >= begin_all_minute
                        && curr_all_minute <= end_all_minute) {
                    flag = true;
                }
            } else {
                if (curr_all_minute >= begin_all_minute
                        || curr_all_minute <= end_all_minute) {
                    flag = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * Discription :获取当前时间周的最后一天（星期日）时间
     *
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getWeekLastDay(Date currDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        // 1周的第一天
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        // 1周的最后一天
        cal.add(Calendar.DATE, 6);

        return parseDate(convertToDate(cal.getTime()));
    }

    /**
     * Discription : 获取当前时间周的第一天（星期一）时间
     *
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getWeekFristDay(Date currDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.DATE, 0);

        return parseDate(convertToDate(cal.getTime()));
    }

    /**
     * Discription :获取指定时间的一个月的最后一天
     *
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getMonthLastDay(Date currDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.DATE, 1);
        cal.roll(Calendar.DATE, -1);

        return parseDate(convertToDate(cal.getTime()));
    }

    /**
     * Discription :获取指定时间的一个月的第一天
     *
     * @param currDate
     * @return
     * @throws Exception Date
     * @throws
     * @author : shendx
     */
    public static Date getMonthFristDay(Date currDate) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DATE, 1);

        return parseDate(convertToDate(cal.getTime()));
    }

    /**
     * 获取前一年的同一天
     * @return
     */
    public static Date getPreYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.YEAR,cal.get(Calendar.YEAR) - 1 );
        return cal.getTime() ;
    }

    public static void main(String[] args) throws Exception {
        Date monthFristDay = getPreYear(new Date());
        System.out.println(convertToTime(monthFristDay));

    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return int
     * @throws Exception
     * @author : Wei,Sun
     */
    public static int daysBetween(Date smdate, Date bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days)) + 1;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return int
     * @throws Exception
     * @author : Wei,Sun
     */
    public static int apartDaysNumber(Date smdate, Date bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days)) ;
    }


    /**
     * Discription :获取指定时间的月总天数
     *
     * @param currDate
     * @return int
     * @throws Exception
     * @author : Wei,Sun
     */
    public static int getDaysForMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return days;
    }

    /**
     * Discription : 得到当前日期所在季度最后一天
     *
     * @param date
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentQuarterEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * Discription : 得到当前日期所在季度的第一天
     *
     * @param date
     * @param isContainDay 是否需要把天设为1
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentQuarterStartTime(Date date,
                                                  Boolean isContainDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            if (isContainDay) {
                c.set(Calendar.DATE, 1);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * Discription : 获取当前时间所在半年的第一天
     *
     * @param date
     * @param isContainDay 是否需要把天设为1
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getHalfYearStartTime(Date date, Boolean isContainDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 6);
            }
            if (isContainDay) {
                c.set(Calendar.DATE, 1);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    }

    /**
     * Discription : 获取当前时间所在半年的最后一天
     *
     * @param date
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getHalfYearEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * Discription : 当前日期所在年的第一天
     *
     * @param date
     * @param isContainDay 是否需要把天设为1
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentYearStartTime(Date date, Boolean isContainDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            if (isContainDay) {
                c.set(Calendar.DATE, 1);
            }
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }


    /**
     * Discription : 当前日期所在年的最后一天
     *
     * @param date
     * @return Date
     * @throws
     * @author : Wei,Sun
     */
    public static Date getCurrentYearEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Date now = null;
        try {
            c.set(Calendar.MONTH, 11);
            c.set(Calendar.DATE, 31);
            String dateValue = convertToDate(c.getTime());
            now = parseDate(dateValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * Discription : 得到几天前的时间
     *
     * @param date
     * @return Date
     * @throws
     * @author : Wangxy
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * Discription : 得到几天后的时间
     *
     * @param date
     * @return Date
     * @throws
     * @author : Wangxy
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     *
     * @param startDate 精确到小时，分，秒
     * @param endDate
     * @param map       map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : chenrh
     */
    public static String finishStartAndEndTime(String startDate,
                                               String endDate, Map map) throws ParseException {
        startDate = startDate == null || startDate.equals("null") ? ""
                : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0) {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date) + " 00:00:00"));
            map.put("startDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        } else if (startDate.length() > 0) {
            map.put("startDate", DateUtils.convertToTime(startDate + " 00:00:00"));
        }
        if (map.get("default") == null && endDate.length() == 0) {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date
                    .getTime()) + " 00:00:00"));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", date.getTime());
        } else if (endDate.length() > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.convertToTime(endDate + " 00:00:00"));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endDate", cal.getTime());
        }
        return startDate + ":" + endDate;
    }

    /**
     * Discription : hql查询时间区间模板 hql查询为大于或等于startdate,小于enddate(enddate会加一天)
     *
     * @param startDate 精确到小时，分，秒
     * @param endDate
     * @param map       map有default属性,就不设置默认值
     * @throws ParseException String 返回值为startDate+":"+endDate
     * @throws
     * @author : chenrh
     */
    public static String finishStartAndEndCloseTime(String startDate,
                                                    String endDate, Map map) throws ParseException {
        startDate = startDate == null || startDate.equals("null") ? ""
                : startDate;
        endDate = endDate == null || endDate.equals("null") ? "" : endDate;
        if (map.get("default") == null && startDate.length() == 0) {
            Calendar cal = Calendar.getInstance();
            Date date = countMonthDate("firstday");
            cal.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date) + " 00:00:00"));
            map.put("startCloseDate", cal.getTime());
            startDate = DateUtils.convertToDate(cal.getTime());
        } else if (startDate.length() > 0) {
            map.put("startCloseDate", DateUtils.convertToTime(startDate));
        }
        if (map.get("default") == null && endDate.length() == 0) {
            Calendar date = Calendar.getInstance();
            date.setTime(DateUtils.convertToTime(DateUtils.convertToDate(date
                    .getTime()) + " 00:00:00"));
            endDate = DateUtils.convertToDate(date.getTime());
            date.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endCloseDate", date.getTime());
        } else if (endDate.length() > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(DateUtils.convertToTime(endDate));
            cal.add(Calendar.DAY_OF_YEAR, 1);
            map.put("endCloseDate", cal.getTime());
        }
        return startDate + ":" + endDate;
    }

    /**
     * Discription : 两个日期相差的天数
     *
     * @param date1
     * @param date2
     * @return
     * @throws ParseException int
     * @throws
     * @author : Wei,Sun
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;

        return Math.abs(result);

    }

    public static int getDaySpace(String date1, String date2) throws ParseException {

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(parseDate(date1));

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(parseDate(date2));
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) //闰年
                {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else {
            return day2 - day1;
        }
    }

    /**
     * Discription : 获取两个时间之间的时间差，返回天，时，分，秒
     *
     * @param startDate
     * @param endDate
     * @return String
     * @throws
     * @author : Wangxy
     */
    public static String printDifference(Date startDate, Date endDate) {

        long different = endDate.getTime() - startDate.getTime();

        //System.out.println("startDate : " + startDate);
        //System.out.println("endDate : "+ endDate);
        //System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);
        return elapsedDays + "," + elapsedHours + "," + elapsedMinutes + "," + elapsedSeconds;
    }

    /**
     * Discription : 判断当前日期是否是月初
     *
     * @return boolean
     * @throws
     * @author : han
     */
    public static boolean ifFirstDayOfMonth() {
        boolean flag = false;
        Calendar cal = Calendar.getInstance();
        //判断是否为月份的1号
        if (cal.get(Calendar.DAY_OF_MONTH) == 1) {
            flag = true;
        }
        return flag;
    }

    /**
     * Discription : 获取指定日期的最后一天
     *
     * @param currDate
     * @return
     * @throws Exception String
     * @throws
     * @author : hongxing
     */
    public static String getLastDay(String currDate) throws Exception {
        Date date = parseDate(currDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);

        return convertToDate(cal.getTime());
    }

    /**
     * 获取本周的开始时间
     */
    public static Date getStartTimeThisWeek(Calendar calendar) {
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        calendar.add(Calendar.DATE, -day_of_week);
        return getNowStartTime(calendar);
    }

    /**
     * 获取本周的结束时间
     */
    public static Date getEndTimeThisWeek(Calendar calendar) {
        calendar.add(Calendar.DATE, 6);
        return getNowEndTime(calendar);
    }


    /**
     * 获取当前月的最后一天的日期
     *
     * @param monthDay
     * @return
     * @author qsr
     */
    public static Date getThisMonthLastDay(Date monthDay) {
        //复制当前月
        Date tempDate = new Date();
        tempDate.setTime(monthDay.getTime());
        tempDate.setDate(1);

        //当前月份增加一个月
        int month = tempDate.getMonth();
        if (month == 11)//当前月是最后一个月，则是下一年1月份
        {
            tempDate.setMonth(0);
            tempDate.setYear(tempDate.getYear() + 1);
        } else {
            tempDate.setMonth(month + 1);
        }

        //减去一天
        long endDateTimeTemp = tempDate.getTime();
        long oneDayTime = 24 * 60 * 60 * 1000;//一天的毫秒数
        long endDateTime = endDateTimeTemp - oneDayTime;//月份加1后减去一天

        tempDate.setTime(endDateTime);

        return tempDate;
    }

    /**
     * 获取当前月的下一个月
     *
     * @param date
     * @return
     * @author qsr
     */
    public static Date getNextMonth(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.MONTH, 1);
        return cd.getTime();
    }


    /**
     * 获取指定月份的天数目
     *
     * @param date
     * @return
     * @author qsr
     */
    public static int getMonthDayCount(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        return cd.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * Discription :是否在时间区间内容(包含)
     *
     * @param startDate
     * @param date
     * @param endDate
     * @return
     * @throws Exception int
     * @throws
     * @date 2015-11-23 上午10:43:02
     * @author :  dison
     */
    public static boolean isWithin(Date startDate, Date date, Date endDate) throws Exception {
        boolean isWithin = false;
        if (dateCompare(startDate, date) <= 0 && dateCompare(endDate, date) >= 0) {
            isWithin = true;
        }

        return isWithin;
    }

    /**
     * 获取当天的开始时间
     *
     * @return
     */
    public static Date getNowStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getNowStartTime(Calendar todayStart) {
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取当天的最后时间
     *
     * @return
     */
    public static Date getNowEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getNowEndTime(Calendar todayEnd) {
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * Discription :获取当年的第一天
     *
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getCurrYearFirst() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * Discription :获取当年的最后一天
     *
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getCurrYearLast() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * Discription :获取某年第一天日期
     *
     * @param year
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * Discription :获取某年最后一天日期
     *
     * @param year
     * @return Date
     * @throws
     * @author : dison
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }

    /**
     * @param date
     * @param pattern
     * @return
     * @description 把时间转化为字符串
     * @author qsr
     * @time 2016年3月25日
     */
    public static String convertDateToString(Date date, String pattern) {
        if (date == null) return null;

        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static String convertHourToString(Long hours) {
        return String.valueOf(hours);
    }

    public static String convertUTCString(String utcTime) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
//		df.setTimeZone(TimeZone.getTimeZone("UTC"));
//		try {
//			return df.parse(utcTime).toString();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return "";


        try {
            utcTime = utcTime.replace("Z", " UTC"); //注意是空格+UTC
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
            Date d = format.parse(utcTime);
            return DateUtils.convertDateToString(d, DATE_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Date convertUTCtoDate(String utcTime) {
        try {
            utcTime = utcTime.replace("Z", " UTC"); //注意是空格+UTC
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
            Date d = format.parse(utcTime);
            return d;
        } catch (ParseException e) {
//			e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间所在月份的第一天时间
     *
     * @param date
     * @return
     * @author qsr
     */
    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.DATE, 1);

        return calendar.getTime();
    }

    public static String convertUTCToCST(Date operateDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(operateDate);
        calendar.toString();
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
        Date time = calendar.getTime();
        sdf.format(time);
        return sdf.format(time);
    }

    /**
     * 功能：获取本年的开始时间
     */
    public static Date startOfTheYear(int year) {// 当周开始时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.YEAR, year);
        currentDate.set(Calendar.MONTH, 0);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        Date date = currentDate.getTime();
        return date;
    }

    /**
     * 功能：获取本年的结束时间
     */
    public static Date endOfTheYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        Date date = cal.getTime();
        return date;
    }

    public static int calculateMonth(Date fromDate, Date toDate) {
        Calendar from = Calendar.getInstance();
        from.setTime(fromDate);
        Calendar to = Calendar.getInstance();
        to.setTime(toDate);
        //只要年月
        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int month = toYear * 12 + toMonth - (fromYear * 12 + fromMonth);
        return month;
    }


    //日期去除 00：00：00 0 或者 0
    public static String getDateDayString(Date date) {
        if (date == null) {
            return "";
        }
        String dateString = String.valueOf(date);
        if (dateString.endsWith("00:00:00.0")) {
            return dateString.replace("00:00:00.0", "");
        } else {
            return dateString.substring(0, dateString.length() - 2);
        }
    }

    /**
     * 根据年月日创建时间
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDateByYearMonthDay(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        return cal.getTime() ;
    }

    /**
     * 获取时间月份 1 -12
     * @param date
     * @return
     */
    public static String getMonthNew(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(Calendar.MONTH)+1);
    }

    /**
     * 判断2个时间是否在同一个月份
     * @param endDate
     * @param planOpeningTime
     */
    public static Boolean isSameMonth(Date endDate, Date planOpeningTime) {
        String date1 = convertToMonth(endDate);
        String date2 = convertToMonth(planOpeningTime);
        return StringUtils.equals(date1,date2);
    }

    /**
     * 后期指定日期上一年的第一天
     * @param endDate
     * @return
     */
    public static Date getLastYearFistDay(Date endDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        int year = cal.get(Calendar.YEAR);
        Calendar returnCal = Calendar.getInstance();
        returnCal.set(Calendar.YEAR,year-1);
        returnCal.set(Calendar.MONTH,0);
        returnCal.set(Calendar.DAY_OF_MONTH,1);
        returnCal.set(Calendar.HOUR_OF_DAY,0);
        returnCal.set(Calendar.MINUTE,0);
        returnCal.set(Calendar.SECOND,0);
        returnCal.set(Calendar.MILLISECOND,0);
        return returnCal.getTime() ;
    }

    /**
     * 后期指定日期上一年的第最后一天 最后一刻
     * @param endDate
     * @return
     */
    public static Date getLastYearLastDay(Date endDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        int year = cal.get(Calendar.YEAR);
        Calendar returnCal = Calendar.getInstance();
        returnCal.set(Calendar.YEAR,year-1);
        returnCal.set(Calendar.MONTH,11);
        returnCal.set(Calendar.DAY_OF_MONTH,31);
        returnCal.set(Calendar.HOUR_OF_DAY,23);
        returnCal.set(Calendar.MINUTE,59);
        returnCal.set(Calendar.SECOND,59);
        returnCal.set(Calendar.MILLISECOND,59);
        return returnCal.getTime() ;
    }

    /**
     * 前一个月的最后一天
     * @param nowDate
     * @return
     */
    public static Date prevMonthDate(Date nowDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        Calendar returnCal = Calendar.getInstance();
        returnCal.set(Calendar.YEAR,year);
        returnCal.set(Calendar.MONTH,month - 1);
        int MaxDay=returnCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        returnCal.set(Calendar.DAY_OF_MONTH,MaxDay);
        returnCal.set(Calendar.HOUR_OF_DAY,23);
        returnCal.set(Calendar.MINUTE,59);
        returnCal.set(Calendar.SECOND,59);
        returnCal.set(Calendar.MILLISECOND,59);
        return returnCal.getTime() ;
    }
}


