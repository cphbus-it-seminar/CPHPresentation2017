/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedemo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRulesProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**

 @author kasper
 */
public class TimeDemo {

    public static void main( String[] args ) {
        //timeZoneNamesForEurope();
        theWinterCame();
        //javaChronologies();

        //performanceMeasure( );
        //performanceMeasureNano( );
        //performanceMeasureDubious();
    }

    public static void performanceMeasureDubious() {
        long start = System.nanoTime();
        long end = System.nanoTime();
        System.out.println(
                "Nanos: " + ( end - start ) );
    }

    public static void performanceMeasure() {
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
    }

    public static void performanceMeasureNano() {
        long n = 10_000_000_000L;
        long l = 0;
        long start = System.nanoTime();
        for ( long i = 0; i < n; i++ ) {
            l++;
        }
        long end = System.nanoTime();
        System.out.println(
                "Nanos: " + ( end - start )
                + " Secs: " + ( ( end - start ) / 1000000000.0 )
                + " Count: " + l);
    }

    public static void javaChronologies() {
        Set<Chronology> chronos = Chronology.getAvailableChronologies();
        for ( Chronology chrono : chronos ) {
            ChronoLocalDate date = chrono.dateNow();
            System.out.printf( "   %20s: %s\n", chrono.getId(), date.toString() );
        }
    }

    public static void theWinterCame() {

        LocalDateTime ldt = LocalDateTime.of( 2017, 10, 29, 2, 30 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt = ZonedDateTime.of( ldt, z );
        System.out.println( "Time1: " + zdt );
        ZonedDateTime zdt2 = ZonedDateTime.of( ldt, z ).plusHours( 1 );
        System.out.println( "Time2: " + zdt2 );
    }

    public static void timeZoneNamesForEurope() {
        List<String> zones = new ArrayList( ZoneRulesProvider.getAvailableZoneIds() );
        Collections.sort( zones );
        for ( String zone : zones ) {
            if ( zone.startsWith( "Europe" ) ) {
                System.out.println( zone );
            }
        }
    }

}
