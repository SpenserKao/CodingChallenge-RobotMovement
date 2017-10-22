package codingchallenge.robotmovement;

/**
 * The Tabletop class that encapsulates basic info boundaries.
 * 
 * @author      Spenser Kao <SpenserKao@optusnet.com.au>
 * @version     0.1
 * @since       2017-10-20
 */
public class Tabletop {
	
    private int northBound;
    private int southBound;
    private int eastBound;
    private int westBound;	

    public Tabletop (int northBound, int southBound, int eastBound, int westBound) {
            this.northBound = northBound;
            this.southBound = southBound;
            this.eastBound = eastBound;
            this.westBound = westBound;
    }

    protected int getNorthBound() {
            return this.northBound;
    }

    protected int getSouthBound() {
            return this.southBound;
    }	
	
    protected int getEastBound() {
            return this.eastBound;
    }		
	
    protected int getWestBound() {
            return this.westBound;
    }			  

    protected boolean inBounds (int x, int y) {       
        return ((x >= this.westBound) && 
                (x <= this.eastBound) && 
                (y >= this.southBound) && 
                (y <= this.northBound));
    }       
}
