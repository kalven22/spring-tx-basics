package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"repositories", "services"})
@EnableTransactionManagement
public class ProjectConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:55000/Order");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgrespw");
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate template(DataSource dataSource){
        var template = new JdbcTemplate(dataSource);
        return template;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        var tm = new DataSourceTransactionManager(dataSource);
        return tm;
    }
}
