package com.fm.pojo.order;

public class FmOrder {
    private Long id;

    private Long postfee;

    private String message;

    private Long userId;

    private Long shippingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostfee() {
        return postfee;
    }

    public void setPostfee(Long postfee) {
        this.postfee = postfee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }
}