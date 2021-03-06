package com.bogle.weixin.message;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * fansopenid集合信息
 * Created by Bogle on 2015/12/7.
 */
public class Openid implements Serializable {

    @JsonProperty(value = "openid")
    private List<String> openids;

    public List<String> getOpenids() {
        return openids;
    }

    public void setOpenids(List<String> openids) {
        this.openids = openids;
    }
}
