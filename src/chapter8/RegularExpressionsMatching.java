package chapter8;

public class RegularExpressionsMatching {
	public boolean match(char[] str, char[] pattern)
    {
		if(str == null || pattern == null)
			return false;
		if(str.length == 0 && pattern.length == 0)
			return true;
		if(str.length + 1 == pattern.length && pattern[pattern.length - 1] == '.')
			return false;
		if(str.length == 0 && pattern[0] == '.' && pattern[1] == '*')
			return true;
		return matchCore(str, 0, pattern, 0);
    }
	public boolean matchCore(char[] str,int strIndex,char[] pattern,int patternIndex){
		int len1 = str.length;
		int len2 = pattern.length;
		if(strIndex == len1 && patternIndex == len2)
			return true;
		if(strIndex != len1 && patternIndex == len2)
			return false;
		if(strIndex == len1 && patternIndex != len2)
			return matchCore(str, strIndex, pattern, patternIndex + 1);
		
		if(patternIndex + 1 != len2 && pattern[patternIndex + 1] == '*'){
			if(str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex != len1))
				return (matchCore(str,strIndex + 1 ,pattern,patternIndex + 2)
						||matchCore(str,strIndex + 1,pattern,patternIndex)
						||matchCore(str,strIndex,pattern,patternIndex + 2));
			else
				return matchCore(str, strIndex, pattern, patternIndex + 2);
		}
		if(str[strIndex] == pattern[patternIndex] || (pattern[patternIndex] == '.' && strIndex != len1))
			return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
		return false;			
	}
	
	public static void main(String args[]){
		RegularExpressionsMatching r = new RegularExpressionsMatching();
		System.out.println(r.match(new char[]{}, new char[]{'c','*'}));
	}
}
