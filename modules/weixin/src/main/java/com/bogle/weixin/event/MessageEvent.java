package com.bogle.weixin.event;

import org.springframework.context.ApplicationEvent;

/**
 * 消息类型
 * Created by Administrator on 2015/8/18.
 */
public class MessageEvent extends ApplicationEvent {

    public MessageEvent(Object source) {
        super(source);
    }
}
