package com.chenguangli.spring.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;


@Configuration
public class DbConfig {

    /**
     * jndi数据源配置
     *
     * @return
     */
    @Profile("jndi")
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
    @Profile("jdbc")
    @Bean
    public DataSource dataSource() {
        //每个连接请求都会返回一个新建的连接, 没有进行池化管理
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //与上述相似每个连接请求都会返回一个新建的连接, 但是它直接使用JDBC驱动, 来解决在特定环境下的类加载的问题, 这样的环境包括OSGi容器
        SimpleDriverDataSource ds1 = new SimpleDriverDataSource();
        //在每一个连接请求时候都会返回同一个连接, 可以说是只有一个连接的池
        SingleConnectionDataSource ds2 = new SingleConnectionDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/chenguangli?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }


    /**
     * 使用嵌入式数据库
     * 支持的类型有:
     *
     * @return
     * @see EmbeddedDatabaseType
     */
    @Bean
    @Profile("h2")
    public DataSource embeddedDatabase() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }


    /**
     * spring提供了三种jdbc模板
     * 1.JdbcTemplate: 最基本的, 支持简单的JDBC数据库访问功能以及基于索引参数的查询
     * 2.NamedParameterJdbcTemplate: 执行查询时可以将值以命名参数的形式绑定到SQL中, 而不是使用的简单的索引参数
     * 3.SimpleJdbcTemplate: 利用Java 5的一些特性如自动装箱、泛型以及可变参数列表来简化JDBC模板的利用(已废弃)
     *
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        System.out.println("using jdbcTemplate");
        JdbcTemplate template = new JdbcTemplate(dataSource);
        System.out.println("jdbcTemplate 内存地址:" + System.identityHashCode(template));
        return template;

    }

    /**
     * 当使用
     *
     * @see JdbcSpitterRepository#INSERT_NEW 这种形式的时候使用以下装入方式
     */
    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate1(DataSource dataSource) {
        System.out.println("using jdbcTemplate1");
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
        System.out.println("jdbcTemplate1 内存地址:" + System.identityHashCode(template));
        return template;
    }


    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
        System.out.println("spitterRepository jdbcTemplate 内存地址:" + System.identityHashCode(jdbcTemplate));
        return new JdbcSpitterRepository(jdbcTemplate);
    }
}
