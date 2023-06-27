package com.features.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy");

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime " + dateTime);

        LocalDate date = LocalDate.now();
        System.out.println("date " + date);

        String ddmmyyyy = date.format(formatter);
        System.out.println(ddmmyyyy);

        LocalDate parse = LocalDate.parse(ddmmyyyy, formatter);
        System.out.println(parse);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime " + zonedDateTime);

        DateTimeFormatter dMmYyyyAZ = DateTimeFormatter.ofPattern("d MMM YYYY a z");
        System.out.println(zonedDateTime.format(dMmYyyyAZ));

        Instant instant = Instant.now();
        System.out.println("instant " +instant);
    }
}
