package chapter5;

/**
 * @Description:面试题34：丑数
 * 题目：我们把只包含因子2、3和5的数称作丑数。求按从小到大的顺序的第1500个丑数。
 * 例如：6、8都是丑数，但14不是，因为它包含因子7，。习惯上我们把1当作第一个丑数
 * @author:王丽雪
 * @time:2016年12月30日下午7:41:04
 */
public class UglyNumber {
	public int GetUglyNumber_Solution(int index) {
		if(index <= 0)
			return 0;
		int[] pUglyNumbers = new int[index];
		pUglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		int pMultiply2 = 0;
		int pMultiply3 = 0;
		int pMultiply5 = 0;
		
		while(nextUglyIndex < index){
			int min = Min(pUglyNumbers[pMultiply2] * 2,pUglyNumbers[pMultiply3] * 3,pUglyNumbers[pMultiply5] * 5);
			pUglyNumbers[nextUglyIndex] = min;
			
			while(pUglyNumbers[pMultiply2] * 2 <= min)
				++pMultiply2;
			while(pUglyNumbers[pMultiply3] * 3 <= min)
				++pMultiply3;
			while(pUglyNumbers[pMultiply5] * 5 <= min)
				++pMultiply5;
			
			++nextUglyIndex;
		}
		return pUglyNumbers[index - 1]; 
    }
	
	public int Min(int num1,int num2,int num3){
		int min = (num1 < num2) ? num1 : num2;
		min = (min < num3) ? min : num3;
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UglyNumber u = new UglyNumber();
		System.out.println(u.GetUglyNumber_Solution(10));
	}

}
