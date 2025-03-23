package net.will.javatest.basicconcept.jdk9;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompletableFutureUsesInJdkNineTest {

    @Test
    public void testOrTimeoutBehavior() {
        assertThrows(ExecutionException.class, () -> {
            new CompletableFutureUsesInJdkNine().orTimeoutBehavior().get();
        });
    }

    @Test
    public void testCompleteAsync() throws ExecutionException, InterruptedException {
        Future<String> future = new CompletableFutureUsesInJdkNine().completeAsync();

        assertEquals("done", future.get());
    }
}
