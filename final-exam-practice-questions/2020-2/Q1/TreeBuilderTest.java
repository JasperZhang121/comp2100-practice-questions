
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreeBuilderTest {

    @Test(timeout = 1000)
    public void testBuildUpperCase() {
        String text = "i Am the KING of THE 10 castle. The castle is my HOME.";
        TreeBuilder builder = new TreeBuilder();
        RBTree<Integer, List<String>> tree = builder.build(text);
        assertEquals(2, tree.getData(4).size());
        assertEquals(1, tree.getData(3).size());

        assertTrue(tree.getData(4).contains("KING") && tree.getData(4).contains("HOME"));
        assertTrue(tree.getData(3).contains("THE"));
    }

}
