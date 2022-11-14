public class Tokeniser {

	private String buffer; // save text
	private Token currentToken; // save token extracted from next()

	public Tokeniser(String text) {
		buffer = text; // save input text (string)
		next(); // extracts the first token.
	}

	/**
	 * This function will find and extract a next token from {@code buffer} and save
	 * the token to {@code currentToken}.
	 */
	public void next() {

		buffer = buffer.trim(); // remove whitespace
		if (buffer.isEmpty()) {
			currentToken = null; // if there's no string left, set currentToken null and return
			return;
		}

		// ########## YOUR CODE STARTS HERE ##########


		if (buffer.charAt(0)==';'){
			currentToken = new Token(Token.Type.TERMINATOR, ";");
			buffer = buffer.substring(1);
			return;
		}

		var index  = 0;
		for (int i = 0; i < buffer.length(); i++) {
			if (buffer.charAt(i)==' ' || buffer.charAt(i)==';'){
				index = i;
				break;
			}
		}
		var temp = buffer.substring(0,index);
		if (temp.equalsIgnoreCase("save")){
			currentToken = new Token(Token.Type.SAVE,temp);
		}
		else if (temp.equalsIgnoreCase("load")){
			currentToken = new Token(Token.Type.LOAD,temp);
		}
		else if (temp.equalsIgnoreCase("to")){
			currentToken = new Token(Token.Type.TO,temp);
		}
		else if (temp.equalsIgnoreCase("from")){
			currentToken = new Token(Token.Type.FROM,temp);
		}
		else{
			currentToken = new Token(Token.Type.PARAMETER,temp);
		}


		// ########## YOUR CODE ENDS HERE ##########

		// Remove the extracted token from buffer
		int tokenLen = currentToken.getValue().length();
		buffer = buffer.substring(tokenLen);
	}

	/**
	 * returned the current token extracted by {@code next()} **** please do not
	 * modify this part ****
	 * 
	 * @return type: Token
	 */
	public Token current() {
		return currentToken;
	}

	/**
	 * check whether there still exists another tokens in the buffer or not ****
	 * please do not modify this part ****
	 * 
	 * @return type: boolean
	 */
	public boolean hasNext() {
		return currentToken != null;
	}

}