package parser;
/**
 * @author huy.pham
 */
public class Token {
    public enum Type {FORWARD, BACK, LEFT, RIGHT, PENUP, PENDOWN, FORWARD_TO_END, BACK_TO_END};
    
    public String originalTokenStr;
    public Type type;
    public int value;
    
    public Token(Type type) {
    	this.originalTokenStr = type.toString();
        this.type = type;
    }
    
    public Token(Type type, String originalTokenStr, int value) {
    	this.originalTokenStr = originalTokenStr;
        this.type = type;
        this.value = value;
    }
}
