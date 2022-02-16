package org.example.factory;

import org.example.entity.Team;

public interface TeamFactory {
    String NAME = "formeulaOne_TeamFactory";

    Team create(String name);
}
