package codechallenge.robotmovement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test of Tabletop class
 *
 * @author      Spenser Kao <SpenserKao@optusnet.com.au>
 * @version     0.1
 * @since       2017-10-20
 */
public class TabletopTest {
   
    Tabletop tabletop;
    
    @Test public void testConstructor () {
        tabletop = new Tabletop(5, 0, 5, 0);
        assertEquals(tabletop.getNorthBound(), 5);
        assertEquals(tabletop.getSouthBound(), 0);
        assertEquals(tabletop.getEastBound(), 5);
        assertEquals(tabletop.getWestBound(), 0);        
    }

    @Test public void testGetters() {
        tabletop = new Tabletop(4, 0, 4, 0);
        assertEquals(tabletop.getNorthBound(), 4);
        assertEquals(tabletop.getSouthBound(), 0);
        assertEquals(tabletop.getEastBound(), 4);
        assertEquals(tabletop.getWestBound(), 0);         
    }

    @Test public void testinBounds() {
        tabletop = new Tabletop(4, 0, 4, 0);        
        assertTrue(tabletop.inBounds(3, 3));
        assertTrue(tabletop.inBounds(0, 0));
        assertTrue(tabletop.inBounds(0, 4));
        assertTrue(tabletop.inBounds(4, 0));
        assertTrue(tabletop.inBounds(4, 4));        
    }
    
    @Test public void testOutside() {
        tabletop = new Tabletop(4, 0, 4, 0);        
        assertFalse(tabletop.inBounds(5, 4));
        assertFalse(tabletop.inBounds(4, 5));
        assertFalse(tabletop.inBounds(-2, 0));
        assertFalse(tabletop.inBounds(0, -2));     
    }    

    @Before
    public void setUp() {
        tabletop = new Tabletop(4, 0, 4, 0);
    }
    
    @After
    public void tearDown() {
        tabletop = null;
    }
}
