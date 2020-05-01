package 分治法;

/**
 * 快速排序（选末位元素作为基准元素）
 * @author tony_Shx
 * @version 创建时间：2020年5月1日 下午2:59:59
 */
public class QuickSort_fz {

	public static void main(String[] args) {
		int num[] = { 24, 17, 40, 28, 13, 14, 22, 32, 40, 21, 48, 4, 47, 8, 37, 18 };
		QuickSort(num, 0, num.length - 1);
		for(int i = 0;i<num.length;++i) {
			System.out.print(num[i]+" ");
		}

	}

	private static void QuickSort(int[] num, int left, int right) {
		if (left >= right)
			return;
		int k = Partition(num, left, right);
		QuickSort(num, left, k - 1);
		QuickSort(num, k + 1, right);

	}

	private static int Partition(int[] num, int left, int right) {
		int key = num[right];
		int i = left - 1, j = left;
		for (; j < right; ++j) {
			if (num[j] <= key) {
				int temp = num[j];
				num[j] = num[++i];
				num[i] = temp;
			}
		}
		num[right] = num[i + 1];
		num[i + 1] = key;
		return i + 1;
	}

}
