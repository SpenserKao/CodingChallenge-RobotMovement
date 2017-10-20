package codechallenge.robotmovement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * The Robot class that encapsulates the characteristics of a Robot instance.
 * 
 * @author      Spenser Kao <SpenserKao@optusnet.com.au>
 * @version     0.1
 * @since       2017-10-20 
 */
public class Robot {
	
    public static final String PROPERTIES_FILE = "ioof_robot.properties"; 
    public enum Facing { 
        NORTH, EAST, WEST, SOUTH 
    }	 
    private Facing face;   
    private Position pos;
    private Tabletop table;

    
    public Robot () {
        this.pos = new Position(0, 0);          
        this.face = Facing.NORTH;
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream (PROPERTIES_FILE));	
            this.table = new Tabletop(
                    Integer.parseInt(prop.getProperty("TABLE_NORTH_BOUND")),
                    Integer.parseInt(prop.getProperty("TABLE_SOUTH_BOUND")),
                    Integer.parseInt(prop.getProperty("TABLE_EAST_BOUND")),
                    Integer.parseInt(prop.getProperty("TABLE_WEST_BOUND"))				
            );
        } catch (IOException | NumberFormatException e) {
            System.out.println("Either the properties file named ioof_robot.properties is missing,\n"
                            + "or the four-boundary data there is incomplete,\n"
                            + "we are defaulting the (north, south, east, west) boundaries as (4, 0, 4, 0).\n");
            this.table = new Tabletop(4, 0, 4, 0);		
        } 
    } 
  
    protected void setFace(Facing f) {
        this.face = f;
    }
   
    protected void place (int x, int y, Facing f) {
        // precondition check
        if (table.inBounds(x, y)) { 
            this.pos.setPos(x, y);
            this.face = f;           
        }      
    } 
     
    protected void move () {
        // move as instructed
        switch (face) {
            case NORTH:
                if ( this.pos.getY() < table.getNorthBound() ) {
                    this.pos.advanceY();
                }
                break;
            case SOUTH:
                if ( this.pos.getY() > table.getSouthBound() ) {
                    this.pos.recedeY();
                }
                break;     
            case EAST:
                if (this.pos.getX() < table.getEastBound() ) {
                    this.pos.advanceX();
                }
                break;                         
            case WEST:
                if ( this.pos.getX() > table.getWestBound() ) {
                    this.pos.recedeX();
                }
                break;          
        }
    }
    
    protected void rotateLeft () {
        switch (this.face) {
            case NORTH:
                this.face = Facing.WEST;
                break;                 
            case SOUTH:
                this.face = Facing.EAST;
                break;                      
            case EAST:
                this.face = Facing.NORTH;
                break;
            case WEST:
                this.face = Facing.SOUTH;
                break;                  
        }
    }
  
    protected void rotateRight () {
        switch (this.face) {
            case NORTH:
                this.face = Facing.EAST;
                break;                 
            case SOUTH:
                this.face = Facing.WEST;
                break;                      
            case EAST:
                this.face = Facing.SOUTH;
                break;
            case WEST:
                this.face = Facing.NORTH;
                break;                  
        }            
    }
 
    protected String report () {
        return "Report: " + this.pos.getX() + ", " + this.pos.getY() + ", " + this.face;
    }
        
    protected void command (String line) throws Exception {
        StringTokenizer st = new StringTokenizer(line, " ");
        String command = st.nextToken();       
        switch (command) {
            case "PLACE":
                try {
                    int placeX = Integer.parseInt(st.nextToken(",").trim());
                    int placeY = Integer.parseInt(st.nextToken(",").trim());
                    Facing direction =  mapFactingStringToEnum(st.nextToken(",").trim());
                    this.place(placeX, placeY, direction);
                } catch (Exception e) {
                    throw e;
                }                   
                break;
            case "MOVE":
                this.move();
                break;
            case "LEFT":
                this.rotateLeft();
                break;
            case "RIGHT":
                this.rotateRight();
                break; 
            case "REPORT":
                System.out.println(this.report());
                break;      
            default:
                throw new Exception("Error: Unrecognisable command " + "'" + command + "'"); 
        }  

    }

    protected Facing mapFactingStringToEnum (String facing) throws Exception {
        switch (facing) {
            case "NORTH":
                return Facing.NORTH;
            case "SOUTH":
                return Facing.SOUTH;
            case "WEST":
                return Facing.WEST;
            case "EAST":
                return Facing.EAST;   
            default:
                throw new Exception("Error: Unrecognisable facing (direction) input info " + "'" + facing + "'");                
        }
    }
    
    /** 
     * The Main method to execute the Robot instance.
     * 
     * @param args args[0] should be the file containing robot movement instructions.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
           System.out.println("Usage: Java -jar <jar file> <Command File>\n" +  
           "  e.g. java -jar build/libs/CodingChallenge_Robot.jar robot_movement.txt");
           return;
        }
	           
        Robot robot = new Robot();
        
        try {
            InputStream is = new FileInputStream(new File(args[0]));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.trim().length()==0) {
                    continue;
                }
                robot.command(line);
            }       
            is.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }        
}