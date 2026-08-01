package com.tutorials.language.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java.time (Java 8+) types are immutable and clearly split into "a point on
 * the human calendar" (LocalDate) vs "an instant in machine time" (Instant),
 * with Period/Duration as their matching amount-of-time counterparts —
 * Period for calendar fields (years/months/days), Duration for exact seconds.
 */
public class DateTimeShowcase {
    public static Period ageAsOf(LocalDate birthDate, LocalDate today) {
        return Period.between(birthDate, today);
    }

    public static Duration elapsed(Instant start, Instant end) {
        return Duration.between(start, end);
    }

    public static String formatIso(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    // A ZonedDateTime carries its own zone; converting to another zone keeps
    // the same instant but recomputes the local wall-clock fields.
    public static ZonedDateTime convertZone(ZonedDateTime source, ZoneId targetZone) {
        return source.withZoneSameInstant(targetZone);
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
