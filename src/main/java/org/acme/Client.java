package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class Client {

    static final CountDownLatch BOTH_INSIDE_PROXY = new CountDownLatch(2);

    public Client() {
        BOTH_INSIDE_PROXY.countDown();
        try {
            BOTH_INSIDE_PROXY.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String name() {
        return "real";
    }
}
