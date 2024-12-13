package net.will.javatest.basicconcept.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        sequentialStream();
        System.out.println("==========");
        parallelStream();
        System.out.println("==========");

        interateOnStaticMethod();
        interateOnInstanceMethod();
    }

    private static void sequentialStream() {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<120; i++) myList.add(i);

        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));
    }

    private static void parallelStream() {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<120; i++) myList.add(i);

        Stream<Integer> parallelStream = myList.parallelStream();
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));
    }

    private static void interateOnStaticMethod() {
        List.of(1, 2, 3, 4, 5).forEach(StreamExample::staticMethod);
    }

    private static void interateOnInstanceMethod() {
        StreamExample instance = new StreamExample();
        List.of(1, 2, 3, 4, 5).forEach(instance::instanceMethod);
    }

    private static void staticMethod(Integer obj) {
        System.out.println("staticMethod(): " + obj);
    }

    private void instanceMethod(Integer obj) {
        System.out.println("instanceMethod(): " + obj);
    }
}

