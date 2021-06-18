//package com.learn.mybatis.druid.comfig;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = SqLiteDatasourceConfig.PACKAGE,
//        sqlSessionFactoryRef = "sqLiteSqlSessionFactory")
//public class SqLiteDatasourceConfig {
//
//    // sqLitedao扫描路径
//    static final String PACKAGE = "com.learn.mybatis.druid.sqliteDao";
//    // mybatis mapper扫描路径
//    static final String MAPPER_LOCATION = "classpath:mapper/sqLite/*.xml";
//    @Bean(name = "sqlitedatasource")
//    @ConfigurationProperties("spring.datasource.druid.sqlite")
//    public DataSource sqliteDataSource() {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "sqLiteTransactionManager")
//    public DataSourceTransactionManager sqLiteTransactionManager() {
//        return new DataSourceTransactionManager(sqliteDataSource());
//    }
//
//    @Bean(name = "sqLiteSqlSessionFactory")
//    public SqlSessionFactory sqLiteSqlSessionFactory(@Qualifier("sqlitedatasource") DataSource dataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(SqLiteDatasourceConfig.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
//}
