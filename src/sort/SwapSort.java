package sort;

public class SwapSort {
	
	public void BubbleSort(int arr[]){
		int n = arr.length;
		boolean flag;
		for(int i = 0;i < n - 1; i++){
			flag = false;
			for(int j = n - 1; j > i; j--){
				if(arr[j - 1] > arr[j]){
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
					flag = true;
				}
			}
			if(!flag)
				return;	
		}
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public void QuickSort(int arr[],int low,int high){
		if(low < high){
			int pivotpos = Partition(arr, low, high);
			QuickSort(arr, low, pivotpos-1);
			QuickSort(arr, pivotpos+1, high);
		}
	}
	
	public int Partition(int arr[],int low,int high){
		int pivot = arr[low];
		while(low < high){
			while(low < high && arr[high] > pivot)
				high--;
			arr[low] = arr[high];
			while(low < high && arr[low] < pivot)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = pivot;
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapSort sort = new SwapSort();
		int arr[] = new int[]{94,32,40,90,80,46,21,69};
		long start = System.currentTimeMillis();
		sort.QuickSort(arr, 0, arr.length-1);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}
