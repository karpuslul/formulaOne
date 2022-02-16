package org.example.factory;

import org.example.entity.Pilot;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(PilotFactory.NAME)
public class PilotImpl implements PilotFactory {

    public Pilot create(String name) {
        Pilot pilot = new Pilot();
        pilot.setId(UUID.randomUUID());
        pilot.setName(name);

        return pilot;
    }
}
