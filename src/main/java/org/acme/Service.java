package org.acme;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class Service {

    @Inject
    Client client;

    void onStart(@Observes StartupEvent event) {
    }

    public String clientName() {
        return client.name();
    }
}
