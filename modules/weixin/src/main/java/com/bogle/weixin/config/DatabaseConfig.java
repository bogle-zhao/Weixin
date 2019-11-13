package com.bogle.weixin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据库管理配置
 * Created by Bogle on 2015/11/28.
 */
@Configuration
public class DatabaseConfig {

    /**
     * 数据源配置，根据prefix前缀查看application.yml文件
     * @return
     */
    @Primary
    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.dataSource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
