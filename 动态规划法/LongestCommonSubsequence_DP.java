package 动态规划法;


/**
 * 动规求解两个序列的最长公共子序列（非模式匹配）
* @author tony_Shx
* @version 创建时间：2020年5月4日 下午5:38:38
*/
public class LongestCommonSubsequence_DP {

	public static void main(String[] args) {
		char X[] = {'A','B','C','B','D','A','B'};
		char Y[] = {'B','D','C','A','B','A'};
		int C[][] = new int[X.length+1][Y.length+1];
		int Rec[][] = new int[X.length][Y.length];
		for(int i = 0;i<=X.length;++i) {
			C[i][0] = 0;
		}
		for(int i = 0;i<=Y.length;++i) {
			C[0][i] = 0;
		}
		LongestCommonSubsequence(X,Y,C,Rec,X.length,Y.length);

	}

	private static void LongestCommonSubsequence(char[] X, char[] Y, int[][] C, int[][] Rec, int length1, int length2) {
		for(int i = 0;i<length1;++i) {
			for(int j = 0;j<length2;++j) {
				if(X[i]==Y[j]) {
					C[i+1][j+1] = C[i][j]+1;
					Rec[i][j] = 0;
				}else {
					if(C[i][j+1]>=C[i+1][j]) {
						C[i+1][j+1] = C[i][j+1];
						Rec[i][j] = 1;
					}else {
						C[i+1][j+1] = C[i+1][j];
						Rec[i][j] = -1;
					}
				}
			}
		}
		//输出查看结果
		for(int i = 0;i<=length1;++i) {
			for(int j = 0;j<=length2;++j) {
				System.out.print(C[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i = 0;i<length1;++i) {
			for(int j = 0;j<length2;++j) {
				System.out.print(Rec[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("最长公共子序列长度："+C[length1][length2]);
		char[] resStr = new char[C[length1][length2]];
		PrintLCS(X,Rec,resStr,length1-1,length2-1,resStr.length-1);
		System.out.println("公共子序列为:"+String.copyValueOf(resStr));
	}

	private static void PrintLCS(char[] X,int[][] rec, char[] resStr, int i, int j,int k) {
		if(i<0||j<0) {
			return ;
		}
		if(rec[i][j]==0) {
			resStr[k] = X[i];
			PrintLCS(X, rec, resStr, i-1, j-1, k-1);
		}else if(rec[i][j]==1) {
			PrintLCS(X, rec, resStr, i-1, j, k);
		}else {
			PrintLCS(X, rec, resStr, i, j-1, k);
		}
	}

}
