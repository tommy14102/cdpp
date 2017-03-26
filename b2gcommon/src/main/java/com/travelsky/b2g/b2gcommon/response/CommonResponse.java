package com.travelsky.b2g.b2gcommon.response;

/**
 * Created by tommy14101 on 2017/3/25.
 */
public class CommonResponse {

    private String code;
    private String message;


    public CommonResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
