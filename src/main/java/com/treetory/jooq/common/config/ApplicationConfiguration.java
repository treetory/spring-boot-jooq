package com.treetory.jooq.common.config;

import com.google.gson.Gson;
import com.treetory.jooq.common.properties.H2DatasourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableAsync
@EnableWebMvc
public class ApplicationConfiguration implements WebMvcConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

    private final WebApplicationContext appContext;

    private final H2DatasourceProperties datasourceProperties;

    public ApplicationConfiguration(WebApplicationContext appContext, H2DatasourceProperties datasourceProperties) {
        this.appContext = appContext;
        this.datasourceProperties = datasourceProperties;
    }

    /**
     * 스프링 부트의 auto configuration 을 그대로 쓴다.
     * 즉, dataSource 의 필요 property 는 application.properties 에 설정된 기본값을 쓴다.
     */
    @Bean(name = "h2DataSource")
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(this.datasourceProperties.getDriverClassName());
        config.setJdbcUrl(this.datasourceProperties.getUrl());
        config.setUsername(this.datasourceProperties.getUsername());
        config.setPassword(this.datasourceProperties.getPassword());
        config.setMaximumPoolSize(this.datasourceProperties.getMaxActive());
        config.setMinimumIdle(this.datasourceProperties.getMinIdle());
        config.setPoolName("[H2]");
        HikariDataSource dataSource = new HikariDataSource(config);
        LOG.debug("{}", this.datasourceProperties);
        LOG.debug("{}", config);

        return dataSource;
    }

    /**
     * Configure jOOQ's ConnectionProvider to use Spring's TransactionAwareDataSourceProxy,
     * which can dynamically discover the transaction context
     *
     * 스프링 부트가 DataSourceTransactionManager 를 직접 물고 있기 때문에,
     * jOOQ 는 proxy 를 이용하여 transaction 관리를 하는 것 같다.
     *
     * @return  DataSourceConnectionProvider
     */
    @Bean(name = "h2ConnectionProvider")
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy((DataSource) appContext.getBean("h2DataSource")));
    }

    /**
     * DSLContext 에 전달해야 하는 설정을 기본적으로 구성한다.
     * 1. SQLDialect 를 지정하여 어떤 DBMS 의 문법(특유의 function 등)을 사용할 것인지 지정한다.
     * 2. DB Connection 객채를 제공하는 ConnectionProvider 를 지정한다.
     * 3. 실행 결과의 Listening 을 담당하는 Provider 를 지정한다.
     *    -> 실행과정에서 생기는 오류를 translate 하기 위해 JooqExceptionTranslator 를 넣어주었다.
     *
     * @return
     */
    @Bean(name = "jooqConfiguration")
    public DefaultConfiguration jooqConfiguration() {

        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(SQLDialect.POSTGRES);
        jooqConfiguration.set((ConnectionProvider) appContext.getBean("h2ConnectionProvider"));
        jooqConfiguration.set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));

        return jooqConfiguration;
    }

    /**
     * JSON parser, generator 역할을 수행
     *
     * @return
     */
    @Bean(name = "gson")
    public Gson gson() {
        return new Gson();
    }

}
