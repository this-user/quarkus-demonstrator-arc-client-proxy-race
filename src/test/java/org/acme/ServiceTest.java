package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
class ServiceTest {

    @Inject
    Service service;

    @Inject
    Job job;

    @BeforeAll
    static void mock() {
        var mock = Mockito.mock(Client.class);
        Mockito.when(mock.name()).thenReturn("mock");
        QuarkusMock.installMockForType(mock, Client.class);
    }

    @Test
    void usesTheMock() {
        assertEquals("mock", service.clientName());
        assertEquals("mock", job.clientName());
    }
}
