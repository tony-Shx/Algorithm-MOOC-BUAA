package 分治法;

/**
   *  逆序对计数问题
 * @author tony_Shx
 *
 */
public class CountInver_fz {

	private static int temp[];
	public static void main(String[] args) {
		int num[] = {13,8,10,6,15,18,12,20,9,14,17,19};
		temp = new int[num.length];
		int result = CountInver(num,0,num.length-1);
		System.out.println(result);
	}

	private static int CountInver(int[] num, int left, int right) {
		if(left>=right)
			return 0;
		int mid = (left+right)/2;
		int S1 = CountInver(num, left, mid);
		int S2 = CountInver(num, mid+1, right);
		int S3 = MergeCount(num,left,mid,right);
		return S1+S2+S3;
	}

	private static int MergeCount(int[] num, int left, int mid, int right) {
		for(int i = left;i<=right;++i) {
			temp[i] = num[i];
		}
		int i = left,j = mid+1,k = left,count = 0;
		while(i<=mid&&j<=right) {
			if(temp[i]<=temp[j]) {
				num[k++] = temp[i++];
			}else {
				count += mid-i+1;
				num[k++] = temp[j++];
			}
		}
		while(i<=mid) {
			num[k++] = temp[i++];
		}
		while(j<=right) {
			num[k++] = temp[j++];
		}
		return count;
	}

}
