package chapter6;

import java.util.ArrayList;

/**五星
 * @Description:面试题45：圆圈中最后剩下的数字
 * 题目：0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈中删除第m个数字。求出这个圆圈里最后剩下的数字。
 * @author:王丽雪
 * @time:2017年1月13日上午10:18:41
 */
public class LastNumberInCircle {
	public static int LastRemaining_Solution(int n, int m) {
		if(n < 1 || m < 1)
			return -1;
		int last = 0;
		for(int i = 1; i <= n; i++){
			last = (last + m) % i;
			System.out.println(last+1);
		}
        return last;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastNumberInCircle.LastRemaining_Solution(7,2);
	}

}
