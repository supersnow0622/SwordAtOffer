package chapter5;

/**
 * @Description:������34������
 * ��Ŀ�����ǰ�ֻ��������2��3��5���������������󰴴�С�����˳��ĵ�1500��������
 * ���磺6��8���ǳ�������14���ǣ���Ϊ����������7����ϰ�������ǰ�1������һ������
 * @author:����ѩ
 * @time:2016��12��30������7:41:04
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
