public class Tokeniser {

	private String buffer;
	private Token currentToken;

	public Tokeniser(String text) {
		buffer = text;
		next();
	}

	public void next() {

		// ########## YOUR CODE STARTS HERE ##########

		// ########## YOUR CODE ENDS HERE ##########
	}

	public Token current() {
		return currentToken;
	}

	public boolean hasNext() {
		return currentToken != null;
	}

}