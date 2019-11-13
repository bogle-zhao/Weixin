package com.bogle.weixin.message;

/**
 * 二维码
 * Created by Administrator on 2015/8/18.
 */
public class Qrcode extends WxMsg {

    public Qrcode() {
    }

    public Qrcode(byte[] bytes) {
        this.bytes = bytes;
    }

    private byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
