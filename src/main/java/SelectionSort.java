public class SelectionSort {

	public static void sort(int[] data) {

		for (int i = 0; i < data.length - 1; i++) {
			int min = i;
			int j = i + 1;
			for (; j < data.length; j++) {
				if (data[min] > data[j]) {
					min = j;
				}
			}
			swap(data, i, min);
		}
	}

	private static void swap(int[] data, int i, int min) {
		if (min < data.length) {
			int temp = data[min];
			data[min] = data[i];
			data[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] data = { 2, 4, 6, 1, 8, 5 };
		sort(data);
		for (int j = 0; j < data.length; j++) {
			System.out.print(data[j] + " ");
		}
	}

}
