package net.will.javatest.basicconcept.jdk9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CompletableFutureUsesInJdkNine {
    public Future<Void> orTimeoutBehavior() {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("don't expect to print this");
        }).orTimeout(500, TimeUnit.MILLISECONDS);
    }

    public Future<String> completeAsync() {
        CompletableFuture<String> future = new CompletableFuture<>();
        return future.completeAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "done";
        });
    }
}
