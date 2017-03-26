package com.travelsky.b2g.b2gcommon.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * Created by zhuxiaoyu on 16/4/1.
 */
public class StringManage {
    private static final Pattern LETTER_NUM_LINE_PATTERN = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$");

    private static final Pattern UNICOM_PHONE_PATTERN = Pattern.compile("^((13[0-2])|(145)|(15[5-6])|(186)|(175))\\d{8}$");


    /**
     * 验证字符串格式 字母下划线下划线不能开头与结尾
     */
    public static boolean validateLetterNumnderline(String str){
        if (str != null && str.length() > 0) {
            return LETTER_NUM_LINE_PATTERN.matcher(str).find();
        } else {
            return false;
        }
    }

    /**
     * 随机数
     * @param length
     * @return
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
             random = random + 0.1;
        } for (int i = 0; i < length; i++) {
             num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 订购流水号：日期+流水号
     * @return
     */
    public static String seq(){
    	String now = DateUtils.getDateTimeStr("yyyyMMddhhmmssSSS");
    	String seq = now+""+buildRandom(6);
    	return seq;
    }
    /**
     * 验证联通手机
     */
    public  static boolean validateUnicom(String phone){
        if (phone != null && phone.length() > 0) {
            return UNICOM_PHONE_PATTERN.matcher(phone).find();
        } else {
            return false;
        }
    }

    // 手机号正则表达式
    private static final Pattern MOBILE_PATTERN = Pattern
            .compile("^(13[0-9]|14[5|7]|15[0-3|5-9]|17[6|7|8]|18[0|2|3|5-9])\\d{8}$");

    private static final Pattern ORDER_PATTERN = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$");

    /**
     * 手机号验证
     *
     * @param mobile
     * @return
     */
    public static boolean isLegalMobile(String mobile) {
        if (mobile != null && mobile.length() > 0) {
            return MOBILE_PATTERN.matcher(mobile).find();
        } else {
            return false;
        }
    }

    /**
     * orderId验证 数字字母下划线 下划线不能开头与结尾
     *
     * @param orderId
     * @return
     */
    public static boolean isLegalOrder(String orderId) {
        if (orderId != null && orderId.length() > 0) {
            return ORDER_PATTERN.matcher(orderId).find();
        } else {
            return false;
        }
    }

    /**
     * 时间戳验证
     *
     * @param timestamp
     * @return
     */
    public static boolean isLegalTime(String timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            Date d = sdf.parse(timestamp);
            if (System.currentTimeMillis() > d.getTime() + (60 * 1000 * 10)
                    || System.currentTimeMillis() <= d.getTime() - (60 * 1000 * 10)) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 判空验证
     *李智慧 10.25
     * @param object
     * @return boolean
     */
    public static boolean isEmpty(Object object) {
    	if (object == null|| "".equals(object)) {
			return true;
		}
        return false;
    }
    
    /**
	 * 校验字符长度 是否在数据库长度限制范围内
	 * @param str 字符串
	 * @param length 数据库长度
	 * @return 不符合范围 true
	 * @throws UnsupportedEncodingException
	 */
	public static boolean checkLengthError(Object str, int length){
		if(str == null){
			return false;
		}
		if(str.toString().length() <= length){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 返回查询结果字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String getStringValue(Object object) {
		String value = null;
		if (object == null) {
			return "";
		}
		if (object instanceof Integer) {
			value = String.valueOf(((Integer) object).intValue());
		} else if (object instanceof String) {
			value = (String) object;
		} else if (object instanceof Double) {
			value = String.valueOf(((Double) object).doubleValue());
		} else if (object instanceof Float) {
			value = String.valueOf(((Float) object).floatValue());
		} else if (object instanceof Long) {
			value = String.valueOf(((Long) object).longValue());
		} else if (object instanceof Boolean) {
			value = String.valueOf(((Boolean) object).booleanValue());
		} else if (object instanceof String) {
			value = (String) object;
		} else {
			value = object.toString();
		}
		return value.trim();
	}
	
	/**
	 * 验证double
	 * @param object
	 * @return  true:非double类型；  false:double类型
	 */
//	public static boolean checkNoDouble(Object object){
//		boolean bCheckResult = false;
//		if (object == null) {
//			return true;
//		}
//		try {
//			Double dCheckValue = Double.parseDouble(object.toString());
//			if (dCheckValue instanceof Double == false) {
//				bCheckResult = true;
//			}
//		} catch (NumberFormatException e) {
//			bCheckResult = true;
//		}
//		return bCheckResult;
//	}
	public  static  boolean  isNumber(String  str)  {    
        Pattern  pattern  =  Pattern.compile("[0-9]*");
        java.util.regex.Matcher  match  =  pattern.matcher(str.trim());    
        return  match.matches();    
	}    
	/**
	 * 验证double
	 * @param object
	 * @return  true:非double类型；  false:double类型
	 */
	public  static  boolean  checkNoDouble(Object  obj)  {
		if(obj==null || "".equals(obj.toString())){
			return false;
		}
		String str = obj.toString();
		String reg =  "^([1-9]\\d*(\\.\\d{1,2})?|0(\\.\\d{1,2})?)$";
        return  !Pattern.compile(reg).matcher(str).matches();    
		}
    /**
     * 验证金钱格式
     * @param in
     * @return  true:  false
     */
    public static boolean checkPrice(String in){
        String reg =  "^([1-9]\\d*(\\.\\d{1,2})?|0(\\.\\d{1,2})?)$";
        return Pattern.compile(reg).matcher(in).find() ;
    }

}
