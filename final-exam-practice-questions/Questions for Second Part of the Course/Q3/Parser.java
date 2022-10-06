/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * X := 1 | 3 | 5 | 7 | 9 ; Y := 0 | 2 | 4 | 6 | 8 ; X := YX ; Y := XY ; S := X | Y ;
 *
 * @author huy.pham
 */
public class Parser {
    Tokeniser _tokeniser;
    
    public Parser(Tokeniser tokeniser) {
    	_tokeniser = tokeniser;
    }

	/**
	 * @return True if the given tokens conform with the grammar. False, otherwise.
	 */
	public boolean parseExp() {
		if (!_tokeniser.isNextOrLastValid()) return false;
		if (!_tokeniser.hasNext()) {
			return true;
		}

        // TODO: Complete this method
		// START YOUR CODE



		// END YOUR CODE
		return false;
	}

}
