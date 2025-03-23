package net.will.javatest.java.util.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureUses {
    public Future<String> calculateAsync() {
        CompletableFuture<String> future = new CompletableFuture<>();

        try (ExecutorService exec = Executors.newCachedThreadPool()) {
            exec.submit(() -> {
                TimeUnit.MILLISECONDS.sleep(100);
                future.complete("hello");
                return null;
            });
        }

        return future;
    }

    public Future<String> completedFuture() {
        return CompletableFuture.completedFuture("hello");
    }

    public Future<String> supplyAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "hello";
        });
    }

    public String handleResultWithReturn(String name) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " " + name);
        return future.get();
    }

    public Void handleResultNoFurtherReturn() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(System.out::println);
        return future.get();
    }

    public void handleResultNoInputNorOutput() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenRun(() -> System.out.println("Job done"));
        future.get();
    }

    /*
     * If the idea is to chain CompletableFuture methods, then it’s better to use thenCompose().
     */
    public String combineFutureWithThenCompose() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        return future.get();
    }

    public String combineFutureWithThenCombine() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> s1 + s2
                );
        return future.get();
    }

    public void combineFutureWithThenAcceptBoth() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(
                        CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2) -> System.out.println(s1 + s2)
                );
        future.get();
    }

    public List<Future<String>> waitUntilMultipleFuturesCompleteInParallel() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "one";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "two";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "three";
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
        combinedFuture.get();
        return Arrays.asList(future1, future2, future3);
    }

    public String combineResultsOfMultipleFutures() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "one";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "two";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "three";
        });

        return Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
    }

    public String handleWithException(String name) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Got a null of name");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        return future.get();
    }

    public Future<String> completeExceptionally() {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("Found an error"));
        return future;
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

    public List<String> combineGreetings(List<String> names) {
        try (ExecutorService threeThreadsAtMostExecutor = Executors.newFixedThreadPool(3)) {
            List<CompletableFuture<String>> futureResults = new ArrayList<>();

            names.forEach((name) -> {
                CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(() -> {
                    return sayHiiiiiiii(name);
                }, threeThreadsAtMostExecutor);

                futureResults.add(oneFuture);
            });

            List<String> combinedResults = new ArrayList<>();
            futureResults.forEach((future) -> {
                try {
                    combinedResults.add(future.get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });

            return combinedResults;
        }
    }

    private String sayHiiiiiiii(String name) {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Hi, " + name;
    }

    public String whenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture<String> endFuture = future.completeAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Job done";
        }).whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(result);
            } else {
                System.out.println("Job failed because of " + ex.getMessage());
            }
        });

        return endFuture.get();
    }
}
