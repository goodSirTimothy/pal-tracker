package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    @Bean
    public static TimeEntryRepository inMemoryTimeEntryRepository(@Value("${SPRING_DATASOURCE_URL}") String SPRING_DATASOURCE_URL) {
        System.out.println(SPRING_DATASOURCE_URL);
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(SPRING_DATASOURCE_URL);
        return new JdbcTimeEntryRepository(dataSource);
    }
}
