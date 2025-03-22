package net.will.javatest.basicconcept.jdk8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterBehavior {
    public String formatOfProlepticYear(LocalDate date) {
        return DateTimeFormatter.ofPattern("uuuu-MM-dd").format(date);
    }

    public String formatYearOfEra(LocalDate date) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
    }

    public String format3LettersInMonth(LocalDate date) {
        return DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH).format(date);
    }

    public String formatFullNameOfMonth(LocalDate date) {
        return DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH).format(date);
    }

    public String formatSingleMForMonth(LocalDate date) {
        return DateTimeFormatter.ofPattern("M d, yyyy", Locale.ENGLISH).format(date);
    }

    public String formatTwoMForMonth(LocalDate date) {
        return DateTimeFormatter.ofPattern("MM d, yyyy", Locale.ENGLISH).format(date);
    }

    public String formatThreeLsInMonth(LocalDate date) {
        // Refer to the Class documentation of java.text.SimpleDateFormat
        // L: standalone form
        // M: context-sensitive form
        return DateTimeFormatter.ofPattern("LLL d, yyyy", Locale.ENGLISH).format(date);
    }
}
