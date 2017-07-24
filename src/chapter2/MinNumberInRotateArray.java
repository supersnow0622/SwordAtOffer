package chapter2;

public class MinNumberInRotateArray {

	public static int minNumberInRotateArray(int[] array) {
		if(array.length == 0)
			return 0;
		int l = 0,r = array.length - 1;
		int mid = l;
		
		while(array[l] > array[r]){
			if(r - l == 1){
				mid = r;
				break;
			}
			mid = (l + r)/2;
			if(array[l] == array[r] && array[mid] == array[l]){
				int min = Integer.MAX_VALUE;
				for(int i = l; i <= r; i++){
					if(array[i] < min)
						min = array[i];
				}
				return min;
			}
			if(array[mid] >= array[l]){
				l = mid;
			}else if(array[mid] < array[r]){
				r = mid;
			}
		}
		return array[mid];
    }
	public static void main(String args[]){
		int[] array = new int[]{1,1,1,0,1};
		int a = minNumberInRotateArray(array);
		System.out.println(a);
	}
}
