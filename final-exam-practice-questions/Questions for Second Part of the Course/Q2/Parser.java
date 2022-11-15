/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * Question:
 * Write a parse to recognize the language specified by the following grammar:
 * S := () ; S := (S) ; S := SS ;
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

		if (_tokeniser.hasNext()){
			var current = _tokeniser.takeNext();
			var currNext = _tokeniser.nextNext();
			if (current.type== Token.Type.LEFT_BRACKET){
				if (currNext==null)return false;
				else {
					if (currNext.type == Token.Type.LEFT_BRACKET) return parse1();
					else if (currNext.type == Token.Type.RIGHT_BRACKET) return parse2();
					else return false;
				}
			}else return false;
		}
		// END YOUR CODE
		return false;
    }

	public boolean parse1(){
		var cur = _tokeniser.takeNext();


		return false;
	}

	public boolean parse2(){

		if (_tokeniser.hasNext()){
			var curr = _tokeniser.takeNext();
			if (curr.type== Token.Type.LEFT_BRACKET) return parse2();

		} else return false;

		return false;
	}

}
