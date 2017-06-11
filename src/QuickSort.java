public class QuickSort {

	public static int partition(int[] data, int start, int end) {

		int pivot = data[start];
		while (start < end) {
			while (data[start] < pivot)
				start++;
			while (data[end] > pivot)
				end--;
			swap(data, start, end);
		}
		
		return start;
	}

	public static void quickSort(int[] data, int start, int end) {
		// Base case: if start is equals end array is of only one element and no
		// sorting needed
		if (start >= end) {
			return;
		}
		int pivot = partition(data, start, end);
		quickSort(data, start, pivot);
		quickSort(data, pivot + 1, end);
	}

	public static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 5, 7, 9, 10, 1, 2, 4, 3, 0, 34, 21, 6 };
		quickSort(data, 0, data.length - 1);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}

	}

}
