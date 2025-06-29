package net.will.javatest.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualThreadPoolTest {
    @Test
    public void testVirtualThreadPool() throws Exception {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> future = executorService.submit(() -> {
                assertTrue(Thread.currentThread().isVirtual());

                Long threadId = Thread.currentThread().threadId();
                System.out.printf("Running in a virtual thread [%d].\n", threadId);
                return threadId;
            });

            assertNotNull(future.get());
        }
    }
}
