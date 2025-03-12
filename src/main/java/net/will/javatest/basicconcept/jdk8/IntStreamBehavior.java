package net.will.javatest.basicconcept.jdk8;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreamBehavior {
    public int findFirstElementStartsWithDash(List<String> arguments) {
        return IntStream.range(0, arguments.size())
                .filter(it -> arguments.get(it).startsWith("-"))
                .findFirst()
                .orElse(-1);
    }
}
