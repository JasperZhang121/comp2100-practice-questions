
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ParserTest {

	@Test(timeout = 1000)
	public void testLoad() {
		String text = "LOAD a;";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(1, commands.size());
		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof LoadCommand);

		LoadCommand lc = (LoadCommand) commands.get(0);

		assertEquals("a", lc.getKey());
	}
	
	@Test(timeout = 1000)
	public void testSave() {
		String text = "SAVE 500 TO a;";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(1, commands.size());
		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof SaveCommand);

		SaveCommand sac = (SaveCommand) commands.get(0);

		assertEquals("a", sac.getKey());
		assertEquals(500, sac.getValue());
	}

	@Test(timeout = 1000)
	public void testSum() {
		String text = "Sum vari* To ret;";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(1, commands.size());
		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof SumCommand);

		SumCommand suc = (SumCommand) commands.get(0);

		assertEquals("vari*", suc.getPattern());
		assertEquals("ret", suc.getKey());
	}

	@Test(timeout = 1000)
	public void testComplex() {
		String text = "save   10 to&^  variable!@#$%^&   ; Load variable  ; Sum vari* To ret ; ";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(3, commands.size());

		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof SaveCommand);

		SaveCommand sac = (SaveCommand) commands.get(0);

		assertEquals("variable", sac.getKey());
		assertEquals(10, sac.getValue());

		assertNotNull(commands.get(1));
		assertTrue(commands.get(1) instanceof LoadCommand);

		LoadCommand lc = (LoadCommand) commands.get(1);

		assertEquals("variable", lc.getKey());

		assertNotNull(commands.get(2));
		assertTrue(commands.get(2) instanceof SumCommand);

		SumCommand suc = (SumCommand) commands.get(2);
		assertEquals("vari*", suc.getPattern());
		assertEquals("ret", suc.getKey());
	}
}
