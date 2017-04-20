/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedemo;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.zone.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author kasper
 */
public class JavaTimeTests {

    public JavaTimeTests() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void LocalDate01() {
        LocalDate ld = LocalDate.of( 2017, 04, 21 );
        assertEquals( 2017, ld.getYear() );
    }

    @Test
    public void DaylightSavings01() {
        LocalDateTime ldt = LocalDateTime.of( 2017, 3, 26, 2, 30 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt = ZonedDateTime.of( ldt, z );
        ZoneRules zoneRules = z.getRules();
        Boolean isDst = zoneRules.isDaylightSavings( zdt.toInstant() );
        assertTrue( isDst );
    }

    @Test
    public void DaylightSavings02() {
        LocalDateTime ldt = LocalDateTime.of( 2017, 3, 25, 2, 30 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt = ZonedDateTime.of( ldt, z );
        ZoneRules zoneRules = z.getRules();
        Boolean isDst = zoneRules.isDaylightSavings( zdt.toInstant() );
        assertFalse( isDst );
    }

    @Test
    public void DaylightSavings03() {
        LocalDateTime ldt = LocalDateTime.of( 2017, 10, 29, 2, 30 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt = ZonedDateTime.of( ldt, z );
        ZoneRules zoneRules = z.getRules();
        Boolean isDst = zoneRules.isDaylightSavings( zdt.toInstant() );
        assertTrue( isDst );
    }

    @Test
    public void DaylightSavings04() {
        LocalDateTime ldt = LocalDateTime.of( 2017, 10, 29, 3, 30 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt = ZonedDateTime.of( ldt, z );
        ZoneRules zoneRules = z.getRules();
        Boolean isDst = zoneRules.isDaylightSavings( zdt.toInstant() );
        assertFalse( isDst );
    }
    
    
    @Test
    public void CoutingTheHours01() {
        LocalDateTime ldt1 = LocalDateTime.of( 2017, 10, 27, 12, 00 );
        LocalDateTime ldt2 = LocalDateTime.of( 2017, 10, 28, 12, 00 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt1 = ZonedDateTime.of( ldt1, z );
        ZonedDateTime zdt2 = ZonedDateTime.of( ldt2, z );
        long diff = ChronoUnit.HOURS.between( zdt1, zdt2);
        assertEquals( 24, diff );
    }
    
    @Test
    public void CoutingTheHours02() {
        LocalDateTime ldt1 = LocalDateTime.of( 2017, 10, 28, 12, 00 );
        LocalDateTime ldt2 = LocalDateTime.of( 2017, 10, 29, 12, 00 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt1 = ZonedDateTime.of( ldt1, z );
        ZonedDateTime zdt2 = ZonedDateTime.of( ldt2, z );
        long diff = ChronoUnit.HOURS.between( zdt1, zdt2);
        assertEquals( 25, diff );
    }
    
    @Test
    public void CoutingTheHours03() {
        LocalDateTime ldt1 = LocalDateTime.of( 2017, 3, 25, 12, 00 );
        LocalDateTime ldt2 = LocalDateTime.of( 2017, 3, 26, 12, 00 );
        ZoneId z = ZoneId.of( "Europe/Zurich" );
        ZonedDateTime zdt1 = ZonedDateTime.of( ldt1, z );
        ZonedDateTime zdt2 = ZonedDateTime.of( ldt2, z );
        long diff = ChronoUnit.HOURS.between( zdt1, zdt2);
        assertEquals( 23, diff );
    }

}
