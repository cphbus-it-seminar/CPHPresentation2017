# Date and time in Java

Dates and times in the Java libraries have a bad history. The libraries were not able to solve all the problems one have in dealing with time. 
In response to this, an alternative date and time library was developed - named [Joda Time](http://www.joda.org/joda-time/)

In Java 8 (2014), they had had a good look at Joda, and got it right.

There is a good intro to this in [DZone from Feb. 27, 2014](https://dzone.com/articles/deeper-look-java-8-date-and)

## Local Date, Local Time, LocalDateTime
* Represent dates with year, month, and day
* Takes care of leap year
* Compute length of year, month, back and forth in time, day of year,...

```java
// the current date
LocalDate currentDate = LocalDate.now();
// 2014-02-10
LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
// months values start at 1 (2014-08-01)
LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
// the 65th day of 2010 (2010-03-06)
LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
```

## Working with UTC - Instant
An Instant counts the time beginning from the first second of January 1, 1970 (1970-01-01 00:00:00) also called the EPOCH.
Besides the number of seconds since 1970, Instant also has a nano-second counter.

```java
long n = 10_000_000_000L;
long l = 0;
Instant start = Instant.now();
for ( long i = 0; i < n; i++ ) {
	l++;
}
Instant end = Instant.now();
System.out.println( 
	"Nanos: " + ChronoUnit.NANOS.between( start, end )
   + " Secs: " + ChronoUnit.MILLIS.between( start, end ) / 1000.0
   + " Counted to: " + l );
```

### Real performance measurement
You have to use ```System.nanoTime()``` to get better precision in the measurements. System.nanoTime() gives the result from an internal counter - not related to real world time.

```java
long start = System.nanoTime();
long end = System.nanoTime();
System.out.println("Nanos: " + ( end - start ) );
```

## Time Zones & Daylights savings time
Time zones know about how they are related to UTC. 
```java
ZoneId zurich = ZoneId.of("Europe/Zurich");
// 2014-02-20 12:00
LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);
// 2014-02-20 12:00, Europe/Berlin (+01:00)
ZonedDateTime zurichDateTime = ZonedDateTime.of(dateTime, zurich);
```

They know about the daylightsavings dates.

```java
LocalDateTime ldt = LocalDateTime.of( 2017, 10, 29, 2, 30 );
ZoneId z = ZoneId.of( "Europe/Zurich" );
ZonedDateTime zdt = ZonedDateTime.of( ldt, z );
System.out.println( "Time1: " + zdt );
ZonedDateTime zdt2 = ZonedDateTime.of( ldt, z ).plusHours( 1 );
System.out.println( "Time2: " + zdt2 );
```

which prints:

```
Time1: 2017-10-29T02:30+02:00[Europe/Zurich]
Time2: 2017-10-29T02:30+01:00[Europe/Zurich]
```

 
