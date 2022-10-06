public class StringUtil {
	
	/*
	 * This method collapses multiple consecutive newline characters 
	 * into a single newline character in a given sequence ('\n')
	 */
	public static String collapseNewlines(String argStr)
	{
		if (argStr.length() < 2) {
			return argStr;
		}
		
		StringBuffer argBuf = new StringBuffer();
		char last = argStr.charAt(0);		
		argBuf.append(last);
		
		for (int cIdx = 1 ; cIdx < argStr.length(); cIdx++)
		{
			char cur = argStr.charAt(cIdx);
			
			if(cur!='\n') {
				argBuf.append(cur);
			}else {
				if (last != '\n') {
					argBuf.append(cur);
				}
			}
			last = cur;
		}
		return argBuf.toString();
	}
}
