package org.example.factory;

import org.example.Entity.Team;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(TeamFactory.NAME)
public class TeamFactoryImpl implements TeamFactory {

    public Team create(String name) {
        Team team = new Team();
        team.setId(UUID.randomUUID());
        team.setName(name);

        return team;
    }
}
