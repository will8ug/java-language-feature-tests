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

    public String identifyException(Exception exp) {
        return switch (exp) {
            case IllegalArgumentException _ -> "IllegalArgumentException";
            case IllegalStateException _ -> "IllegalStateException";
            case IndexOutOfBoundsException _ -> "IndexOutOfBoundsException";
            case NullPointerException _ -> "NullPointerException";
            default -> "Unknown Exception";
        };
    }
}
