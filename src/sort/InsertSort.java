package sort;

public class InsertSort {
	
	public void insertSort(int arr[]){
		int guard,i,j;
		for(i = 1; i < arr.length; i++){
			if(arr[i] < arr[i - 1]){
				guard = arr[i];
				for(j = i-1; j >= 0 && guard < arr[j]; j--)
					arr[j+1] = arr[j];
				arr[j+1] = guard;
			}
		}
	}
	
	public void BinarySort(int arr[]){
		int i,j,low,high,mid,guard;
		for(i = 1; i < arr.length; i++){
			guard = arr[i];
			low = 0;high = i - 1;
			while(low <= high){
				mid = (low + high) / 2;
				if(arr[mid] > guard)
					high = mid - 1;
				else
					low = mid + 1;
			}
			for(j = i - 1;j >= high + 1; j--)
				arr[j+1] = arr[j];
			arr[j+1] = guard;
		}
		for(i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	public void ShellSort(int arr[]){
		int len = arr.length;
		int dk,i,j;
		for(dk = len/2;dk >= 1; dk = dk/2)
			for(i = dk; i < len; i++){
				if(arr[i] < arr[i-dk]){
					int tmp = arr[i];
					for(j = i - dk;j >= 0 && tmp < arr[j]; j -= dk)
						arr[j+dk] = arr[j];
					arr[j+dk] = tmp;
				}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertSort insertSort = new InsertSort();
		int arr[] = new int[]{94,32,40,90,80,46,21,69,56};
		insertSort.ShellSort(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
