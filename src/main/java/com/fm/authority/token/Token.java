package com.fm.authority.token;

/**
 * Created by aiyi on 2017/5/6.
 */
public class Token {

    private Long uid;
    private String uuid;

    protected Token(Long uid, String uuid) {
        this.uid = uid;
        this.uuid = uuid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUid() {
        return uid;
    }

    public String getUuid() {
        return uuid;
    }

    public static Token creatToken(Long uid, String uuid) {
        return new Token(uid, uuid);
    }


    @Override
    public String toString() {
        return uid + "_" + uuid;
    }
}
