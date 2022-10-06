/**
 * This class is mainly used for the makefile exercise.
 * @author huy.pham
 */
public class Demo {
	public static void main(String[] args) throws OutOfScreenException {
		Screen screen = new Screen(
				11,
				21,
				new Pointer(
						new Position(5, 10),
						Direction.Upward,
						false
				)
		);

		System.out.println("Initial screen");
		System.out.println(screen.trace());

		String command = "PENUP; LEFT; FORWARD(10); PENDOWN; RIGHT; BACK(5);";
		System.out.println(command);
		Parser parser = new Parser(new Tokenizer(command), screen);

		Screen s = parser.parse();
		if (s == null) {
			System.out.println("-- TODO: Parser and/or Tokenizer is not yet implemented!");
		} else {
			String trace = s.trace();
			if (trace.isEmpty()) {
				System.out.println("-- TODO: Screen trace() is not yet implemented!");
			} else {
				System.out.println(trace);
			}
		}
	}
}
