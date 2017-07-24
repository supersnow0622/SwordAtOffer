package chapter5;

/**
 * @Description:������31�����������������
 * ��Ŀ������һ���������飬�������������и�����������һ���������Ķ���������һ�������顣������������ĺ͵����ֵ��
 * Ҫ��ʱ�临�Ӷ�ΪO(n)
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2016��12��29������7:57:16
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
