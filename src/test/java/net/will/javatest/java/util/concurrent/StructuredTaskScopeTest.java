package net.will.javatest.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StructuredTaskScopeTest {
    @Test
    public void testShutdownOnFailure() throws Exception {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var f1 = scope.fork(() -> String.format("Result of virtual thread [%d].", Thread.currentThread().threadId()));
            var f2 = scope.fork(() -> String.format("Result of virtual thread [%d].", Thread.currentThread().threadId()));

            scope.join().throwIfFailed();

            String result = Stream.of(f1, f2).map(Supplier::get).collect(Collectors.joining("\n-\n"));
            System.out.println(result);
            assertNotNull(result);
        }
    }
}
