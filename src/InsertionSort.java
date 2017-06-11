public class InsertionSort {

	public static void sort(int[] data) {

		for (int i = 1; i < data.length; i++) {
			int temp = data[i];
			int k = i;
			while (k > 0 && data[k - 1] > temp) {
				data[k] = data[k - 1];
				k--;
			}
			data[k] = temp;
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
