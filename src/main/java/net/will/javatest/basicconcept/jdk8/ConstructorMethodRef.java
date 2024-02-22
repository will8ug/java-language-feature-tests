package net.will.javatest.basicconcept.jdk8;

import java.util.Collection;
import java.util.function.Supplier;

public class ConstructorMethodRef {
    /**
     * Copies elements from one collection to another.
     */
    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
            SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
        System.out.println("Coming into the transferElements()...");

        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            System.out.println("Add 1");
            result.add(t);
        }
        System.out.println("Returning the result with size: " + result.size());
        return result;
    }
}
