package com.bogle.weixin.component;

/**
 * 微信配置信息
 * Created by Administrator on 2015/8/17.
 */
public class WeixinInfo {

    /**
     * 微信appid
     */
    private String appId;//应用ID

    /**
     * 微信应用密钥
     */
    private String appSecret;//应用密钥

    /**
     * 消息加解密密钥
     */
    private String encodingAESKey;//消息加解密密钥

    /**
     * 微信token
     */
    private String tokenKey;//微信token

    /**
     * 微信二维码图片
     */
    private String name = "微信二维码";//

    private String suffix = ".jpg";


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }
}
