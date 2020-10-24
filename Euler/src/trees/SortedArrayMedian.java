package trees;

public class SortedArrayMedian {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l = nums1.length + nums2.length;
		int nums3[] = new int[l];

		int i = 0, j = 0, k = 0;
		while ((nums1.length > 0 && i < nums1.length) && (nums2.length > 0 && j < nums2.length)) {
			if (nums1[i] < nums2[j]) {
				nums3[k++] = nums1[i++];
			} else if (nums1[i] > nums2[j]) {
				nums3[k++] = nums2[j++];
			}
		}

		if (i < nums1.length) {
			for (; i < nums1.length; i++) {
				nums3[k++] = nums1[i];
			}
		}

		if (j < nums2.length) {
			for (; j < nums2.length; j++) {
				nums3[k++] = nums2[j];
			}
		}

		if (l > 0) {
			if (l % 2 == 0) {
				System.out.println(nums3[l / 2] + "," + nums3[(l / 2) - 1]);
				int half = l / 2;
				double r = (nums3[half] + nums3[half - 1]) / 2.0;
				return r;
			} else if (l % 2 != 0) {
				return nums3[l / 2];
			}

		}

		return 0;
	}

	public static void main(String[] args) {
		SortedArrayMedian ob = new SortedArrayMedian();
		int nums1[] = { 1, 2 };
		int nums2[] = { 3, 4 };

		System.out.println(ob.findMedianSortedArrays(nums1, nums2));

	}

}
