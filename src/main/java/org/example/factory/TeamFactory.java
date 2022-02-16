package org.example.factory;

import org.example.Entity.Team;

public interface TeamFactory {
    String NAME = "formeulaOne_TeamFactory";

    Team create(String name);
}
