package com.travelsky.b2g.b2gcommon.exception;

/**
 * Created by zhuxiaoyu on 16/3/31.
 */
public class ErpException extends RuntimeException {

    private static final long serialVersionUID = -2609810710632713363L;

    public ErpException(String message) {
        super(message);
    }

    public ErpException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErpException(Throwable cause) {
        super(cause);
    }
}
