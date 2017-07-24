package chapter5;

/**
 * @Description:������32:��1��n������1���ֵĴ���
 * ��Ŀ������һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�������������12����1��12��Щ�����а���1��������1,10,11��12��1һ��������5�Ρ�
 * @author:����ѩ
 * @time:2016��12��30������2:44:44
 */
public class NumberOf1 {
	public int NumberOf1Between1AndN_Solution(int n) {
	    if(n <= 0)
	    	return 0;
	    String strN = new String();
	    strN = String.valueOf(n);
	    return numberOf1(strN);
    }
	
	public int numberOf1(String strN){
		if(strN.equals("") || strN.charAt(0) < '0' || strN.charAt(0) > '9')
			return 0;
		int first = strN.charAt(0) - '0';
		int len = strN.length();
		if(len == 1 && first == 0)
			return 0;
		if(len == 1 && first > 0)
			return 1;
		
		int numFirstDigit = 0;
		if(first > 1)
			numFirstDigit = PowerBase10(len - 1);
		else if(first == 1)
			numFirstDigit = Integer.valueOf(strN.substring(1)) + 1;
		
		int numOtherDigits = first * (len - 1) * PowerBase10(len - 2);
		int numRecursive = numberOf1(strN.substring(1));
		
		return numFirstDigit + numOtherDigits + numRecursive;
	}
	
	public int PowerBase10(int n){
		int result = 1;
		for(int i = 0; i < n; i++){
			result *= 10;			
		}
		return result;
	}
	
	public static void main(String args[]){
		NumberOf1 n = new NumberOf1();
		System.out.println(n.NumberOf1Between1AndN_Solution(345));
	}
}
