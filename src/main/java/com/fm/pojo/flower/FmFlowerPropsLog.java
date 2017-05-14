package com.fm.pojo.flower;

import java.util.Date;

public class FmFlowerPropsLog {
    private Long id;

    private Long userId;

    private Long propsId;

    private Date useTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPropsId() {
        return propsId;
    }

    public void setPropsId(Long propsId) {
        this.propsId = propsId;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
}