package org.acme;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Job {

    @Inject
    Client client;

    @Scheduled(every = "1h")
    void run() {
        client.name();
    }

    public String clientName() {
        return client.name();
    }
}
