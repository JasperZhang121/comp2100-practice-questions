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

        // Forward(int)
        if (_buffer.startsWith((Token.Type.FORWARD.toString()))){
            String s = "";
            String origin = "";
            for (int i = 0; i < _buffer.length(); i++) {
                if (_buffer.charAt(i)==COMMAND_SEPARATOR) break;
                if (Character.isDigit(_buffer.charAt(i))) s+=_buffer.charAt(i);
                if (_buffer.charAt(i)!=COMMAND_SEPARATOR) origin+=_buffer.charAt(i);
            }
            return new Token(Token.Type.FORWARD,origin,Integer.parseInt(s));
        }
        // back(int)
        if (_buffer.startsWith(Token.Type.BACK.toString())){
            String s = "";
            String origin = "";
            for (int i = 0; i < _buffer.length(); i++) {
                if (_buffer.charAt(i)==COMMAND_SEPARATOR) break;
                if (Character.isDigit(_buffer.charAt(i))) s+=_buffer.charAt(i);
                if (_buffer.charAt(i)!=COMMAND_SEPARATOR) origin+=_buffer.charAt(i);
            }
            return new Token(Token.Type.BACK,origin,Integer.parseInt(s));
        }
        // PenUp
        if (_buffer.startsWith(Token.Type.PENUP.toString())) return new Token(Token.Type.PENUP);
        // PenDown
        if (_buffer.startsWith(Token.Type.PENDOWN.toString())) return new Token(Token.Type.PENDOWN);

        return null;
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token
     */
    public Token takeNext() {
        // TODO: Add your implementation here.

        var res = this.next();
        int count = 0;
        for (int i = 0; i < _buffer.length(); i++) {
            if (_buffer.charAt(i)==COMMAND_SEPARATOR){
                count = i;
                break;
            }
        }
        _buffer = _buffer.substring(count+1);
        return res;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        // TODO: Add your implementation here.

        if (_buffer.length()!=0)return  true;
        return false;
    }
   
}