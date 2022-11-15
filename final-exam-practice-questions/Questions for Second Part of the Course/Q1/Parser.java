/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := )S( ; S := SS ;
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
		if (!_tokeniser.isNextValid()) return false;
		if (!_tokeniser.hasNext()) {
			return true;
		}

        // TODO: Complete this method
		// START YOUR CODE

		var count_l = 0;
		var count_r = 0;

		while(_tokeniser.hasNext()){
			var curr = _tokeniser.takeNext();
			if (curr.type.equals(Token.Type.LEFT_BRACKET)) count_l+=1;
			else if (curr.type.equals(Token.Type.RIGHT_BRACKET)) count_r+=1;
			else return false;
		}
		// END YOUR CODE
		return count_l==count_r;
    }

}
