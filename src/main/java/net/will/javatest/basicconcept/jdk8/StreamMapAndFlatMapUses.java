package net.will.javatest.basicconcept.jdk8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapAndFlatMapUses {
    public List<String> map() {
        return Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<String> flatMapOnNestedList() {
        List<List<String>> nestedList = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
        return nestedList.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
