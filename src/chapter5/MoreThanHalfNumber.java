package chapter5;

/**
 * @Description:面试题29：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * @author:王丽雪
 * @time:2016年12月29日下午4:30:01
 */
public class MoreThanHalfNumber {
	public int MoreThanHalfNum_Solution(int [] array) {
        int num = array[0],count = 1;
        int len = array.length - 1;
        for(int i = 0; i < len; i++ ){
        	if(num != array[i + 1]){
        		count--;
        		if(count == 0){
        			num = array[i + 1];
        			count = 1;
        		}
        	}else {
        		count++;
        	}
        }
        int times = 0;
        if(count > 0){
        	for(int i = 0; i <= len; i++){
        		if(array[i] == num)
        			times++;
        	}
        	if(times * 2 <= array.length)
        		return 0;
        	return num;
        }
        return 0;
    }
	
	public static void main(String args[]){
		MoreThanHalfNumber number = new MoreThanHalfNumber();
		System.out.println(number.MoreThanHalfNum_Solution(new int[]{4,2,1,4,2,4}));
	}
}
