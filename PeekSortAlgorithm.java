public class PeekSortAlgorithm  {
	public static int[] peekSort(final int[] a, final int l, final int r) {
		int n = r - l + 1;
		peeksort(a, l, r, l, r, new int[n]);
		return a;
	}

	public static void peeksort(int[] A, int left, int right, int leftRunEnd, int rightRunStart, final int[] B) {
		if (leftRunEnd == right || rightRunStart == left) return;

		int mid = left + ((right - left) >> 1);
		if (mid <= leftRunEnd) {
			peeksort(A, leftRunEnd+1, right, leftRunEnd+1,rightRunStart, B);
			MergeAlgorithm.mergeRuns(A, left, leftRunEnd+1, right, B);
		} else if (mid >= rightRunStart) {
			peeksort(A, left, rightRunStart-1, leftRunEnd, rightRunStart-1, B);
			MergeAlgorithm.mergeRuns(A, left, rightRunStart, right, B);
		} else {
			final int i, j;
			if (A[mid] <= A[mid+1]) {
				i = MergeAlgorithm.extendWeaklyIncreasingRunLeft(A, mid, left == leftRunEnd ? left : leftRunEnd+1);
				j = mid+1 == rightRunStart ? mid : MergeAlgorithm.extendWeaklyIncreasingRunRight(A, mid+1, right == rightRunStart ? right : rightRunStart-1);
			} else {
				i = MergeAlgorithm.extendStrictlyDecreasingRunLeft(A, mid, left == leftRunEnd ? left : leftRunEnd+1);
				j = mid+1 == rightRunStart ? mid : MergeAlgorithm.extendStrictlyDecreasingRunRight(A, mid+1,right == rightRunStart ? right : rightRunStart-1);
				MergeAlgorithm.reverseRange(A, i, j);
			}

			if (i == left && j == right) return;
			if (mid - i < j - mid) {
				peeksort(A, left, i-1, leftRunEnd, i-1, B);
				peeksort(A, i, right, j, rightRunStart, B);
				MergeAlgorithm.mergeRuns(A,left, i, right, B);
			} else {
				peeksort(A, left, j, leftRunEnd, i, B);
				peeksort(A, j+1, right, j+1, rightRunStart, B);
				MergeAlgorithm.mergeRuns(A,left, j+1, right, B);
			}
		}
	}
}