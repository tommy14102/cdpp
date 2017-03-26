package com.travelsky.b2g.b2gcommon.exception;

/**
 * Created by zhuxiaoyu on 2016/10/19.
 */
public class ErpServiceException  extends ErpException {
    /**
     *
     */
    private static final long serialVersionUID = -4487940740367472093L;

    private ResponseCode code = ResponseCode.UNKNOWN_ERROR;

    public ErpServiceException(ResponseCode code){
        super(code.getMessage());
        this.code = code;
    }

    public ErpServiceException(ResponseCode code, Throwable t){
        super(code.getMessage(), t);
        this.code = code;
    }

    public ErpServiceException(ResponseCode code, Object... parameterName){
        super(code.getMessage(parameterName));
        this.code = code;
    }

    public ErpServiceException(Throwable t){
        super(t);
    }

    public ErpServiceException(String msg){
        super(msg);
    }

    public ResponseCode getCode() {
        return code;
    }
}
