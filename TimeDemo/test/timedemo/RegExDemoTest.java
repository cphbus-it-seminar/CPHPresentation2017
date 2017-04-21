/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timedemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author kasper
 */
public class RegExDemoTest {

    public RegExDemoTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testSimpleAB() {
        String ptn = "a*b";
        assertTrue( Pattern.matches( ptn, "aaab" ) );
        assertFalse( Pattern.matches( ptn, "jens" ) );
    }

    @Test
    public void testLetterMatching() {
        String ptn = "-\\p{IsLatin}+-";
        assertTrue( Pattern.matches( ptn, "-aåêb-" ) );
        assertFalse( Pattern.matches( ptn, "-90-" ) );

    }

    @Test
    public void testLetterMatching2() {
        String ptn = "-\\w+-";
        assertFalse( Pattern.matches( ptn, "-aåêb-" ) );
    }

    @Test
    public void testDateMatch01() {
        String ptn = "\\d\\d[.]\\d\\d[.]\\d{4}";
        assertTrue( Pattern.matches( ptn, "21.04.2017" ) );
        assertFalse( Pattern.matches( ptn, "21-04-2017" ) );
    }

    @Test
    public void testDateMatch02() {
        String ptn = "\\d\\d[. -]\\d\\d[. -]\\d{4}";
        assertTrue( Pattern.matches( ptn, "21.04.2017" ) );
        assertTrue( Pattern.matches( ptn, "21-04-2017" ) );
        assertTrue( Pattern.matches( ptn, "21 04-2017" ) );
    }

    @Test
    public void testDateMatch03() {
        String ptn = "\\d\\d([. -])\\d\\d\\1\\d{4}";
        assertTrue( Pattern.matches( ptn, "21.04.2017" ) );
        assertTrue( Pattern.matches( ptn, "21-04-2017" ) );
        assertFalse( Pattern.matches( ptn, "21.04-2017" ) );
    }

    @Test
    public void testDateMatch04() {
        String ptn = "\\d\\d([ -])\\p{L}{3}\\1\\d{4}";
        assertTrue( Pattern.matches( ptn, "21-apr-2017" ) );
        assertTrue( Pattern.matches( ptn, "21 apr 2017" ) );
        assertFalse( Pattern.matches( ptn, "21-04-2017" ) );
        assertFalse( Pattern.matches( ptn, "21-june-2017" ) );
    }

    @Test
    public void testReplaceRegEx() {
        String ptn = "(\\d\\d)([. -])(\\d\\d)\\2(\\d{4})";
        String res = "joe 21-04-2017 jane".replaceAll( ptn, "$4-$3-$1" );
        assertEquals( "joe 2017-04-21 jane", res );
    }

    @Test
    public void testDateMatch05() {
        String ptn = "(\\d\\d)([. -])(\\d\\d)\\2(\\d{4})";
        Matcher matcher = Pattern.compile( ptn ).matcher( "21-04-2017" );
        if ( matcher.matches() ) {
            String date = matcher.group( 1 );
            String month = matcher.group( 3 );
            String year = matcher.group( 4 );
            assertEquals( "21", date );
            assertEquals( "04", month );
            assertEquals( "2017", year );
        } else {
            fail();
        }
    }

    @Test
    public void testMultiReplace() {
        String ptn = "(\\d\\d)([. -])(\\d+)\\2(\\d{4})";
        String input = "we have christmas at 24-12-2017, and midsommer at 22-6-2017.";
        String months[] = { "jan", "feb", "mar", "apr", "may", "jun",
            "jul", "aug", "sep", "oct", "nov", "dec" };

        Pattern p = Pattern.compile( ptn );

        // get a matcher object
        Matcher m = p.matcher( input );
        StringBuffer sb = new StringBuffer();
        while ( m.find() ) {
            String replace = "$1 " + months[ Integer.valueOf( m.group( 3 ) ) - 1 ] + ", $4";
            m.appendReplacement( sb, replace );
        }
        m.appendTail( sb );
        String res = sb.toString();
        String exp = "we have christmas at 24 dec, 2017, and midsommer at 22 jun, 2017.";
        assertEquals( exp, res );
    }
}
