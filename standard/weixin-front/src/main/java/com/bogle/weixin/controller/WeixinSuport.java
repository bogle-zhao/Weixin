package com.bogle.weixin.controller;

import com.bogle.weixin.defines.OauthDefines;
import com.bogle.weixin.defines.SnsapiScope;
import com.bogle.weixin.defines.WxCode;
import com.bogle.weixin.message.AutoLogin;
import com.bogle.weixin.service.AutoLoginService;
import com.bogle.weixin.service.IWxApi;
import com.bogle.weixin.service.SubscribeService;
import com.bogle.weixin.service.WeixinMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bogle on 2015/12/22.
 */
public class WeixinSuport {

    private static final Logger log = LoggerFactory.getLogger(WeixinSuport.class);

    @Autowired
    protected IWxApi wxApi;

    @Autowired
    protected AutoLoginService autoLoginService;

    @Autowired
    protected SubscribeService subscribeService;


    protected ModelAndView parse(String code, HttpServletRequest request, String url, String state, boolean openid) {
        log.debug("授权");
        ModelAndView modelAndView = new ModelAndView();
        OauthDefines<AutoLogin> oauthDefines = autoLoginService.snsapi(code);
        if (oauthDefines.getCode() == WxCode.SUCCESS) {
            log.debug("授权成功");
            AutoLogin autoLogin = oauthDefines.getData();
            String eventKey = subscribeService.findEventKeyByOpendId(autoLogin.getOpenid());
            if (eventKey == null || "".equals(eventKey.trim()) || "0".equals(eventKey.trim())) {
                eventKey = WeixinMessageHandler.DEFAULT_EVENT_KEY;
            }
            if (openid) {
                url += "&openId=" + autoLogin.getOpenid();
            }
            url += "&channelCode=" + eventKey;
            modelAndView.setView(new RedirectView(url));
        } else {
            url = request.getRequestURL().toString();
            String redirect = this.wxApi.snsapiUrl(url, SnsapiScope.snsapi_base, state);
            modelAndView.setView(new RedirectView(redirect));
        }
        return modelAndView;
    }
}
