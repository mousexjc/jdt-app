package cn.chinajdt.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class DateUtil {

    // 日期格式:yyyy-MM-dd
    public static final String PATTERN_YMD = "yyyy-MM-dd" ;

    // 日期格式:yyyy-MM-dd HH:mm
    public static final String PATTERN_YMDHM = "yyyy-MM-dd HH:mm" ;

    // 日期格式:yyyy-MM-dd HH:mm:ss
    public static final String PATTERN_YMDHMS = "yyyy-MM-dd HH:mm:ss" ;

    /**
     * 获取两个日期中间的工作日
     * @param starttime
     * @param endtime
     * @return
     */
    public static int getworktime(String starttime, String endtime){
        //设置时间格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //开始日期
        Date dateFrom=null;
        Date dateTo=null;
        try {
            dateFrom = dateFormat.parse(starttime);
            dateTo = dateFormat.parse(endtime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int workdays = 0;
        Calendar cal = null;
        while(dateFrom.before(dateTo)|| dateFrom.equals(dateTo)){
            cal = Calendar.getInstance();
            //设置日期
            cal.setTime(dateFrom);
            if((cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
                    &&(cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY)){
                //进行比较，如果日期不等于周六也不等于周日，工作日+1
                workdays++;
            }
            //日期加1
            cal.add(Calendar.DAY_OF_MONTH,1);
            dateFrom = cal.getTime();
        }
        return workdays;
    }

    /**
     * 获取两个日期之间的间隔天数
     * @param startTime
     * @param endTime
     * @return ：出现异常返回-1
     */
    public static int getDays( Date startTime ,Date endTime )
    {
        SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        try {
            Date _currDate = _sdf.parse(_sdf.format(startTime)) ;
            Date _deadLine = _sdf.parse(_sdf.format(endTime)) ;
            Calendar cal = Calendar.getInstance();
            cal.setTime(_currDate);
            long _sTime = cal.getTimeInMillis();
            cal.setTime(_deadLine);
            long _eTime = cal.getTimeInMillis();
            long _between_days=(_eTime-_sTime)/(1000*3600*24);
            return Integer.parseInt(_between_days + "");
        } catch (Exception e) {
            return -1 ;
        }
    }

    /**
     * 计算date + num 天
     * @param date
     * @param num
     * @return
     */
    public static Date addDays( Date date , int num )
    {
        if(date == null)
            return null;
        Calendar _cal = Calendar.getInstance() ;
        _cal.setTime( date );
        _cal.add(Calendar.DATE , num ) ;
        return _cal.getTime();
    }

    /**
     *  将时间间隔算出天数/小时数/分钟数
     * @param millionSeconds
     * @return:Key:DAY(天数),HOUR(小时数),MIN(分钟数),SEC(秒数)
     */
    public static Map<String,Long> computeMillionSeconds( Long millionSeconds )
    {
        Map<String,Long> _map = new HashMap<String,Long>() ;
        Long _days = millionSeconds /(24 * 3600 * 1000 ) ;
        Long _hours = (millionSeconds % ( 24 * 3600 * 1000 ))/( 3600 *1000 ) ;
        Long _min = (millionSeconds % ( 3600 * 1000 ))/( 60 *1000 ) ;
        Long _sec = (millionSeconds % ( 60 *1000) )/1000 ;
        _map.put("DAY", _days ) ;
        _map.put("HOUR", _hours ) ;
        _map.put("MIN", _min ) ;
        _map.put("SEC", _sec ) ;
        return _map ;
    }

    /**
     * 将起始时间间隔算出天数/小时数/分钟数
     * @param startDate
     * @param endDate
     * @return ：Key:DAY(天数),HOUR(小时数),MIN(分钟数),SEC(秒数)
     */
    public static Map<String,Long> computeMillionSeconds( Date startDate ,Date endDate )
    {
        return computeMillionSeconds( endDate.getTime() - startDate.getTime() ) ;
    }

    /**
     *  格式化毫秒数为："XX天XX小时XX分XX秒"
     * @param millionSeconds
     * @return
     */
    public static String getFormatStr( Long millionSeconds ){
        Map<String,Long> _map = DateUtil.computeMillionSeconds(millionSeconds) ;
        String _totalTime = _map.get("HOUR") + "小时" + _map.get("MIN") + "分" + _map.get("SEC") + "秒" ;
        if(_map.get("DAY")>0) _totalTime = _map.get("DAY") + "天" + _totalTime  ;
        return _totalTime ;
    }

    /**
     * 格式化间隔时间 为："XX天XX小时XX分XX秒"
     * @param startDate
     * @param endDate
     * @return
     */
    public static String getFormatStr( Date startDate ,Date endDate )
    {
        return getFormatStr(endDate.getTime() -startDate.getTime()) ;
    }

    /**
     * 计算date + hours 小时
     * @param date
     * @param hours
     * @return
     */
    public static Date addHours( Date date , int hours )
    {
        Calendar _cal = Calendar.getInstance() ;
        _cal.setTime( date );
        _cal.add(Calendar.HOUR , hours ) ;
        return _cal.getTime();
    }

    /**
     * 字符串转化为时间
     * @param str
     * @param pattern
     * @return
     */
    public static Date parse( String str , String pattern ){
        Date _date = null ;
        try {
            _date = new SimpleDateFormat(pattern).parse(str) ;
        } catch (ParseException e) {
            return null ;
        }
        return _date ;
    }

    /**
     * 将格式为yyyy-MM-dd字符串转化为日期
     * @param str
     * @return
     */
    public static Date parse2YMD(String str){
        if( str == null ) return null ;
        if( str.length()>=4 &&str.length()<7){
            str = str.substring(0,4) + "-01-01" ;
        }else if( str.length()>=7 &&str.length()<10){
            str = str.substring(0,7) + "-01" ;
        }
        return parse( str ,DateUtil.PATTERN_YMD) ;
    }

    /**
     * 将格式为yyyy-MM-dd HH:mm的字符串转化为日期
     * @param str
     * @return
     */
    public static Date parse2YMDHM(String str){
        if( str == null ) return null ;
        if( str.length()>=4 &&str.length()<7){
            str = str.substring(0,4) + "-01-01 00:00" ;
        }else if( str.length()>=7 &&str.length()<10){
            str = str.substring(0,7) + "-01 00:00" ;
        }else if( str.length()>=10 &&str.length()<13){
            str = str.substring(0,10) + " 00:00" ;
        }else if( str.length()>=13 &&str.length()<16){
            str = str.substring(0,13) + ":00" ;
        }
        return parse( str ,DateUtil.PATTERN_YMDHM) ;
    }

    /**
     * 将格式为yyyy-MM-dd HH:mm:ss的字符串转化为日期
     * @param str
     * @return
     */
    public static Date parse2YMDHMS(String str){
        if( str == null ) return null ;
        if( str.length()>=4 &&str.length()<7){
            str = str.substring(0,4) + "-01-01 00:00:00" ;
        }else if( str.length()>=7 &&str.length()<10){
            str = str.substring(0,7) + "-01 00:00:00" ;
        }else if( str.length()>=10 &&str.length()<13){
            str = str.substring(0,10) + " 00:00:00" ;
        }else if( str.length()>=13 &&str.length()<16){
            str = str.substring(0,13) + ":00:00" ;
        }else if( str.length()>=16 &&str.length()<19){
            str = str.substring(0,16) + ":00" ;
        }
        return parse( str ,DateUtil.PATTERN_YMDHMS) ;
    }

    /**
     * date 转化为字符串，出错返回 “” 空字符串
     * @param d
     * @param pattern
     * @return
     */
    public static String toString( Date d ,String pattern ){
        try {
            return new SimpleDateFormat(pattern).format(d) ;
        } catch (Exception e) {
            return "" ;
        }
    }

    /**
     * date 转化为字符串，出错返回 “” 空字符串
     * @param d
     * @param pattern
     * @return
     */
    public static String toYMD( Date d ){
        return toString(d, PATTERN_YMD) ;
    }

    /**
     * date 转化为字符串，出错返回 “” 空字符串
     * @param d
     * @param pattern
     * @return
     */
    public static String toYMDHM( Date d ){
        return toString(d, PATTERN_YMDHM) ;
    }

    /**
     * date 转化为字符串，出错返回 “” 空字符串
     * @param d
     * @param pattern
     * @return
     */
    public static String toYMDHMS( Date d ){
        return toString(d, PATTERN_YMDHMS) ;
    }

}
