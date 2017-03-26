package com.travelsky.b2g.b2gcommon.exception;

import java.util.Map;

/**
 * Created by zhuxiaoyu on 2016/10/19.
 */
public class ErpOrderException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -4487940740367472093L;

    Map<String, Object> emap ;

    public ErpOrderException(Map<String, Object> emap){
        this.emap = emap;
    }

    public ErpOrderException(Map<String, Object> emap, Throwable t){
        super( t);
        this.emap = emap;
    }

    public ErpOrderException(Throwable t){
        super(t);
    }

    public ErpOrderException(String msg){
        super(msg);
    }

    public Map<String, Object> getEmap() {
        return emap;
    }

    public void setEmap(Map<String, Object> emap) {
        this.emap = emap;
    }
}
