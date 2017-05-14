package com.fm.pojo.flower;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FmFlower {
    private Long id;

    private Integer growth;

    private Integer quality;

    private Integer thriving;

    private Integer sunshine;

    @JsonIgnore
    private Long userId;

    private Long flowerId;


    public FmFlower() {
        this.quality = 0;
        this.thriving = 0;
        this.sunshine = 0;
        this.growth = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getThriving() {
        return thriving;
    }

    public void setThriving(Integer thriving) {
        this.thriving = thriving;
    }

    public Integer getSunshine() {
        return sunshine;
    }

    public void setSunshine(Integer sunshine) {
        this.sunshine = sunshine;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Long flowerId) {
        this.flowerId = flowerId;
    }
}