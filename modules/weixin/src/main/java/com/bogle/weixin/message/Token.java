package com.bogle.weixin.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信的tokey对象
 * Created by Administrator on 2015/8/17.
 */
public class Token extends WxMsg {

    /** 失效时间*/
    @JsonProperty(value = "expires_in")
    private Long expiresIn;

    /** 是否refresh*/
    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    /** token类型返回*/
    @JsonProperty(value = "scope")
    private String scope;

    @JsonProperty(value = "unionid")
    private String unionid;

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
