package com.chenguangli.spring.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;


@Configuration
public class DbConfig {

    /**
     * jndi数据源配置
     *
     * @return
     */
    @Bean
    public JndiObjectFactoryBean jndiDataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpittrDs");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return jndiObjectFactoryBean;
    }


    /**
     * jdbc数据源配置
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        //每个连接请求都会返回一个新建的连接, 没有进行池化管理
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //与上述相似每个连接请求都会返回一个新建的连接, 但是它直接使用JDBC驱动, 来解决在特定环境下的类加载的问题, 这样的环境包括OSGi容器
        SimpleDriverDataSource ds1 = new SimpleDriverDataSource();
        //在每一个连接请求时候都会返回同一个连接, 可以说是只有一个连接的池
        SingleConnectionDataSource ds2 = new SingleConnectionDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        ds.setUsername("sa");
        ds.setPassword("123");
        return ds;
    }
}
