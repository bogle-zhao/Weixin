package com.bogle.weixin.repository;

import com.bogle.weixin.domain.RobotMsg;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 机器人自动回复消息
 */
public interface RobotMsgRepository extends CrudRepository<RobotMsg, Long> {

    /**
     * 返回所有的回复内容信息
     * @return
     */
    @Query(value = "select * from weixin_robot_msg", nativeQuery = true)
    @Cacheable(value = "wechat:keyword:text", keyGenerator = "keyGenerator")
    List<RobotMsg> findAll();
}