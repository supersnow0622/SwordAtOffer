package chapter3;

/**
 * @Description:������14����������˳��ʹ����λ��ż��ǰ��
 * ����һ���������飬ʵ��һ���������������������������ֵ�˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿��
 * @author:����ѩ
 * @time:2016��12��26������8:40:06
 */
public class ReOrderArray {
	//���ֵ����λ�÷����仯
	public void reOrderArray1(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while(start < end){
        	while(true){
        		if(array[start] % 2 == 0)
        			break;
        		start++;
        	}
        	while(true){
        		if(array[end] % 2 != 0)
        			break;
        		end-- ;
        	}
        	if(start < end){
	        	int temp = array[start];
	        	array[start] = array[end];
	        	array[end] = temp;
        	}
        }
        for(int i = 0 ;i < array.length; i++){
        	System.out.print(array[i] + " ");;
        }
    }
	
	//���ֵ����λ�ò������仯
	public void reOrderArray(int [] array) {
		int len = array.length;
		int[] array1 = new int[len];
		int[] array2 = new int[len];
		int count1 = 0,count2 = 0;
		for(int i = 0; i < len; i++){
			if(array[i] % 2 != 0)
				array1[count1++] = array[i];
			else
				array2[count2++] = array[i];
		}
		for(int i = 0; i < count1; i++)
			array[i] = array1[i];
		for(int i = 0; i < count2; i++)
			array[i + count1] = array2[i];
		for(int i = 0 ;i < array.length; i++){
        	System.out.print(array[i] + " ");;
        }
	}
	
	public static void main(String args[]){
		ReOrderArray r = new ReOrderArray();
		int[] array = new int[]{1,2,3,4,5,6,7};
		r.reOrderArray(array);
		
	}
}
