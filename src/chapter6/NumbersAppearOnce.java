package chapter6;

/**五星
 * @Description:面试题40：数组中只出现一次的数字
 * 题目：一个整形数组里除了两个数字之外，其他的数字都出现了两次。请找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n),空间复杂度是O(1)
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年1月9日下午7:53:52
 */
public class NumbersAppearOnce {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int a = array[0];
		for(int i = 1 ; i < array.length; i++){
        	a = a ^ array[i];
        }
		int index = findFirst1InNum(a);
		for(int i = 0; i < array.length; i++){
			if(isOneInPositionN(array[i], index) == 1)
				num1[0] ^= array[i];
			else
				num2[0] ^= array[i];
		}
    }
	//找出一个数的二进制中第一个1的位置
	public int findFirst1InNum(int num){
		int index = 0;
		while(num != 0){
			if(num % 2 != 0)
				return index;
			num /= 2;
			index++;
		}
		return -1;
	}
	//判断一个数的二进制第N为是否为1
	public int isOneInPositionN(int num,int n){
		num = num >> n;
		return (num & 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumbersAppearOnce n = new NumbersAppearOnce();
		int num1[] = new int[1];
		int num2[] = new int[1];
		int[] array = new int[]{2,4,3,6,3,2,5,5};
		n.FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0] + "  " + num2[0]);
	}

}
