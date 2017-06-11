
public class BubbleSort {
	
	public static void sort(int[] data) {
		
		for(int i = 0; i < data.length - 1; i++) {
			boolean swapped = false;
			for(int j = i+1; j < data.length; j++) {
				if(data[j] < data[i]) {
					swap(data, j, i);
					swapped = true;
				}
			}
			if(!swapped) break;
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
		System.out.println();
		int[] data1 = { 1, 2, 3, 4, 5, 6};
		sort(data1);
		for (int j = 0; j < data1.length; j++) {
			System.out.print(data1[j] + " ");
		}
	}

}
