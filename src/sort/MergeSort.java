package sort;

public class MergeSort {
	
	int arrTmp[] = new int[8];
	public void Merge(int arr[],int low,int mid,int high){
		for(int k = low;k <= high; k++)
			arrTmp[k] = arr[k];
		int i,j,k;
		for(i = low,j = mid+1,k = i; i <= mid && j <= high;k++){
			if(arrTmp[i] <= arrTmp[j])
				arr[k] = arrTmp[i++];
			else 
				arr[k] = arrTmp[j++];
		}
		while(i <= mid) arr[k++] = arrTmp[i++];
		while(j <= high) arr[k++] = arrTmp[j++];
	}
	
	public void MergeSort(int arr[],int low,int high){
		if(low < high){
			int mid = (low + high)/2;
			MergeSort(arr, low, mid);
			MergeSort(arr, mid+1, high);
			Merge(arr, low, mid, high);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort sort = new MergeSort();
		int arr[] = new int[]{94,32,40,90,80,46,21,69};
		
		sort.MergeSort(arr, 0, 7);

		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
