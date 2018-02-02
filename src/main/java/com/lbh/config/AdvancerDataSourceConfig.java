package com.lbh.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * Created by Advancer on 2018/1/23 10:42.
 * auth: lbh
 */
@Configuration
@MapperScan(basePackages = AdvancerDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "advancerSqlSessionFactory")
public class AdvancerDataSourceConfig {

    //精确到具体目录
    static final String PACKAGE = "com.lbh.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Value("${advancer.datasource.driverClassName}")
    private String driverClass;

    @Value("${advancer.datasource.url}")
    private String url;

    @Value("${advancer.datasource.username}")
    private String userName;

    @Value("${advancer.datasource.password}")
    private String password;

    @Bean("advancerDataSource")
    @Primary
    public DataSource advancerDataSource(){
        DruidXADataSource dataSource = new DruidXADataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        AtomikosDataSourceBean xaDatasource = new AtomikosDataSourceBean();
        xaDatasource.setUniqueResourceName("advancerDataSource");
        xaDatasource.setXaDataSource(dataSource);
        return xaDatasource;
    }

    @Bean(name = "advancerSqlSessionFactory")
    @Primary
    public SqlSessionFactory advancerSqlSessionFactory(@Qualifier("advancerDataSource") DataSource advancerdataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(advancerdataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                                        .getResources(AdvancerDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}





















