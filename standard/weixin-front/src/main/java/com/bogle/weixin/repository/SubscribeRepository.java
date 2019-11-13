package com.bogle.weixin.repository;

import com.bogle.weixin.domain.Subscribe;
import org.springframework.data.repository.CrudRepository;

public interface SubscribeRepository extends CrudRepository<Subscribe, Long> {

    Subscribe findByOpendId(String openId);
}