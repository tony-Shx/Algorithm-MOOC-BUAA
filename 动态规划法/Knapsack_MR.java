package 动态规划法;

/**
 * 带备忘录的递归求解01背包问题
 * @author tony_Shx
 * @version 创建时间：2020年5月1日 下午5:48:13
 */
public class Knapsack_MR {

	private static int p[] = { 9, 10, 9, 2, 24 };
	private static int v[] = { 4, 5, 4, 3, 10 };
	private static int P[][];
	public static void main(String[] args) {
		int c = 13;
		P = new int[p.length][c+1];
		for (int i=0;i<p.length;++i) {
			for(int j = 0;j<c+1;++j) {
				P[i][j] = -1;
			}
		}
		int max = KnapsackMR(p.length-1,c);
		System.out.println(max);
		
	}
	private static int KnapsackMR(int i, int c) {
		if(c<0)
			return Integer.MIN_VALUE;
		if(i<0)
			return 0;
		if(P[i][c]!=-1)
			return P[i][c];
		int P1 = KnapsackMR(i-1, c-v[i])+p[i];
		int P2 = KnapsackMR(i-1, c);
		P[i][c] = Math.max(P1, P2);
		return P[i][c];
	}

}
