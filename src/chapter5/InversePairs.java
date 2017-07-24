package chapter5;

/**五星
 * @Description:面试题36：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007 
 * 例如：{7，5，6，4}中，逆序对有（7，6）、（7，5）、（6，4）、（5，4）共四对
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年1月3日上午11:53:40
 */
public class InversePairs {
	public int inversePairs(int [] array) {
		int len = array.length;
        if(array == null || len < 0)
    	    return 0;
       
        int copy[] = new int[len];
        for(int i = 0; i < len; i++)
        	copy[i] = array[i];
        return InversePairsCore(array,copy,0,len-1);
    }
	public int InversePairsCore(int[] array,int[] copy,int start,int end){
		if(start == end){
			return 0;
		}
		int mid = (start+end)>>1;
		int left = InversePairsCore(array, copy, start, mid) % 1000000007;
		int right = InversePairsCore(array, copy,mid + 1, end) % 1000000007;
		
		int i = mid;
		int j = end;
		int indexCopy = end;
		int count = 0;
		while(i >= start && j > mid ){
			if(array[i] > array[j]){
				copy[indexCopy--] = array[i--];
				count += (j - mid);
				if(count >= 1000000007)
					count %= 1000000007;
			}else{
				copy[indexCopy--] = array[j--];
			}
		}
		for(;i >= start;i--){
			copy[indexCopy--] = array[i];
		}
		for(;j > mid; j--){
			copy[indexCopy--] = array[j];
		}
		for(int s = start;s <= end; s++){
			array[s] = copy[s];
		}
		return (left + right + count) % 1000000007;
	}
	
	
	public static void main(String args[]){
		InversePairs i = new InversePairs();
		System.out.println(i.inversePairs(new int[]{1,2,3,4,5,6,7,0}));
	}
}
