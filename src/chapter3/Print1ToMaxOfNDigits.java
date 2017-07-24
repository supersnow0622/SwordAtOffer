package chapter3;

/**
 * @Description:面试题12：打印1到最大的n位数
 * @author:王丽雪
 * @time:2016年12月26日下午7:16:54
 */
public class Print1ToMaxOfNDigits {
	
	public void printNumber(char[] number){
		boolean isBegin = true;
		int len = number.length;
		for(int i = 0;i < len;i++){
			if(isBegin && number[i] != '0')
				isBegin = false;
			if(!isBegin){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	public void print1ToMaxOfNDigitsResursively(char[] number,int length,int index){
		if(index == length - 1){
			this.printNumber(number);
			return;
		}
		for(int i = 0;i < 10; i++){
			number[index+1] = (char) (i + '0');
			print1ToMaxOfNDigitsResursively(number,length,index + 1);
		}
	}

	public void print1ToMaxOfNDigits(int n){
		if(n <= 0)
			return;
		char[] number = new char[n];
		
		for(int i = 0; i < 10; i++){
			number[0] = (char) (i + '0');
			print1ToMaxOfNDigitsResursively(number,n,0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print1ToMaxOfNDigits p = new Print1ToMaxOfNDigits();
		p.print1ToMaxOfNDigits(3);
	}

}
