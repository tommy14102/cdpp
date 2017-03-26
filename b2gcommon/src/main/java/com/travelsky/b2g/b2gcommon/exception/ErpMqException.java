package com.travelsky.b2g.b2gcommon.exception;

/**
 * Created by zhuxiaoyu on 2016/12/10.
 */
public class ErpMqException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -4487940740367472093L;
    private ResponseCode code = ResponseCode.UNKNOWN_ERROR;

    public ErpMqException(ResponseCode code){
        super(code.getMessage());
        this.code = code;
    }

    public ErpMqException(ResponseCode code, Throwable t){
        super(code.getMessage(), t);
        this.code = code;
    }

    public ErpMqException(ResponseCode code, Object... parameterName){
        super(code.getMessage(parameterName));
        this.code = code;
    }

    public ErpMqException(Throwable t){
        super(t);
    }

    public ErpMqException(String msg){
        super(msg);
    }

    public ResponseCode getCode() {
        return code;
    }
}
