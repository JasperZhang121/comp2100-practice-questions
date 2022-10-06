

public class Token {

    public enum Type {
        UPPER_CASE_WORD,
        LOWER_CASE_WORD,
        SHORT_CAMEL_CASE_WORD,
        LONG_CAMEL_CASE_WORD,
        INTEGER_NUMBER,
        NON_ALPHANUMERIC
    }

    private String value;
    private Type type;



    public Token(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public Type getType() {
        return type;
    }

    public int getLength() {
        return value.length();
    }
}
