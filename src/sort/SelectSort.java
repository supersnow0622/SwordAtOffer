package sort;

public class SelectSort {
	
	public void selectSort(int arr[]){
		int min,n = arr.length;
		for(int i = 0;i < n-1; i++){
			min = i;
			for(int j = i+1;j < n;j++)
				if(arr[min] > arr[j])
					min = j;
			if(min != i){
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}
	
	public void BuildMaxHead(int arr[]){
		int len = arr.length;
		for(int i = (len-1)/2; i >= 0; i--){
			AdjustDown(arr, i, len);
		}
	}
	public void AdjustDown(int arr[],int k,int len){
		int tmp = arr[k],i;
		for(i = 2*k+1;i < len; i = 2*i+1){
			if(i < len-1 && arr[i] < arr[i + 1])
				i++;
			if(tmp >= arr[i])
				break;
			else{
				arr[k] = arr[i];
				k = i;
			}
		}
		arr[k] = tmp;
	}
	public void HeapSort(int arr[]){
		BuildMaxHead(arr);
		int len = arr.length;
		for(int i = len-1; i > 0; i--){
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			AdjustDown(arr, 0, i-1);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectSort sort = new SelectSort();
		int arr[] = new int[]{94,32,40,90,80,46,21,69};
		long start = System.currentTimeMillis();
		sort.HeapSort(arr);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
