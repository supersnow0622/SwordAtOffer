package chapter5;

/**����
 * @Description:������36�������е������
 * ��Ŀ���������е������������ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� �����P%1000000007 
 * ���磺{7��5��6��4}�У�������У�7��6������7��5������6��4������5��4�����Ķ�
 * @author:王丽�?-Dosgi.requiredJavaVersion=1.6
 * @time:2017��1��3������11:53:40
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
