package utils;

public class MyUtil{
	
	/**
	 * Extract the the first double from string.
	 * i.e. "123.456" => 123.456
	 * i.e. "abc123.456efg" => 123.456
	 * i.e. "abc123." => 123
	 * 
	 * 
	 * @param text input text, may be null
	 * @return {@code double} extracted from text
	 */
	public static double parseDouble(String text){
		if(text == null) {
			return 0;
		}
		
		int pos=0;
		double number;

		while (pos < text.length() && !Character.isDigit(text.charAt(pos)) ){
			pos++;
		}
		int start = pos;
		
		while (pos < text.length() && Character.isDigit(text.charAt(pos)) ){
			pos++;
		}
		
		// check period in a sequence. Note that valid double has only single period in a seq
		if (pos+1 < text.length() && text.charAt(pos) == '.' && Character.isDigit(text.charAt(pos+1))) {
			pos++;
			while (pos < text.length() && Character.isDigit(text.charAt(pos))){
				pos++;
			}
		}

		if (start == pos){
			// when there is no number in text
			return 0;
		}

		System.out.println(text.substring(start, pos));
		number = Double.parseDouble(text.substring(start, pos));
		
		return number;
	}
}