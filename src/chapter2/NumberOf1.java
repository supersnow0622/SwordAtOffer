package chapter2;

/**
 * @Description:����һ��������������������Ʊ�ʾ��1�ĸ���
 * @author:����ѩ
 * @time:2016��12��22������8:23:13
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
