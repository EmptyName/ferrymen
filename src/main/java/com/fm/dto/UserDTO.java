package com.fm.dto;

import com.fm.pojo.user.FmUser;

/**
 * Created by aiyi on 2017/5/13.
 */
public class UserDTO {

    private FmUser user;
    private Integer fm;
    private Integer propsNum;

    public FmUser getUser() {
        return user;
    }

    public void setUser(FmUser user) {
        this.user = user;
    }

    public Integer getFm() {
        return fm;
    }

    public void setFm(Integer fm) {
        this.fm = fm;
    }

    public Integer getPropsNum() {
        return propsNum;
    }

    public void setPropsNum(Integer propsNum) {
        this.propsNum = propsNum;
    }

    public UserDTO(FmUser user, Integer fm, Integer propsNum) {
        this.user = user;
        this.fm = fm;
        this.propsNum = propsNum;
    }
}
