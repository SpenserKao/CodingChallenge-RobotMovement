package codingchallenge.robotmovement;

import junit.framework.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test of Robot class
 *
 * @author      Spenser Kao <SpenserKao@optusnet.com.au>
 * @version     0.1
 * @since       2017-10-20
 */
public class RobotTest {
    
    Robot robot;
    
    @Test 
	public void testConstructor() {
        assertEquals(robot.report(), "Report: 0, 0, NORTH");
    }
    
    @Test 
	public void testPlaceCommand() {
        robot.place(3, 3, Robot.Facing.SOUTH);
        assertEquals(robot.report(), "Report: 3, 3, SOUTH");
    }
    
    @Test 
	public void testRightCommand() {
        robot.rotateRight();
        assertEquals(robot.report(), "Report: 0, 0, EAST");
    }

    @Test 
	public void testRightsCommands() {
        robot.rotateRight();
        robot.rotateRight();
        assertEquals(robot.report(), "Report: 0, 0, SOUTH");
    }
    
    @Test 
	public void testLeftsCommands() {
        robot.rotateLeft();
        robot.rotateLeft();
        assertEquals(robot.report(), "Report: 0, 0, SOUTH");
    }
    
    @Test 
	public void testMoveCommand() {
        robot.move();
        assertEquals(robot.report(), "Report: 0, 1, NORTH");
    }

    @Before
    public void setUp() {
		robot = new Robot();
	}
    
    @After
    public void tearDown() {
        robot = null;
    }
}
