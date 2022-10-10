import java.io.File;
import java.util.List;

/**
 *
 * @author nanwang
 *
 The goal of this task it to write a program that loads/stores a list of trees in XML format. `TreeCollection.java` class contains a
 list of `Tree` instances. Each tree has its own `kind`, which needs to be saved as an attribute of XML node. Additionally, each tree
 can have three possible properties: `dimension`, `color` and `types`. `dimension` property has two integer attributes: `diameter` and
 `height`. `types` property has a list of `type` elements. Note that not every tree has all three properties. Some properties of trees
 may be missing (for example, see the test cases in TreesTest.java). You job is to implement the below methods in `TreeCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given tree. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `TreeCollection.java` file to wattle!**
 *
 */
public class TreeCollection {

	private final List<Tree> trees;

	public TreeCollection(List<Tree> trees) {
		this.trees = trees;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	/**
	 * Implement this method to save the list of trees to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `kind`, `diameter` and `height` properties
	 * @param file
	 */
	public void saveToFile(File file) {
		//START YOUT CODE
		
		
		//END YOUT CODE
	}

	/**
	 * Implement this method to load from the XML file to create a `TreeCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `kind`, `diameter` and `height` properties
	 * @param file
	 * @return
	 */
	public static TreeCollection loadFromFile(File file) {
		//START YOUT CODE
		
		
		//END YOUT CODE	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof TreeCollection) {
			TreeCollection treeCollection = (TreeCollection) o;
			return this.trees.equals(treeCollection.trees);
		}

		return false;
	}
}
