package com.bogle.weixin.service;

import com.bogle.weixin.defines.OauthDefines;
import com.bogle.weixin.defines.WxCode;
import com.bogle.weixin.message.AutoLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/8/31.
 */
@Service
public class AutoLoginService {

    private final static Logger log = LoggerFactory.getLogger(AutoLoginService.class);

    @Autowired
    private IWxApi wxApi;

    /**
     * 自动登陆
     * 1. 授权获取openid
     *
     * @param code
     * @return
     */
    public OauthDefines snsapi(String code) {
        log.debug("授权获取openid");
        try {
            OauthDefines<String> oauthDefines = this.wxApi.snsapi(code);
            AutoLogin data = new AutoLogin();
            data.setOpenid(oauthDefines.getData());
            return new OauthDefines(oauthDefines.getCode(),data);
        } catch (Exception e) {
            OauthDefines oauthDefines = new OauthDefines(WxCode.ERROR);
            return oauthDefines;
        }
    }
}
