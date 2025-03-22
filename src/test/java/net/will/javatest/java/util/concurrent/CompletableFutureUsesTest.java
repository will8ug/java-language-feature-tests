package net.will.javatest.java.util.concurrent;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

public class CompletableFutureUsesTest {
    @Test
    public void testCalculateAsync() throws ExecutionException, InterruptedException {
        Future<String> stringFuture = new CompletableFutureUses().calculateAsync();

        assertEquals("hello", stringFuture.get());
    }

    @Test
    public void testCompletedFuture() throws ExecutionException, InterruptedException {
        Future<String> future = new CompletableFutureUses().completedFuture();

        assertEquals("hello", future.get());
    }

    @Test
    public void testSupplyAsync() throws ExecutionException, InterruptedException {
        Future<String> future = new CompletableFutureUses().supplyAsync();

        assertEquals("hello", future.get());
    }

    @Test
    public void testHandleResultWithReturn() throws ExecutionException, InterruptedException {
        String result = new CompletableFutureUses().handleResultWithReturn("World");

        assertEquals("Hello World", result);
    }

    @Test
    public void testHandleResultNoFurtherReturn() {
        assertDoesNotThrow(() -> {
            new CompletableFutureUses().handleResultNoFurtherReturn();
        });
    }

    @Test
    public void testHandleResultNoInputNorOutput() {
        assertDoesNotThrow(() -> {
            new CompletableFutureUses().handleResultNoInputNorOutput();
        });
    }

    @Test
    public void testCombineFutureWithThenCompose() throws ExecutionException, InterruptedException {
        String result = new CompletableFutureUses().combineFutureWithThenCompose();

        assertEquals("Hello World", result);
    }

    @Test
    public void testCombineFutureWithThenCombine() throws ExecutionException, InterruptedException {
        String result = new CompletableFutureUses().combineFutureWithThenCombine();

        assertEquals("Hello World", result);
    }

    @Test
    public void testCombineFutureWithThenAcceptBoth() {
        assertDoesNotThrow(() -> {
            new CompletableFutureUses().combineFutureWithThenAcceptBoth();
        });
    }

    @Test
    public void testWaitUntilMultipleFuturesCompleteInParallel() throws ExecutionException, InterruptedException {
        List<Future<String>> futures = new CompletableFutureUses().waitUntilMultipleFuturesCompleteInParallel();

        assertEquals(3, futures.size());
        assertTrue(futures.getFirst().isDone());
        assertTrue(futures.get(1).isDone());
        assertTrue(futures.getLast().isDone());
    }

    @Test
    public void testCombineResultsOfMultipleFutures() throws ExecutionException, InterruptedException {
        String combinedResult = new CompletableFutureUses().combineResultsOfMultipleFutures();

        assertEquals("one two three", combinedResult);
    }

    @Test
    public void testHandleWithException() throws ExecutionException, InterruptedException {
        String result = new CompletableFutureUses().handleWithException(null);

        assertEquals("Hello, Stranger!", result);
    }

    @Test
    public void testCompleteExceptionally() {
        assertThrows(ExecutionException.class, () -> {
            new CompletableFutureUses().completeExceptionally().get();
        });
    }

    @Test
    public void testCompleteAsync() throws ExecutionException, InterruptedException {
        Future<String> future = new CompletableFutureUses().completeAsync();

        assertEquals("done", future.get());
    }

    @Test
    public void testOrTimeoutBehavior() {
        assertThrows(ExecutionException.class, () -> {
            new CompletableFutureUses().orTimeoutBehavior().get();
        });
    }

    @Test
    public void testCombineGreetings() {
        CompletableFutureUses obj = new CompletableFutureUses();
        List<String> result = obj.combineGreetings(Arrays.asList("Bob", "Alice", "Carol"));

        assertEquals(3, result.size());
        assertTrue(result.contains("Hi, Bob"));
        assertTrue(result.contains("Hi, Alice"));
        assertTrue(result.contains("Hi, Carol"));
    }
}
