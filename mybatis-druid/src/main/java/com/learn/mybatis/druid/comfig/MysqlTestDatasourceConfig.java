package com.learn.mybatis.druid.comfig;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = MysqlTestDatasourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlTestSqlSessionFactory")
public class MysqlTestDatasourceConfig {

    // mysqlTestdao扫描路径
    static final String PACKAGE = "com.learn.mybatis.druid.mysqlTestDao";
    // mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mybatis/mysqlTestMapper/*.xml";

    @Bean(name = "mysqlTestDatasource")
    @ConfigurationProperties("spring.datasource.druid.mysqltest")
    public DataSource mysqlTestDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlTestTransactionManager")
    public DataSourceTransactionManager mysqlTestTransactionManager() {
        return new DataSourceTransactionManager(mysqlTestDataSource());
    }

    @Bean(name = "mysqlTestSqlSessionFactory")
    public SqlSessionFactory mysqlTestSqlSessionFactory(@Qualifier("mysqlTestDatasource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MysqlTestDatasourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}