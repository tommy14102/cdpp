package com.travelsky.b2g.b2gcommon.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @Description: 
 * @author:  wjj 
 * @date 2016-4-14 上午10:22:22 
 * @version
 */
public class DateUtils {

	public static String getDateTimeStr(String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();//获取当前日期
        String day = df.format(calendar.getTime());
		return day;
	}
	
	/**
	 * 获取UTC时间
	 * 
	 * @return
	 */
	public static int getNowUTC() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTimeZone(new SimpleTimeZone(8 * 60 * 60 * 1000, "BEIJING"));
		c.setTime(d);
		int utc = (int) (c.getTimeInMillis() / 1000);
		return utc;
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
