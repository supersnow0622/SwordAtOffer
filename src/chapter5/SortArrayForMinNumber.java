package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:面试题33：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3,32,321},则打印出这三个数字能排成的最小数字321323
 * @author:王丽雪
 * @time:2016年12月30日下午3:27:36
 */
public class SortArrayForMinNumber {
	 public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length <= 0)
			return "";
		String numStr[] = new String[numbers.length];
		for(int i = 0 ; i < numbers.length; i++){
			numStr[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(numStr, new Comparator<String>(){
			@Override
			public int compare(String str1, String str2) {
				// TODO Auto-generated method stub
				String str12 = str1 + str2;
				String str21 = str2 + str1;
				return str12.compareTo(str21);
			}});
		String result = "";
		for(int i = 0; i < numStr.length; i++){
			//System.out.println(numStr[i]);
			result += numStr[i];
		}
		return result;
	 }
	 
	 public static void main(String args[]){
		 SortArrayForMinNumber s = new SortArrayForMinNumber();
		 System.out.println(s.PrintMinNumber(new int[]{3334,3,3333332}));
	 }
}
