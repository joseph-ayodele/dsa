package sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort implements Sort {
	
	private void swap(List<Integer> list, int i, int j) {
		Integer temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	@Override
	public void sort(List<Integer> list) {
		boolean isSorted;
		for (int i = 0; i < list.size(); i++) {
			isSorted = true;
			for (int j = 1; j < list.size() - i; j++) {
				if (list.get(j) < list.get(j-1)) {
					swap(list, j, j-1);
					isSorted = false;
				}
			}
			if (isSorted) {
				break;
			}
		}
		System.out.println(list);
	}

	public static void main(String[] args) {
		Sort sort = new BubbleSort();
		sort.sort(List.of());
		sort.sort(List.of(7));
		sort.sort(Arrays.asList(7,3));
		sort.sort(Arrays.asList(6,0,5,6,3,1));
	}
}
