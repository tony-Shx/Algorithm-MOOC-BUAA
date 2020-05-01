package ���η�;

import java.util.Random;

/**
 * ���ÿ�����������kС��Ԫ�أ����λ�õĴ���ѡ�����⣩
 * @author tony_Shx
 * @version ����ʱ�䣺2020��5��1�� ����2:59:59
 */
public class Random_Selection {

	public static void main(String[] args) {
		int num[] = { 24, 17, 40, 28, 13, 14, 22, 32, 40, 21, 48, 4, 47, 8, 37, 18 };
		int k = 5;
		int res = RandomSelection(num, 0, num.length - 1,k-1);
		System.out.println(num[res]);
	}

	private static int RandomSelection(int[] num, int left, int right,int k) {
		if (left >= right)
			return left;
		int index = RandomPartition(num, left, right);
		if(index>k) {
			return RandomSelection(num, left, index - 1,k);
		}else if(index<k) {
			return RandomSelection(num, index + 1, right,k);
		}else {
			return index;
		}
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
