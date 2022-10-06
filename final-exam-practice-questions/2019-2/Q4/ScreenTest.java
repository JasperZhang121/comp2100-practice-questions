package parser;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You can use this to test your Screen implementation.
 * NOTE: When marking your submission, there can be more tests.
 * 
 * @author huy.pham
 */
public class ScreenTest {

	@Test
	public void testInitialScreenWithNorthAndPenUp() throws OutOfScreenException {
        Screen s = new Screen(
			11, 
			21, 
			new Pointer(
				new Position(5, 10), 
				Direction.NORTH,
				false
			)
		);
        
        assertEquals(
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"##########^##########\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n",
			s.trace()			
		);
	}
	
	@Test
	public void testScreenWithMarkedPositionAndInitialPenDownAndSouth() throws OutOfScreenException {
        Screen s = new Screen(
			11, 
			21, 
			new Pointer(
				new Position(5, 10), 
				Direction.SOUTH,
				true
			)
		);
        
        s.markVisistedPos(new Position(5, 5));
        s.markVisistedPos(new Position(10, 10));
        s.pointer.position.x = 4;
        s.pointer.position.y = 4;

        assertEquals(
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"####v################\n" +
			"#####.####.##########\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"#####################\n" +
			"##########.##########\n",
			s.trace()
		);
	}
}
