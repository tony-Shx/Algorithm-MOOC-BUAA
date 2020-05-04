package 动态规划法;
/**
 * 动规求解最优子数组问题
* @author tony_Shx
* @version 创建时间：2020年5月4日 下午4:36:46
*/
public class MaxSubArray_DP {

	public static void main(String[] args) {
		int num[] = {1,-2,4,5,-2,8,3,-2,6,3,7,-1};
		MaxSubArrayDP(num,num.length);

	}

	private static void MaxSubArrayDP(int[] num,int length) {
		int D[] = new int[length];
		int Rec[] = new int[length];
		D[length-1] = num[length-1];
		Rec[length-1] = length-1;
		for(int i = length-2;i>-1;--i) {
			if(D[i+1]>0) {
				D[i] = num[i] + D[i+1];
				Rec[i] = Rec[i+1];
			}else {
				D[i] = num[i];
				Rec[i] = i;
			}
		}
		int Max = D[0],left=0,right = Rec[0];
		for(int i =1;i<length;++i) {
			if(D[i]>Max) {
				Max = D[i];
				left = i;
				right = Rec[i];
			}
		}
		System.out.println(Max+" "+left+" "+right);
		for(int i =left;i<=right;++i) {
			System.out.print(num[i]+" ");
		}
	}

}
