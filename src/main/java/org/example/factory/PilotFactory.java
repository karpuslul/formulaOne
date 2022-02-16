package org.example.factory;

import org.example.Entity.Pilot;

public interface PilotFactory {
    String NAME = "formulaOne_PilotFactory";

    Pilot create(String name);
}