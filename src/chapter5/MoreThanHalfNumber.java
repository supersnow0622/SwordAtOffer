package chapter5;

/**
 * @Description:������29�������г��ִ�������һ�������
 * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * @author:����ѩ
 * @time:2016��12��29������4:30:01
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
