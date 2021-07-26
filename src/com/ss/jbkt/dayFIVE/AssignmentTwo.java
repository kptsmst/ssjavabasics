package com.ss.jbkt.dayFIVE;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


public class AssignmentTwo {
    public static void main(String[] args) {
        //assignment two demo calls
        dateTimeQuestions();
        reportLengthOfEachMonthInYear(Year.of(2020));
        listMondaysOfMonth(Month.JULY);
        fThirteenDemo();
    }

    private static void dateTimeQuestions() {
        //birthday storage
        LocalDateTime aBirthdayToTheNanosecond = LocalDateTime.of(2000, 11, 15, 14, 16, 16, 433);
        System.out.print("A birthday to the nanosecond: ");
        System.out.println(aBirthdayToTheNanosecond);
        
        //go to last Thursday

        DayOfWeek dayOfWeek = aBirthdayToTheNanosecond.getDayOfWeek();
        System.out.print("Day of the week: ");
        System.out.println(dayOfWeek);

        // has been abstracted to getLastThursday
        // int daysToSubtract = aBirthdayToTheNanosecond.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue();
        // if (daysToSubtract <= 0) daysToSubtract = 7 + daysToSubtract;
        // System.out.print("Days to go back to last thursday: ");
        // System.out.println(daysToSubtract);

        LocalDate lastThursday = getLastThursday(aBirthdayToTheNanosecond.toLocalDate());
        System.out.print("Last Thursday: ");
        System.out.println(lastThursday);
        System.out.print("Was on day of the week: ");
        System.out.println(lastThursday.getDayOfWeek());

        System.out.print("Using temporal adjuster: ");
        System.out.println(aBirthdayToTheNanosecond.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
        

        //back and forth conversion between ZoneDateTime and Instant
        ZonedDateTime zoneDateTime = ZonedDateTime.now();
        Instant universalNow = Instant.ofEpochSecond(zoneDateTime.toEpochSecond());
        ZonedDateTime convertedBack = ZonedDateTime.ofInstant(universalNow, zoneDateTime.getZone());
    }

    public static LocalDate getLastThursday (LocalDate currentDate) {
        int daysToSubtract = currentDate.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue();
        if (daysToSubtract <= 0) daysToSubtract = 7 + daysToSubtract;
        LocalDate lastThursday = currentDate.minusDays(daysToSubtract);
        return lastThursday;

    }

    public static void reportLengthOfEachMonthInYear (Year year) {
        for (int i = 1; i <= 12; i++) {
            YearMonth yearMonth = year.atMonth(i);
            int length = yearMonth.lengthOfMonth();
            System.out.printf("%s of %s has %d days.\n", yearMonth.getMonth().toString(), year.toString(), length);
        }
    }

    public static void listMondaysOfMonth (Month monthOfCurrentYear) {
        YearMonth yearMonth = YearMonth.of(LocalDate.now().getYear(), monthOfCurrentYear);
        for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
            if (yearMonth.atDay(i).getDayOfWeek() == DayOfWeek.MONDAY) {
                System.out.print("Monday Found: ");
                System.out.println(yearMonth.atDay(i));
            }
        }
    }

    public static void fThirteenDemo () {
        LocalDate today = LocalDate.now();
        boolean checkToday = isDateFridayTheThirteenth(today);
        System.out.print("Today is friday the thirteenth: ");
        System.out.println(checkToday);

        LocalDate janFirst = LocalDate.of(2021, 1, 1);
        boolean shouldBeFalse = isDateFridayTheThirteenth(janFirst);
        System.out.print("Jan 1st was friday the thirteenth: ");
        System.out.println(shouldBeFalse);

        LocalDate fThirteenth = LocalDate.of(2021, 8, 13);
        boolean shouldBeTrue = isDateFridayTheThirteenth(fThirteenth);
        System.out.print("August 13th will be friday the thirteenth: ");
        System.out.println(shouldBeTrue);
    }

    public static boolean isDateFridayTheThirteenth (LocalDate date) {
        if (date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY ) {
            return true;
        }

        return false;

    }

}

/* 
    • Date-Time API

    1.  Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
            LocalDateTime stores times to the nanosecond;
    2.  Given a random date, how would you find the date of the previous Thursday?
            Write some simple algorithm based on DayOfWeek enum, or better, adjust the date with a temportal adjuster .with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
    3.  What is the difference between a ZoneId and a ZoneOffset?
            A ZoneID is an ID mapped to the rules for a ZoneOffset (like America/Vancouver), the ZoneOffset is the offset from GMT/UTC (like UTC-07:00)
    4.  How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
            Converting a zonedDateTime to an instant can be done by creating an Instant from the epochSecond of the ZonedDateTime
            Converting an instant to a ZoneDateTime can be done from creating a ZoneDateTime of the Instant and a ZoneID 
    5.  Write an example that, for a given year, reports the length of each month within that year.

    6.  Write an example that, for a given month of the current year, lists all of the Mondays in that month.

    7.  Write an example that tests whether a given date occurs on Friday the 13th.
*/