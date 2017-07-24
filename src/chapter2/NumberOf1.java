package chapter2;

/**
 * @Description:输入一个整数，输出该数二进制表示中1的个数
 * @author:王丽雪
 * @time:2016年12月22日下午8:23:13
 */
public class NumberOf1 {
	public static int numberOf1(int n){
		int count = 0;
		while(n != 0){
			count++;
			n = (n - 1) & n;
		}
		return count;
	}
	
	public static void main(String args[]){
		System.out.println(numberOf1(0xFFFFFFFF));
	}
}
