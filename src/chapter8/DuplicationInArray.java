package chapter8;

import java.util.Arrays;

/**
 * @Description:面试题51：数组中重复的数字
 * 题目:在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的。但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2，3，1，0，2，5，3}，那么对应的输出是重复的数字2或者3。
 * @author:王丽雪
 * @time:2017年1月13日下午12:56:17
 */
public class DuplicationInArray {
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers == null || length == 0)
			return false;
		Arrays.sort(numbers);
		duplication[0] = -1;
		int num = numbers[0];
		int index = 0;
		int times = 1;
		for(int i = 1; i < length; i++){
			if(num != numbers[i]){
				times--;
				if(times == 0){
					num = numbers[i];
					index = i;
					times = 1;
				}
			}else{
				times++;
				duplication[0] = num;
			}
		}
		if(duplication[0] == -1)	
			return false;
		else 
			return true;
    }
	public static void main(String args[]){
		int[] num = new int[2]; 
		boolean flag = DuplicationInArray.duplicate(new int[]{},0,num);
		if(flag)
			System.out.println(num[0]);
	}
}
