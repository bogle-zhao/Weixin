package com.bogle.weixin.message.template;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/9.
 */
public class TemplateMsgData implements Serializable {

    @JsonProperty(value = "value")
    private String value;

    @JsonProperty(value = "color")
    private String color;

    public TemplateMsgData() {
    }

    public TemplateMsgData(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
