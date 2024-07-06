package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort implements Sort {

	@Override
	public void sort(List<Integer> list) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] bucket = (ArrayList<Integer>[]) new ArrayList[10];

		for (Integer value : list) {
			var index = value % 10;
			if (bucket[index] == null) {
				bucket[index] = new ArrayList<>();
				bucket[index].add(value);
			} else {
				bucket[index].add(value);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (List<Integer> buc : bucket) {
			if (buc != null) {
				Collections.sort(buc);
				result.addAll(buc);
			}
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		Sort sort = new BucketSort();
		sort.sort(Arrays.asList(4,1,3,4,2,2,2,3));
	}
}
