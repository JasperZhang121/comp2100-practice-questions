/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 *
 * @author huy.pham
 */
public class Tokeniser {
    private String _buffer;

    public Tokeniser(String buffer) {
        this._buffer = buffer;
    }

    /**
     * Return the next token without changing the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token next() {
        if (_buffer.isEmpty())
            return null;

        // TODO: Complete this method
        // START YOUR CODE



        // END YOUR CODE

        return null;
    }

    /**
     * @return the 2nd next token
     */
    public Token nextNext() {
        Tokeniser t = new Tokeniser(_buffer);
        t.takeNext();
        return t.takeNext();
    }

    /**
     * Return the next token and remove it from the buffer
     * @return the next token OR null when there is no more token or the next token is invalid.
     */
    public Token takeNext() {
        Token nextToken = next();
        if (nextToken == null)
            return null;

        if (nextToken.originalTokenStr.length() < _buffer.length()) {
            _buffer = _buffer.substring(nextToken.originalTokenStr.length());
        } else {
        	_buffer = "";
        }
        
        return nextToken;
    }

    /**
     * @return whether there is another token to parse in the buffer
     */
    public boolean hasNext() {
        return next() != null;
    }

    /**
     * @return True if the next token is valid
     */
    public boolean isNextValid() {
        return next() != null || _buffer.isEmpty();
    }
}