package chapter6;

public class LeftRotateString {
	public String leftRotateString(String str,int n) {
		if(n > str.length() || str.equals(""))
			return "";
        StringBuilder sb = new StringBuilder(str.substring(n));
        sb.append(str.substring(0, n));
        return sb.toString();
    }
	public String ReverseSentence(String str) {
		if(str.equals(""))
			return "";
        String array[] = str.split(" ");
        if(array.length == 0)
        	return str;
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--){
        	if(i != 0)
        		sb.append(array[i] + " ") ;
        	else
        		sb.append(array[i]);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeftRotateString l = new LeftRotateString();
		System.out.println(l.ReverseSentence("   ")+"1");
	}

}
