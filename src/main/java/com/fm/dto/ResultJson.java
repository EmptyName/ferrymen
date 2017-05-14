package com.fm.dto;

/**
 * Created by aiyi on 2017/5/2.
 */
public class ResultJson {
    private int code;
    private String info;
    private Object data;


    private ResultJson(int code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }


    public static ResultJson ok() {
        return new ResultJson(200, "OK", null);
    }

    public static ResultJson ok(Object data) {
        return new ResultJson(200, "ok", data);
    }

    public static ResultJson build(int code, String info) {
        return new ResultJson(code, info, null);
    }

    public static ResultJson build(int code, String info, Object data) {
        return new ResultJson(code, info, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
