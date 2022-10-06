package utils;

public class MyStringUtil{
    /**
     * Checks if the String contains mixed casing of both uppercase and
     * lowercase characters.
     *
     * {@code null} input will return {@code false}. An empty String
     * ({@code length()=0}) will return {@code false}.
     * 
     * @param text    the String to check, may be null
     * @return {@code true} if the String contains both uppercase and
     *         lowercase characters
     */
    public static boolean isMixedCase(String text) {
        if (text == null) {
            return false;
        }

        boolean containsUppercase = false;
        boolean containsLowercase = false;
        final int sz = text.length();

        if(sz == 0){
        	return false;
        }

        for (int i = 0; i < sz; i++) {
            if (containsUppercase) {
            	if (containsLowercase) {
            		return true;
            	}
            }
            if (Character.isUpperCase(text.charAt(i))) {
                containsUppercase = true;
            } 
            if (Character.isLowerCase(text.charAt(i))) {
                containsLowercase = true;
            }
        }
        
        return containsUppercase && containsLowercase;
    }
}