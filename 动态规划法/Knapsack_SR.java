package 动态规划法;

/**
 * 蛮力枚举递归求解01背包问题
 * @author tony_Shx
 * @version 创建时间：2020年5月1日 下午5:48:13
 */
public class Knapsack_SR {

	private static int p[] = { 9, 10, 9, 2, 24 };
	private static int v[] = { 4, 5, 4, 3, 10 };
	public static void main(String[] args) {
		int c = 13;
		int max = KnapsackSR(p.length-1,c);
		System.out.println(max);
		
	}
	private static int KnapsackSR(int i, int c) {
		if(c<0)
			return Integer.MIN_VALUE;
		if(i<0)
			return 0;
		int P1 = KnapsackSR(i-1, c-v[i])+p[i];
		int P2 = KnapsackSR(i-1, c);
		int P = Math.max(P1, P2);
		return P;
	}

}
