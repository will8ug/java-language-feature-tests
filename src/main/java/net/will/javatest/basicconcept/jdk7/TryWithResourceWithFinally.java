package net.will.javatest.basicconcept.jdk7;

import java.io.Closeable;
import java.io.IOException;

/**
 * Just want to check which logic goes first:
 * <ul>
 * <li>Closeable.close() in try-with clause, or</li>
 * <li>Something in finally clause.</li>
 * </ul>
 */
public class TryWithResourceWithFinally {
    public static void main(String[] args) throws IOException {
        try (CloseMePlease closeMePlease = new CloseMePlease()) {
            closeMePlease.doSomething();
        } finally {
            System.out.println("Now we are in finally{}");
        }
    }
}

class CloseMePlease implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("Good, I'm closed!");
    }

    void doSomething() {
        System.out.println("Doing something...");
    }
}
