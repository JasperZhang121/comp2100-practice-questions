import java.util.Locale;

public class Tokeniser {

	private String buffer;
	private Token currentToken;

	public Tokeniser(String text) {
		buffer = text;
		next();
	}

	public void next() {

		// ########## YOUR CODE STARTS HERE ##########

		buffer = buffer.trim();
		if (buffer.isEmpty()) {
			currentToken = null;    // if there's no string left, set currentToken null and return
			return;
		}

		var temp = "";
		var index = 0;

		if (buffer.charAt(0)==';'){
			currentToken = new Token(Token.Type.TERMINATOR, ";");
			buffer = buffer.substring(1);
			return;
		}
		for (int i = 0; i < buffer.length(); i++) {
			if (Character.isLetter(buffer.charAt(i)) || Character.isDigit(buffer.charAt(i)) || buffer.charAt(i)== '*'){
				var t = buffer.charAt(i)+"";
				temp+=t;
			}
			if (temp!="" && buffer.charAt(i)==' '|| buffer.charAt(i)==';'){
				index = i;
				break;
			}
		}
		var lower  = temp.toLowerCase();
		if (lower.equals("save")) currentToken = new Token(Token.Type.SAVE, temp);
		else if (lower.equals("load")) currentToken = new Token(Token.Type.LOAD, temp);
		else if (lower.equals("to")) currentToken = new Token(Token.Type.TO, temp);
		else if (lower.equals("sum")) currentToken = new Token(Token.Type.SUM, temp);
		else if (lower.equals(";")) currentToken = new Token(Token.Type.TERMINATOR, temp);
		else currentToken = new Token(Token.Type.PARAMETER, temp);

		buffer = buffer.substring(index);

		// ########## YOUR CODE ENDS HERE ##########
	}

	public Token current() {
		return currentToken;
	}

	public boolean hasNext() {
		return currentToken != null;
	}

}