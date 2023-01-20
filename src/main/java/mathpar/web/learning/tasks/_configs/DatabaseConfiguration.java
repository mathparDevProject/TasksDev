package mathpar.web.learning.tasks._configs;

import com.mysql.cj.jdbc.MysqlDataSource;
import mathpar.web.learning.tasks.utils.MathparProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EntityScan(basePackages = "mathpar.web.learning.tasks.entities")
@EnableJpaRepositories(basePackages = "mathpar.web.learning.tasks.repositories")
public class DatabaseConfiguration {
    @Bean
    @Profile("!test")
    public DataSource dataSource(MathparProperties mathparProperties){
        var datasource = new MysqlDataSource();
        datasource.setUrl(mathparProperties.getDatabaseUrl());
        datasource.setUser(mathparProperties.getDatabaseUsername());
        datasource.setPassword(mathparProperties.getDatabasePassword());
        return datasource;
    }
}
