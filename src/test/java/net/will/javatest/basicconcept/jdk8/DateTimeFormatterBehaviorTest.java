package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeFormatterBehaviorTest {
    @Test
    public void testFormatProlepticYear_currentEra() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatOfProlepticYear(LocalDate.of(2025, 1, 1));

        assertEquals("2025-01-01", formatted);
    }

    @Test
    public void testFormatProlepticYear_currentEra_lastCentury() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatOfProlepticYear(LocalDate.of(1900, 1, 1));

        assertEquals("1900-01-01", formatted);
    }

    @Test
    public void testFormatProlepticYear_beforeCurrentEra() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatOfProlepticYear(LocalDate.of(-1, 1, 1));

        assertEquals("-0001-01-01", formatted);
    }

    @Test
    public void testFormatYearOfEra_currentEra() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatYearOfEra(LocalDate.of(2025, 1, 1));

        assertEquals("2025-01-01", formatted);
    }

    @Test
    public void testFormatYearOfEra_currentEra_lastCentury() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatYearOfEra(LocalDate.of(1900, 1, 1));

        assertEquals("1900-01-01", formatted);
    }

    @Test
    public void testFormatYearOfEra_beforeCurrentEra() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatYearOfEra(LocalDate.of(-1, 1, 1));

        assertEquals("0002-01-01", formatted);
    }

    @Test
    public void testFormat3LettersInMonth() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.format3LettersInMonth(LocalDate.of(2025, 1, 1));

        assertEquals("Jan 1, 2025", formatted);
    }

    @Test
    public void testFormat3LettersInMonth_twoDigitsInDays() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.format3LettersInMonth(LocalDate.of(2025, 1, 10));

        assertEquals("Jan 10, 2025", formatted);
    }

    @Test
    public void testFormatFullNameOfMonth() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatFullNameOfMonth(LocalDate.of(2025, 1, 1));

        assertEquals("January 1, 2025", formatted);
    }

    @Test
    public void testFormatSingleMForMonth() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatSingleMForMonth(LocalDate.of(2025, 1, 1));

        assertEquals("1 1, 2025", formatted);
    }

    @Test
    public void testFormatTwoMForMonth() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatTwoMForMonth(LocalDate.of(2025, 1, 1));

        assertEquals("01 1, 2025", formatted);
    }

    @Test
    public void testFormatThreeLsInMonth() {
        DateTimeFormatterBehavior formatterBehavior = new DateTimeFormatterBehavior();
        String formatted = formatterBehavior.formatThreeLsInMonth(LocalDate.of(2025, 1, 1));

        assertEquals("Jan 1, 2025", formatted);
    }
}
