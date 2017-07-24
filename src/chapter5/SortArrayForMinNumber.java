package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:������33���������ų���С����
 * ��Ŀ������һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3,32,321},���ӡ���������������ųɵ���С����321323
 * @author:����ѩ
 * @time:2016��12��30������3:27:36
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
