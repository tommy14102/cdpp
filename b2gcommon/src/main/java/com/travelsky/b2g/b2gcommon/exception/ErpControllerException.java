package com.travelsky.b2g.b2gcommon.exception;

/**
 * Created by zhuxiaoyu on 16/3/31.
 */
public class ErpControllerException extends ErpException {

    /**
     *
     */
    private static final long serialVersionUID = -4487940740367472093L;

    private ResponseCode code = ResponseCode.UNKNOWN_ERROR;

    public ErpControllerException(ResponseCode code){
        super(code.getMessage());
        this.code = code;
    }

    public ErpControllerException(ResponseCode code, Throwable t){
        super(code.getMessage(), t);
        this.code = code;
    }

    public ErpControllerException(ResponseCode code, Object... parameterName){
        super(code.getMessage(parameterName));
        this.code = code;
    }

    public ErpControllerException(Throwable t){
        super(t);
    }

    public ErpControllerException(String msg){
        super(msg);
    }

    public ResponseCode getCode() {
        return code;
    }

}
