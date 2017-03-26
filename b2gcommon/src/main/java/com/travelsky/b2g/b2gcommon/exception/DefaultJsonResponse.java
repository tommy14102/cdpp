package com.travelsky.b2g.b2gcommon.exception;

/**
 * Created by zhuxiaoyu on 16/3/13.
 */
public class DefaultJsonResponse {

    private int err;
    private String msg;
    private int seq;

    private String status;

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}