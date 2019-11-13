package com.bogle.weixin.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "weixin_robot_msg")
public class RobotMsg implements Serializable {

    private static final long serialVersionUID = -5043225876578531862L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "msg_type")
    private String msgType;

    @Column(name = "content")
    private String content;

    @Column(name = "keyword")
    private String keyword;

    @Column(name = "desc")
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}