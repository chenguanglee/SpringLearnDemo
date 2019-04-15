package com.chenguangli.spring.mybatis;

import com.chenguangli.spring.db.DbConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Create by chenguangli on 2019/4/13 23:02
 */
@Configuration
@Import(DbConfig.class)
public class MybatisConfig {


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("Mapper/SpitterMapper.xml"));
        //factoryBean.setTypeAliases(new Class[]{Spitter.class});
        factoryBean.setConfiguration(configuration());
        return factoryBean.getObject();
    }

    @Bean
    public SpitterDao spitterMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate.getMapper(SpitterDao.class);
    }

//    @Bean
//    public SpitterDao mapperMapperFactoryBean(SqlSessionFactory sqlSessionFactory) throws Exception {
//        MapperFactoryBean<SpitterDao> mapperFactoryBean = new MapperFactoryBean();
//        mapperFactoryBean.setMapperInterface(SpitterDao.class);
//        mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return mapperFactoryBean.getObject();
//    }

    @Bean
    public org.apache.ibatis.session.Configuration configuration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.addMapper(SpitterDao.class);
        return configuration;
    }
}
