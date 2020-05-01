package 分治法;

/**
 * 利用快速排序求解第k小的元素（固定位置的次序选择问题）
 * @author tony_Shx
 * @version 创建时间：2020年5月1日 下午2:59:59
 */
public class Selection_fz {

	public static void main(String[] args) {
		int num[] = { 24, 17, 40, 28, 13, 14, 22, 32, 40, 21, 48, 4, 47, 8, 37, 18 };
		int k = 5;
		int res = Selection(num, 0, num.length - 1,k-1);
		System.out.println(num[res]);
	}

	private static int Selection(int[] num, int left, int right,int k) {
		if (left >= right)
			return left;
		int index = Partition(num, left, right);
		if(index>k) {
			return Selection(num, left, index - 1,k);
		}else if(index<k) {
			return Selection(num, index + 1, right,k);
		}else {
			return index;
		}
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
