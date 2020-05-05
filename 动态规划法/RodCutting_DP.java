package 动态规划法;
/**
 * 动规求解钢条切割问题（区间动态规划）
* @author tony_Shx
* @version 创建时间：2020年5月5日 下午8:31:34
*/
public class RodCutting_DP {

	private static int p[] = {0,1,5,8,9,10,17,17,20,24,24};
	public static void main(String[] args) {
		int n = 10;
		int C[] = new int[n+1];
		int Rec[] = new int[n+1];
		C[0] = 0;
		Rec[0] = 0;
		RodCutting(C,Rec,n);

	}
	private static void RodCutting(int[] C, int[] Rec,int n) {
		int max = 0;
		for(int i = 1;i<=n;++i) {
			for(int j = 1;j<=i;++j) {
				if(p[j]+C[i-j]>max) {
					max = p[j]+C[i-j];
					Rec[i] = j;
				}
			}
			C[i] = max;
			max = 0;
		}
		//输出检验结果
		for(int it:C) {
			System.out.print(it+"\t");
		}
		System.out.println("\n最大收益为："+C[n]);
		System.out.print("切割方案为：{");
		int index = n;
		while(Rec[index]<index) {
			System.out.print(Rec[index]+",");
			index = index-Rec[index];
		}
		System.out.println(Rec[index]+"}");
		
	}

}
