package parser;

/**
 * This class represents the pointer.
 * 
 * @author huy.pham
 */
public class Pointer {
	public Position position;
	public Direction direction;
	public boolean isPenDown;
	
	public Pointer(Position position, Direction direction, boolean isPenDown) {
		this.position = position;
		this.direction = direction;
		this.isPenDown = isPenDown;
	}
	
	/**
	 * Turn the pointer to its left
	 * @return this pointer
	 */
	public Pointer turnLeft() {
    	switch(direction) {
    		case NORTH:
    			direction = Direction.WEST;
    			break;
    		case WEST:
    			direction = Direction.SOUTH;
    			break;
    		case SOUTH:
    			direction = Direction.EAST;
    			break;    		
    		case EAST:
    			direction = Direction.NORTH;
    			break;    	    			
    	}
    	
    	return this;
	}
	
	/**
	 * Turn the pointer to its right
	 * @return this pointer
	 */
	public Pointer turnRight() {
    	switch(direction) {
			case NORTH:
				direction = Direction.EAST;
				break;
			case EAST:
				direction = Direction.SOUTH;
				break;
			case SOUTH:
				direction = Direction.WEST;
				break;    		
			case WEST:
				direction = Direction.NORTH;
				break;    	    			
		}
		
		return this;
	}
}
