package org.example.factory;

import org.example.entity.Pilot;

public interface PilotFactory {
    String NAME = "formulaOne_PilotFactory";

    Pilot create(String name);
}