package com.sec.aidog.util;

public class JsonResult {
    private Integer code = null;
    private String msg = null;
    private boolean success = false;
    private Object data = null;

    public JsonResult(){}

    public JsonResult(Integer code,String msg, boolean success, Object data){
        this.code = code;
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
