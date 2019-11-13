package com.bogle.weixin.exception;

import com.bogle.weixin.defines.WxCode;

/**
 * 微信http异常信息
 * Created by Administrator on 2015/6/10.
 */
public class WeixinException extends Exception {

    private WxCode errcode;

    public WeixinException(String message, WxCode errcode) {
        super(message);
        this.errcode = errcode;
    }

    public WxCode getErrcode() {
        return errcode;
    }
}
