

public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {


        buffer = buffer.trim(); // remove whitespace

         if(buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
         }

        // ########## YOUR CODE STARTS HERE ##########

        var temp = "";var digit = "";
        for (int i = 0; i < buffer.length(); i++) {
            if (Character.isLetter(buffer.charAt(i))){
                temp+= buffer.charAt(i)+"";
            }
            if (Character.isDigit(buffer.charAt(i))){
                digit+=buffer.charAt(i)+"";
            }

            if (buffer.charAt(i)==' ' || !(Character.isLetter(buffer.charAt(i)) || Character.isDigit(buffer.charAt(i)))){
                break;
            }
        }
        if (!(Character.isLetter(buffer.charAt(0)) || Character.isDigit(buffer.charAt(0)))){
            temp = buffer.charAt(0)+"";
            currentToken = new Token(temp, Token.Type.NON_ALPHANUMERIC);
            temp = "";
        }

        if (!temp.equals("")){
            if (temp.toUpperCase().equals(temp)) currentToken = new Token(temp, Token.Type.UPPER_CASE_WORD);
            if (temp.toLowerCase().equals(temp)) currentToken = new Token(temp, Token.Type.LOWER_CASE_WORD);

            if (!temp.toUpperCase().equals(temp) && !temp.toLowerCase().equals(temp)){
                if (temp.length()<=3) currentToken = new Token(temp, Token.Type.SHORT_CAMEL_CASE_WORD);
                if (temp.length()>3) currentToken = new Token(temp, Token.Type.LONG_CAMEL_CASE_WORD);
            }
        }

        if (!digit.equals("")) currentToken = new Token(digit, Token.Type.INTEGER_NUMBER);

        // ########## YOUR CODE ENDS HERE ##########

        // Remove the extracted token from buffer
        int tokenLen = currentToken.getValue().length();
        buffer = buffer.substring(tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


}