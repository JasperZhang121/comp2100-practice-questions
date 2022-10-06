package parser;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You can use this to test your Parser implementation.
 * NOTE: When marking your submission, there can be more tests.
 * 
 * @author huy.pham 
 * @author dongwoo
 */
public class ParserTest {
	private void _checkScreen(Screen screen, Position[] visitedPositions) {
		for (Position p : visitedPositions) {
	        assertEquals("it should mark visisted at position: (" + p.x + ", " + p.y + ")", Screen.VISITED_MARK, screen.trace[p.x][p.y]); 
		}
		
		for (int i = 0; i < screen.noOfRows; i++) {
			for (int j = 0; j < screen.noOfColumns; j++) {
				boolean shouldBeUnvisited = true;
				for (Position p : visitedPositions) {
					if (p.x == i && p.y == j) {
						shouldBeUnvisited = false;
						break;
					}
				}
				
				if (shouldBeUnvisited) {
			        assertEquals("it should mark un-visisted at position: (" + i + ", " + j + ")", Screen.NON_VISITED_MARK, screen.trace[i][j]); 
				}
			}
		}	
	}
	
	@Test
	public void testParserWithExampleGivenInExamPaper() throws OutOfScreenException {
        String command = "PENUP; LEFT; FORWARD(10); PENDOWN; RIGHT; BACK(3);";
        
        // The construction defines the screen size and initial direction and position of pointer.
        Parser parser = new Parser(
			new Tokenizer(command), 
			new Screen(
				11, 
				21, 
				new Pointer(
					new Position(5, 10), 
					Direction.NORTH,
					false
				)
			)
        );
        
        Screen screen = parser.parse();
        /**
         * The screen should now be:
			#####################
			#####################
			#####################
			#####################
			#####################
			.####################
			.####################
			.####################
			^####################
			#####################
			#####################
         */
        Position[] expectedVisitedPositions = {
		  new Position(5, 0), 
		  new Position(6, 0), 
		  new Position(7, 0), 
		  new Position(8, 0)
		};
        
        assertEquals("it should not mark the initial position since pen is up", Screen.NON_VISITED_MARK, screen.trace[5][10]); 
        _checkScreen(screen, expectedVisitedPositions);
        assertEquals("it should update last pointer position x", 8, screen.pointer.position.x);
        assertEquals("it should update last pointer position y", 0, screen.pointer.position.y);
        assertEquals( "it should turn pointer", Direction.NORTH, screen.pointer.direction);
	}
	
	@Test
	public void testParserWithLotsOfRotation() throws OutOfScreenException {
        String command = "LEFT; FORWARD(5); PENUP; RIGHT; FORWARD(2); PENDOWN; PENUP; FORWARD(3); PENDOWN; RIGHT; FORWARD(5); LEFT; RIGHT; RIGHT; LEFT;";
        Parser parser = new Parser(
			new Tokenizer(command), 
			new Screen(
				6, 
				10, 
				new Pointer(
					new Position(5, 5), 
					Direction.NORTH,
					true
				)
			)
        );
        
        Screen screen = parser.parse();
        /**
         * The screen should now be:
          	.....>#### 
			########## 
			########## 
			.######### 
			########## 
			......####
         */
        Position[] expectedVisitedPositions = {
		  new Position(3, 0), 
		  new Position(0, 0), 
		  new Position(0, 1), 
		  new Position(0, 2), 
		  new Position(0, 3), 
		  new Position(0, 4), 
		  new Position(0, 5), 
		  new Position(5, 0), 
		  new Position(5, 1), 
		  new Position(5, 2), 
		  new Position(5, 3), 
		  new Position(5, 4), 
		  new Position(5, 5), 
		};
        
        _checkScreen(screen, expectedVisitedPositions);
        assertEquals("it should update last pointer position x", 0, screen.pointer.position.x);
        assertEquals("it should update last pointer position y", 5, screen.pointer.position.y);
        assertEquals( "it should turn pointer", Direction.EAST, screen.pointer.direction);
	}
	
	@Test
	public void testParserWithFORWARD() throws OutOfScreenException {
        String command = "RIGHT; FORWARD(1); PENDOWN; FORWARD_TO_END; FORWARD_TO_END; PENUP; LEFT; FORWARD_TO_END; PENDOWN; FORWARD_TO_END; PENUP; LEFT; FORWARD_TO_END; PENDOWN; FORWARD_TO_END; PENUP; LEFT; FORWARD_TO_END; PENDOWN; FORWARD_TO_END;";
        
        // The construction defines the screen size and initial direction and position of pointer.
        Parser parser = new Parser(
			new Tokenizer(command), 
			new Screen(
				6, 
				10, 
				new Pointer(
					new Position(5, 5), 
					Direction.NORTH,
					false
				)
			)
        );
        
        Screen screen = parser.parse();
        /**
         * The screen should now be:
          	.########. 
			########## 
			########## 
			########## 
			########## 
			v#####....
         */
        Position[] expectedVisitedPositions = {
		  new Position(5, 6),
		  new Position(5, 7),
		  new Position(5, 8),
		  new Position(5, 9),
		  new Position(0, 9),
		  new Position(0, 0),
		  new Position(5, 0)
		};
        
        _checkScreen(screen, expectedVisitedPositions);
        assertEquals("it should update last pointer position x", 5, screen.pointer.position.x);
        assertEquals("it should update last pointer position y", 0, screen.pointer.position.y);
        assertEquals( "it should turn pointer", Direction.SOUTH, screen.pointer.direction);
	}
}
