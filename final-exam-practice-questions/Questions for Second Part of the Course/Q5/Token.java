/**
 * @author huy.pham
 */
public class Token {
    public enum Type {EVEN_NUMBER, MATH_OPERATION};
    
    public String originalTokenStr;
    public Type type;

    public Token(Type type, String originalTokenStr) {
        this.type = type;
        this.originalTokenStr = originalTokenStr;
    }
}
