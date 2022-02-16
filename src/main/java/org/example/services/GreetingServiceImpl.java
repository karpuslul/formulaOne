package org.example.services;

import org.example.Connection;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(GreetingService.NAME)
public class GreetingServiceImpl implements GreetingService {
    public List<String> getEntityNames() {
        Connection connection = new Connection();
        return connection.connection();
    }
}
