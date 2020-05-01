package ·ÖÖÎ·¨;

public class MergeSort_fz {

	private static int[] temp;
	public static void main(String[] args) {
		int num[] = {24,17,40,28,13,14,22,32,40,21,48,4,47,8,37,18};
		temp = new int[num.length];
		MergeSort(num,0,num.length-1);
		for(int i = 0;i<num.length;++i) {
			System.out.print(num[i]+" ");
		}
	}

	private static void MergeSort(int[] num, int left, int right) {
		if(left>=right)
			return;
		int mid = (left+right)/2;
		MergeSort(num, left, mid);
		MergeSort(num, mid+1, right);
		Merge(num,left,mid,right);
	}

	private static void Merge(int[] num, int left, int mid, int right) {
		for(int i=left;i<=right;++i) {
			temp[i] = num[i];
		}
		int i = left,j = mid+1,k = left;
		while(i<=mid&&j<=right) {
			if(temp[i]<=temp[j]) {
				num[k++] = temp[i++];
			}else {
				num[k++] = temp[j++];
			}
		}
		while(i<=mid) {
			num[k++] = temp[i++];
		}
		while(j<=right) {
			num[k++] = temp[j++];
		}
		
	}

}
