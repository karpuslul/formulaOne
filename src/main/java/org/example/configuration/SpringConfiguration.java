package org.example.configuration;

import org.example.factory.PilotFactory;
import org.example.factory.PilotImpl;
import org.example.factory.TeamFactory;
import org.example.factory.TeamFactoryImpl;
import org.example.services.GreetingService;
import org.example.services.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
public class SpringConfiguration {
    @Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }

    @Bean
    @Description("Создание в БД нового пилота")
    PilotFactory createPilot() {
        return new PilotImpl();
    }

    @Bean
    @Description("Создание в БД новой команды")
    TeamFactory createTeam() {
        return new TeamFactoryImpl();
    }
}