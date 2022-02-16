package org.example;

import org.example.entity.Pilot;
import org.example.entity.Team;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.configuration.SpringConfiguration;
import org.example.factory.PilotFactory;
import org.example.factory.TeamFactory;
import org.example.services.GreetingService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Starter {
    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        // todo вот это нужно заменить на проперти
        BasicConfigurator.configure();
        logger.info("Starting configuration...");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);

        List<String> entityNames = greetingService.getEntityNames();
        for (String entityName : entityNames) {
            System.out.println(entityName);
        }


        PilotFactory pilotFactory = context.getBean(PilotFactory.class);
        Pilot pilot = pilotFactory.create("Mick Shumaher");

        TeamFactory teamFactory = context.getBean(TeamFactory.class);
        Team team = teamFactory.create("Red Bull");

        // Добавить запись в таблицу пилотов и команд
        Session session = Connection.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(pilot);
        session.save(team);
        transaction.commit();
        session.close();
    }
}
