package 动态规划法;
/**
 * 动规求解最长公共子串问题（模式匹配问题）
* @author tony_Shx
* @version 创建时间：2020年5月5日 下午3:32:53
*/
public class LongestCommonSubString_DP {

	private static char X[] = {'A','B','C','A','D','B','B'};
	private static char Y[] = {'B','C','E','D','B','B'};
	private static int  D[][] = new int[X.length+1][Y.length+1];
	public static void main(String[] args) {
		int n = X.length;
		int m = Y.length;
		LongestCommonSubString(n,m);

	}
	private static void LongestCommonSubString(int n, int m) {
		for(int i = 0;i<=n;++i) {
			D[i][0] = 0;
		}
		for(int i = 0;i<=m;++i) {
			D[0][i] = 0;
		}
		int Pmax = 0,left = 0;
		for(int i = 1;i<=n;++i) {
			for(int j = 1;j<=m;++j) {
				if(X[i-1]==Y[j-1]) {
					D[i][j] = D[i-1][j-1]+1;
					if(D[i][j]>Pmax) {
						Pmax = D[i][j];
						left = i-Pmax;
					}
				}else {
					D[i][j] = 0;
				}
			}
		}
		//输出D[][]检查结果
		for(int i = 0;i<=n;++i) {
			for(int j = 0;j<=m;++j) {
				System.out.print(D[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("最长公共子串长度："+Pmax+"\n最长公共子串为：");
		for (int i = left; i < left+Pmax; i++) {
			System.out.print(X[i]);
			
		}
		System.out.println();
		
	}

}
