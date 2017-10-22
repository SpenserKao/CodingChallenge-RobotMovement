package codingchallenge.robotmovement;

/**
 * The Position class that encapsulates x and y coordinates.
 * 
 * @author      Spenser Kao <SpenserKao@optusnet.com.au>
 * @version     0.1
 * @since       2017-10-20 
 */
public class Position {
	
    private int x;
    
    private int y; 

    Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }          

    protected void advanceX() {
        this.x++;
    }
 
    protected void advanceY() {
        this.y++;
    }

    protected void recedeX() {
        this.x--;
    }
    
    protected void recedeY() {
        this.y--;
    }
   
    protected void setX(int x) {
        this.x = x;
    }   

    protected void setY(int y) {
        this.y = y;
    }   
  
    protected int getX() {
        return this.x;
    }
   
    protected int getY() {
        return this.y;
    }    
}
