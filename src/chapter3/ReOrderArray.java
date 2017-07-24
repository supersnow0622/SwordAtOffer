package chapter3;

/**
 * @Description:面试题14：调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该整数数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * @author:王丽雪
 * @time:2016年12月26日下午8:40:06
 */
public class ReOrderArray {
	//数字的相对位置发生变化
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
	
	//数字的相对位置不发生变化
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
