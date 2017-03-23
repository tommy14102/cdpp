/*
 * 创建日期 2011-1-17
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.travelsky.b2g.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * @author wangxl
 * 此类主要是为了做流量控制，以后可为每个航空公司网站做流量控制
 * 
 * updated by yxin 20170310
 */
public abstract class BaseDAO{

	private static final Logger log = LoggerFactory.getLogger(BaseDAO.class);
	
	private DataSource dataSource;	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	private JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	/**
	 * 获取BeanPropertyRowMapper，主要目的是允许将数据库中NULL值转化为Java中基本类型的默认值
	 * @param <T>
	 * @param mappedClass
	 * @return
	 */
    protected <T>BeanPropertyRowMapper<T> getBeanPropertyRowMapper(Class<T> mappedClass) {
    	BeanPropertyRowMapper<T> bprm = new BeanPropertyRowMapper<T>(mappedClass);
    	bprm.setPrimitivesDefaultedForNullValue(true);
    	return bprm;
	}
    
	/**
	*使用JdbcTemplate实现的基础查询类，带有参数数组
	*/
	protected <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) {
		log.info(sql + toString(args));
		
		return getJdbcTemplate().query(sql,args,rowMapper);
	}
	
	protected int queryForCount(String sql){
		log.info(sql);
		
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	} 
	
	protected int queryForCount(String sql,Object[] args){
		log.info(sql + toString(args));
		
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	} 

	protected int update(String sql, Object[] args, int[] types){
		log.info(sql + toString(args));
		
		return getJdbcTemplate().update(sql, args, types);
	}
	
	
	protected int update(String sql,SqlParameterSource ps){
		log.info(sql);
		
		return getNamedParameterJdbcTemplate().update(sql, ps);
	}
	
	
	protected int[] batchUpdate(String sql,SqlParameterSource[] ps){
		log.info(sql);
		
		return getNamedParameterJdbcTemplate().batchUpdate(sql,ps);	
	}
	
	 protected int[] batchUpdate(String sql, BatchPreparedStatementSetter setter) {
			log.info(sql);
			
	        return getJdbcTemplate().batchUpdate(sql, setter);
	 }
	
	/**
	*使用JdbcTemplate实现的基础查询类
	*/	
	protected <T> List<T> query(String sql,RowMapper<T> rowMapper) {
		log.info(sql);
		
		return getJdbcTemplate().query(sql,rowMapper);
	}
	
	protected <T>List<T> pageQuery(String baseSql,RowMapper<T> rm,int begin,int length) {	
		String sql="select * from (select rownum as my_rownum,table_a.* from("+baseSql+") table_a where rownum<?) where my_rownum>=?";
		Object[] args=new Object[2];
		args[0] = new Integer(begin+length);
		args[1] = new Integer(begin);
		
		log.info(sql + toString(args));
		
		return query(sql,args,rm);
	}
	
	protected <T>List<T> pageQuery(String baseSql,Object[] paras,RowMapper<T> rm,int begin,int length) {		
		String sql="select * from (select rownum as my_rownum,table_a.* from("+baseSql+") table_a where rownum<?) where my_rownum>=?";
		Object[] args=null;
		int i=0;
		if(paras!=null){
			args = new Object[paras.length+2];
			for(i=0;i<paras.length;i++) args[i]=paras[i];
		}
		else args = new Object[2];
		
		args[i++] = new Integer(begin+length);
		args[i++] = new Integer(begin);
		
		log.info(sql + toString(args));
		
		return query(sql,args,rm);
	}
	
	protected List<Map<String, Object>> queryForList(String sql){
		log.info(sql);
		
		List<Map<String, Object>> objList = this.getJdbcTemplate().queryForList(sql);
		return objList;			
	}
	
	protected List<Map<String, Object>>  queryForList(String sql,Object[] args){
		log.info(sql + toString(args));
		
		List<Map<String, Object>>  objList = this.getJdbcTemplate().queryForList(sql, args);
		return objList;		
	}
	
	protected List<Map<String, Object>> pageQuery(String baseSql,Object[] params,int begin,int length){
		String sql = "select * from (select rownum as my_rownum,table_a.* from("+ baseSql+ ") table_a where rownum<?) where my_rownum>=?" ;
		Object[] args=new Object[params.length+2];
		int i=0;
		if(params!=null){
			args = new Object[params.length+2];
			for(i=0;i<params.length;i++) args[i]=params[i];
		}
		args[i++] = new Integer(begin+length);
		args[i++] = new Integer(begin);

		log.info(sql + toString(args));
		
		return this.queryForList(sql,args);
	}
	
	/**
     * 功能:取得特定订单号 
     * 输入：sequenceName 数据库表对应的sequence的名字 
     * 输出：订单号 
     * 说明：订单号生成规则:时间(如20060412152403)+四位流水号
     * 		时间以数据库时间为准，如果以应用服务器时间为准，如果服务器时间不一致，可造成订单号重复
     * 		现在的实现很弱智，需要改进
     */		
    public final String getNextId(String sequenceName) {
       StringBuffer buf = new StringBuffer();
        buf.append("select to_char(sysdate,'yyyymmddhh24MISS')||");
        buf.append(sequenceName);
        buf.append(".nextval as id from dual");
        try
        {
			String id = (String) getJdbcTemplate().query(buf.toString(),
            new ResultSetExtractor<String>() {
                    public String extractData(ResultSet rs) {
                        String str=null;
                        try {
                            if (rs.next()) {
                                str=rs.getString("id");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return str;
                    }
                });
            return id;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }  

    }

    /**获得参数列表的字符串*/
    private String toString(Object[] params){
    	if(params==null) return "{[]}";
    	StringBuffer buff = new StringBuffer();
    	buff.append("{");
    	for (int i=0;i<params.length;i++){
    		Object obj = params[i];
    		if(obj!=null) buff.append("["+getString(obj)+"]");
    		if(i!=params.length-1)buff.append(",");
    	}
    	buff.append("}");    	
    	return buff.toString();
    }
    
    /**将对象转换为字符串*/
    private String getString(Object obj){
    	if(obj==null) return "null";
    	else if(obj instanceof Date){
    		Date date = (Date)obj;    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss",Locale.SIMPLIFIED_CHINESE);
    		return  sdf.format(date);
    	}
    	else if(obj instanceof String){
    		String str = (String)obj;    		
    		return str;
    	}
    	return obj.toString();
    }
    
}
