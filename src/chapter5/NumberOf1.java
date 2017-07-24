package chapter5;

/**
 * @Description:面试题32:从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1,10,11和12，1一共出现了5次。
 * @author:王丽雪
 * @time:2016年12月30日下午2:44:44
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
