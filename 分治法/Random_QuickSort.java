package 分治法;

import java.util.Random;

/**
 * 随机化快速排序（末位作为基准位置）
* @author tony_Shx
* @version 创建时间：2020年5月1日 下午3:20:47
*/
public class Random_QuickSort {

	public static void main(String[] args) {
		int num[] = { 24, 17, 40, 28, 13, 14, 22, 32, 40, 21, 48, 4, 47, 8, 37, 18 };
		RandomQuickSort(num, 0, num.length - 1);
		for(int i = 0;i<num.length;++i) {
			System.out.print(num[i]+" ");
		}

	}

	private static void RandomQuickSort(int[] num, int left, int right) {
		if (left >= right)
			return;
		int k = RandomPartition(num, left, right);
		RandomQuickSort(num, left, k - 1);
		RandomQuickSort(num, k + 1, right);

	}
	
	private static int RandomInt(int start,int end) {
		Random random = new Random();
		int res = random.nextInt(end-start+1)+start;
		return res;
	}

	private static int RandomPartition(int[] num, int left, int right) {
		int keyIndex = RandomInt(left, right);
		int key = num[keyIndex];
		num[keyIndex] = num[right];
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
