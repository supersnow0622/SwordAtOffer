package chapter6;

import java.util.Arrays;

/**
 * @Description:������44���˿��Ƶ�˳��
 * ��Ŀ:���˿����������ȡ5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2~10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13��
 * ����С�����Կ����������֡�
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2017��1��10������8:13:18
 */
public class ContinousCards {
	public boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length == 0)
			return false;
		boolean flag = false;
		int count = 0,min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
		for(int i = 0; i < 5; i++){
			if(numbers[i] == 0)
				count++;
			else if(numbers[i] < min) {
				min = numbers[i];				
			}else if(numbers[i] > max){
				max = numbers[i];
			}
		}
		if(count == 0){
			Arrays.sort(numbers);
			int i;
			for(i = 1; i < 5; i++){
				if(numbers[i] - numbers[i-1] != 1){
					break;
				}
			}
			if(i == 5)
				flag = true;
		}else if(count == 1){
			Arrays.sort(numbers);
			int empty = 0,empty2 = 0;
			for(int i = 2; i < 5; i++){
				if(numbers[i] - numbers[i-1] != 1){
					empty++;
					if(numbers[i] - numbers[i-1] == 2)
						empty2++;
				}
			}
			if(empty == 0 || (empty == 1 && empty2 == 1))
				flag = true;
			
		}else if(count == 2){
			Arrays.sort(numbers);
			if(numbers[3] - numbers[2] == 2 && numbers[4] - numbers[3] == 2)
				flag = true;
			else if(numbers[4] - numbers[3] == 3 && numbers[3] - numbers[2] == 1)
				flag = true;
			else if(numbers[4] - numbers[3] == 1 && numbers[3] - numbers[2] == 3)
				flag = true;
			else if(numbers[4] - numbers[3] == 1 && numbers[3] - numbers[2] == 1)
				flag = true;
		}else if(count == 3){
			Arrays.sort(numbers);
			if(numbers[4] - numbers[3] == 1)
				flag = true;
			else if(numbers[4] - numbers[3] == 4)
				flag = true;
		}else if(count == 4)
			flag = true;
		
		return flag;
    }
	public static void main(String args[]){
		ContinousCards c = new ContinousCards();
		System.out.println(c.isContinuous(new int[]{}));
	}
}
