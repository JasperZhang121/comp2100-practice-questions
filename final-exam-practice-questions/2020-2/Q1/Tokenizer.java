

public interface Tokenizer {

	/**
	 * check whether there is a next token in the remaining text
	 * @return boolean
	 */
	boolean hasNext();

	/**
	 * return the current token extracted by next() method
	 * @return the current token
	 */
	Token current();

	/**
	 *  Extract next token from the current text and save it.
	 */
	void next();
}
