package net.will.javatest.basicconcept.jdk21;

public class SwitchCaseSyntax {
    public String identifyNumber(Integer num) {
        String result;
        switch (num) {
            case Integer n when n < 0 -> result = "negative";
            case Integer n when n == 0 -> result = "zero";
            default -> result = "positive";
        }

        if (result.equals("zero")) {
            result = "non-negative";
        }
        return result;
    }
}
