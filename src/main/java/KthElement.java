// Modified Quick sort
public class KthElement {

	public static int partition(int[] data, int start, int end){
		
		// Consider first element in an array is pivot
		int pivot = start;
		while(start < end) {
			while(data[start] < data[pivot]) start++;
			while(data[end] > data[pivot]) end--;
			swap(data, start, end);
		}
		
		return pivot;
	}
	
	public static int quickSort(int[] data, int start, int end, int k) {
		// Base case: if start is equals end array is of only one element and no sorting needed
		if(start >= end) {
			return -1;
		}
		int pivot = partition(data, start, end);
		if(pivot+1 == k) return data[pivot];
		if(k < pivot+1)
		return quickSort(data, start, pivot, k);
		
		if(k > pivot+1) 
		return quickSort(data, pivot+1, end, k);
		
		return -1;
	}
	
	public static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	public static void main(String[] args) {
		int[] data = new int[] {5,7,9,10,1,2,4,3,0,34,21,6};
		System.out.print(quickSort(data, 0, data.length-1, 8));

	}
}
