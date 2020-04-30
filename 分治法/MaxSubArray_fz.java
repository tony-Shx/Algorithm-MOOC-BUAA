package 分治法;

/**
 * 求解已知数组的最大子数组的和
 * @author Tony-Shx
 *
 */
public class MaxSubArray_fz {
	
	private static int MaxSubArray(int[] num,int left,int right) {
		if(left>=right)
			return num[left];
		int mid = (left+right)/2;
		int S1 = MaxSubArray(num, left, mid);
		int S2 = MaxSubArray(num, mid+1, right);
		int S3 = CrossingSubArray(num,left,mid,right);
		//System.out.println(S1+" "+S2+" "+S3);
		if(S1>S2&&S1>S3)
			return S1;
		else if(S2>S1&&S2>S3)
			return S2;
		else {
			return S3;
		}
	}

	private static int CrossingSubArray(int[] num, int left, int mid, int right) {
		int SL = 0,SMaxL = Integer.MIN_VALUE;
		for(int i = mid;i>=left;--i) {
			SL += num[i];
			if(SL>SMaxL)
				SMaxL = SL;
		}
		int SR = 0,SMaxR = Integer.MIN_VALUE;
		for(int i = mid+1;i<=right;++i) {
			SR += num[i];
			if(SR>SMaxR)
				SMaxR = SR;
		}
		return SMaxR+SMaxL;
		
	}

	public static void main(String[] args) {
		int num[] = {1,-2,4,5,-2,8,3,-2,6,3,7,-1};
		int Smax = MaxSubArray(num,0,num.length-1);
		System.out.println(Smax);
	}

}
