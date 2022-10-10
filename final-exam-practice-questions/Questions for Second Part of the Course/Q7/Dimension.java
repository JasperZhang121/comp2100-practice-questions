/**
 * 
 * @author nanwang
 *
 */
public class Dimension {

	private final Integer diameter;

	private final Integer height;

	public Dimension(Integer diameter, Integer height) {
		this.diameter = diameter;
		this.height = height;
	}

	public Integer getDiameter() {
		return diameter;
	}

	public Integer getHeight() {
		return height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Dimension) {
			Dimension dimension = (Dimension) o;
			return this.diameter.equals(dimension.diameter) && this.height.equals(dimension.height);
		}

		return false;
	}
}
