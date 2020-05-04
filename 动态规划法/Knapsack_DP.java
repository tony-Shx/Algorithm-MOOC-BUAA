package 动态规划法;
/**
 * 递推法（非递归）求解01背包问题
* @author tony_Shx
* @version 创建时间：2020年5月4日 下午2:38:41
*/
public class Knapsack_DP {
	
	private static int p[] = { 24, 2, 9, 10, 9 };
	private static int v[] = { 10, 3, 4, 5, 4 };
	private static int Pri[][],Rec[][];
	public static void main(String[] args) {
		int c = 13;
		Pri = new int[p.length+1][c+1];
		Rec = new int[p.length+1][c+1];
		
		//P数组初始化
		for(int i = 0;i<=c;++i)
			Pri[0][i] = 0;
		for(int i = 0;i<=p.length;++i)
			Pri[i][0] = 0;
		KnapsackDP(c);

	}
	private static void KnapsackDP(int c) {
		for(int i = 1;i<=p.length;++i) {
			for(int j = 1;j<=c;++j) {
				if(j>=v[i-1]&&(p[i-1]+Pri[i-1][j-v[i-1]]>Pri[i-1][j])) {
					Pri[i][j] = p[i-1]+Pri[i-1][j-v[i-1]];
					Rec[i][j] = 1;
				}else {
					Pri[i][j] = Pri[i-1][j];
					Rec[i][j] = 0;
				}
			}
		}
		for(int i = 0;i<=p.length;++i) {
			for(int j = 0;j<=c;++j) {
				System.out.print(Pri[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(Pri[p.length][c]);
		for(int i = 0;i<=p.length;++i) {
			for(int j = 0;j<=c;++j) {
				System.out.print(Rec[i][j]+"\t");
			}
			System.out.println();
		}
		for(int i = p.length;i>0;--i) {
			if(Rec[i][c]==1) {
				System.out.println("选择了商品"+i);
				c = c-v[i-1];
			}else {
				System.out.println("没有选择商品"+i);
			}
		}
		
	}

}
