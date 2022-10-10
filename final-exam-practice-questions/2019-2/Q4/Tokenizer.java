package parser;
/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 * @author dongwoo
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    private Token current;
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
        this.next();
    }
    
    /**
     *  Extract the next token from {@code _buffer}
     */
    public void next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty()) {
            current = null;
        	return;
        }
        
        if (_buffer.startsWith(Token.Type.LEFT.toString())) 
            current = new Token(Token.Type.LEFT);
        
        if (_buffer.startsWith(Token.Type.RIGHT.toString())) 
            current = new Token(Token.Type.RIGHT);
        
        // TODO: Implement "FORWARD_TO_END" and "BACK_TO_END" tokenization.
        // TODO: Implement "FORWARD" and "BACK" tokenization.
        // TODO: Implement "PENUP" and "PENDOWN" tokenization.        
        // hints:
        // - Do not consider the case where text is syntactically incorrect.        
        // - Careful if you use String.startsWith. FORWARD_TO_END and FORWARD starts with
        //   the same string "FORWARD". Same for the BACK cases.
        // - Character.isDigit() may be useful in extracting the forward or back value from the buffer.
        // - Use new Token(<type>, <original token str>, <value>) to return these tokens
        // - Check the expected outcome in TokenizerTest.java

 
    }
    

    /**
     * Return the token in {@code _current}
     * @return the next token
     */
    public Token current() {
        return current;
    }

    /**
     * @return whether there is another token in {@code _current}
     */
    public boolean hasNext() {
        if(current == null){
            return false;
        }
        return true;
    }

}