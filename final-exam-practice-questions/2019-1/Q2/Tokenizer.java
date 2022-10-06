/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class Tokenizer {
    private String _buffer;
    private final char COMMAND_SEPARATOR = ';'; 
    
    public Tokenizer(String buffer) {
        this._buffer = buffer;
    }
    
    /**
     * @return the next token
     */
    private Token next() {
        _buffer = _buffer.trim();
        if (_buffer.isEmpty())
            return null;
        
        if (_buffer.startsWith(Token.Type.LEFT.toString())) 
            return new Token(Token.Type.LEFT);
        
        if (_buffer.startsWith(Token.Type.RIGHT.toString())) 
            return new Token(Token.Type.RIGHT);
        
        // TODO: Implement "FORWARD" and "BACK" tokenization.
        // hints:
        // - Character.isDigit() may be useful in extracting the forward or back value from the buffer.
        // - Use new Token(<type>, <original token str>, <value>) to return these tokens

        // TODO: Implement "PENUP" and "PENDOWN" tokenization.

        return null;
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token
     */
    public Token takeNext() {
        // TODO: Add your implementation here.
        return null;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        // TODO: Add your implementation here.
        return false;
    }
   
}