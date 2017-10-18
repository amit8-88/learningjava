package io.github.amit;

import io.github.amit.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "io.github.amit")
@EnableAspectJAutoProxy
public class AppConfig {

    @Autowired
    DataSource dataSource;

    @Autowired
    List<Team> teams;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }


}
