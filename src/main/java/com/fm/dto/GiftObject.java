package com.fm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fm.pojo.order.FmOrderItem;
import com.fm.pojo.order.FmOrderShipping;

import java.util.List;

/**
 * Created by aiyi on 2017/5/6.
 */
public class GiftObject {

    @JsonProperty("postfee")
    private Long postFee;

    private String message;

    @JsonProperty("orderitems")
    private List<FmOrderItem> orderItems;

    @JsonProperty("ordershipping")
    private FmOrderShipping orderShipping;

    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FmOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<FmOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public FmOrderShipping getOrderShipping() {
        return orderShipping;
    }

    public void setOrderShipping(FmOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }
}
