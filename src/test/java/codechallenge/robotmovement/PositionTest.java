package codechallenge.robotmovement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test of Position class
 *
 * @author      Spenser Kao <SpenserKao@optusnet.com.au>
 * @version     0.1
 * @since       2017-10-20
 */
public class PositionTest {
    
    Position pos;
    
    @Test
    public void testPositionConstructor() {
        pos = new Position(3,4);
        assertEquals(pos.getX(), 3);
        assertEquals(pos.getY(), 4);
    }

    @Test
    public void testSetpos() {
        pos.setPos(2,3);
        assertEquals(pos.getX(), 2);
        assertEquals(pos.getY(), 3);
    }

    @Test
    public void testGetters() {
        assertEquals(pos.getX(), 2);
        assertEquals(pos.getY(), 3);
    }

    @Test
    public void testSetters() {
        pos.setX(5);
        pos.setY(1);
        assertEquals(pos.getX(), 5);
        assertEquals(pos.getY(), 1);
    }

    @Test
    public void testAdvanceX() {
        pos.advanceX();
        assertEquals(pos.getX(), 3);
        assertEquals(pos.getY(), 3);
    }

    @Test
    public void testAdvanceY() {
        pos.advanceY();
        assertEquals(pos.getX(), 2);
        assertEquals(pos.getY(), 4);
    }
 
    @Test
    public void testRecedeX() {
        pos.recedeX();
        assertEquals(pos.getX(), 1);
        assertEquals(pos.getY(), 3);
    }

    @Test
    public void testRecedeY() {
        pos.recedeY();
        assertEquals(pos.getX(), 2);
        assertEquals(pos.getY(), 2);
    }
    
    @Before
    public void setUp() {
        pos = new Position(2,3);
    }
    
    @After
    public void tearDown() {
        pos = null;
    }    
}
