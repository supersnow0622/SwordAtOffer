package chapter5;

/**
 * @Description:面试题31：连续子数组的最大和
 * 题目：输入一个整形数组，数组里有正书有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2016年12月29日下午7:57:16
 */
public class GreatestSumOfSubarrays {
	public int FindGreatestSumOfSubArray(int[] array) {
		if(array == null || array.length == 0)
			return 0;
        int sum = -10000000;
        //int sumN[] = new int[array.length];
        //sumN[0] = array[0];
        int preSum = array[0];
        int curSum;
        for(int i = 1; i < array.length; i++){
        	if(array[i] + preSum > array[i])
        		curSum = preSum + array[i];
        	else
        		curSum = array[i];
        	if(sum < curSum)
        		sum = curSum;
        	preSum = curSum;
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreatestSumOfSubarrays g = new GreatestSumOfSubarrays();
		System.out.println(g.FindGreatestSumOfSubArray(new int[]{-1,2,1}));
	}

}
