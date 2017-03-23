package com.travelsky.b2g.interfaces.tag;

import java.util.List;
import java.util.Map;


public interface AesTagManager {


	/**
	 * 获取国际化消息，无参数
	 * @param lan
	 * @param airline
	 * @param bundle
	 * @param key
	 * @param defalut
	 * @return
	 * @throws Exception
	 */
	public String getMessage(String bundle,String key,String defalut) throws Exception;
	
	/**
	 * 获取国际化消息，带有参数
	 * @param lan
	 * @param airline
	 * @param bundle
	 * @param key
	 * @param defalut
	 * @param args  
	 * @return
	 * @throws Exception
	 */
	public String getMessage(String bundle,String key,String defalut, Object[] args) throws Exception;
	
	/**
	 * 获取国际化消息
	 * @param locale
	 * @param bundle
	 * @param key
	 * @param defalut
	 * @return
	 * @throws Exception
	 */
	public String getMessage(String locale, String bundle,String key,String defalut) throws Exception;

	public  String getMessage(String locale, String airline, String bundle, String key, String defalut, Object[] objArray)
    throws Exception;

	public Map<String, String> loadTagInfo_AES();


	/**
	 * 刷新缓存
	 * @return
	 * @throws Exception 
	 */
	public void refreshAll() throws Exception;
	
	
	/*public  String getMessage(java.util.Locale locale, String airline, String bundle, String key, String defalut, Object[] objArray)
	throws Exception;*/
}
