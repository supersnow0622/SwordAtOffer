package chapter6;

/**
 * @Description:������38�����������������г��ֵĴ���
 * ��Ŀ��ͳ��һ�����������������г��ֵĴ��������磺������������{1,2,3,3,3,3,4,5}������3��
 * ����3����������г�����4�Σ�������4
 * @author:����ѩ
 * @time:2016��12��1������1:16:36
 */
public class NumberOfK {
	public int GetNumberOfK(int [] array , int k) {
		if(array == null || array.length == 0)
			return 0;
		int first = GetFirstK(array,0,array.length-1,k);
		int last = GetLastK(array,0,array.length-1,k);
		if(first != -1 && last != -1){
			return last - first + 1;
		}
		return 0;
    }
	public int GetFirstK(int[] array,int start,int end,int k){
		if(start > end)
			return -1;
		int mid = (start + end) >> 1;
		if(array[mid] > k){
			return GetFirstK(array,start,mid - 1,k);
		}else if(array[mid] < k){
			return GetFirstK(array,mid + 1,end,k);
		}else{
			if((mid > 0 && array[mid - 1] != k) || mid == 0)
				return mid;
			return GetFirstK(array,start,mid - 1,k);
		}
	}
	public int GetLastK(int[] array,int start,int end,int k){
		if(start > end)
			return -1;
		int mid = (start + end) >> 1;
		if(array[mid] > k){
			return GetLastK(array,start,mid - 1,k);
		}if(array[mid] < k){
			return GetLastK(array,mid + 1,end,k);
		}else{
			if((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1)
				return mid;
			return GetLastK(array,mid + 1,end,k);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfK n = new NumberOfK();
		System.out.println(n.GetNumberOfK(new int[]{1,2,3,3,3,3,3,3}, 3));
	}

}
