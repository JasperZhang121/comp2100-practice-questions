
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class ParserTest {

	@Test(timeout=1000)
	public void testLoad() {
		String text = "LOAD persons FROM persons.xml;";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(1, commands.size());
		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof LoadCommand);

		LoadCommand lc = (LoadCommand) commands.get(0);

		assertEquals("persons", lc.getKey());
		assertEquals("persons.xml", lc.getFileName());
	}

	@Test(timeout=1000)
	public void testSave() {
		String text = "save persons to persons.xml;";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(1, commands.size());
		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof SaveCommand);

		SaveCommand sac = (SaveCommand) commands.get(0);

		assertEquals("persons", sac.getKey());
		assertEquals("persons.xml", sac.getFileName());
	}

	@Test(timeout=1000)
	public void testComplex() {
		String text = "SAVE   persons   TO persons.xml   ;     LOAD persons  FROM  persons.xml;  ";
		Parser parser = new Parser(new Tokeniser(text));

		List<Command> commands = parser.parseCmds();

		assertEquals(2, commands.size());

		assertNotNull(commands.get(0));
		assertTrue(commands.get(0) instanceof SaveCommand);

		SaveCommand sac = (SaveCommand) commands.get(0);

		assertEquals("persons", sac.getKey());
		assertEquals("persons.xml", sac.getFileName());

		assertNotNull(commands.get(1));
		assertTrue(commands.get(1) instanceof LoadCommand);

		LoadCommand lc = (LoadCommand) commands.get(1);

		assertEquals("persons", lc.getKey());
		assertEquals("persons.xml", lc.getFileName());
	}
}
