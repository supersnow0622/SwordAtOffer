package chapter8;

import java.util.Arrays;

/**
 * @Description:������51���������ظ�������
 * ��Ŀ:��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ġ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ�
 * ���ҳ�����������һ���ظ������֡����磬������볤��Ϊ7������{2��3��1��0��2��5��3}����ô��Ӧ��������ظ�������2����3��
 * @author:����ѩ
 * @time:2017��1��13������12:56:17
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
