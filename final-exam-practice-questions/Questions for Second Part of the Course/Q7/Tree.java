import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nanwang
 *
 */
public class Tree {

	private String kind;

	private Dimension dimension;

	private String color;

	private List<String> types;

	public Tree() {
	}

	public String getKind() {
		return kind;
	}

	public Tree withKind(String kind) {
		this.kind = kind;
		return this;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Tree withDimension(Dimension dimension) {
		this.dimension = dimension;
		return this;
	}

	public String getColor() {
		return color;
	}

	public Tree withColor(String color) {
		this.color = color;
		return this;
	}

	public List<String> getTypes() {
		return types;
	}

	public Tree addType(String type) {
		if (this.types == null) {
			this.types = new ArrayList<>();
		}
		this.types.add(type);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Tree) {
			Tree tree = (Tree) o;
			if (!this.kind.equals(tree.kind)) {
				return false;
			}

			if ((this.dimension != null && !this.dimension.equals(tree.dimension))
					|| (tree.dimension != null && !tree.dimension.equals(this.dimension))) {
				return false;
			}

			if ((this.color != null && !this.color.equals(tree.color))
					|| (tree.color != null && !tree.color.equals(this.color))) {
				return false;
			}

			if ((this.types != null && !this.types.equals(tree.types))
					|| (tree.types != null && !tree.types.equals(this.types))) {
				return false;
			}
		}

		return true;
	}
}
