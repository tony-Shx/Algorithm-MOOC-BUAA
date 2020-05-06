package 动态规划法;
/**
 * 动规求解最短矩阵链乘长度
* @author tony_Shx
* @version 创建时间：2020年5月6日 下午8:37:06
*/
public class MatrixChainMultiply_DP {

	private static int p[] = {2,3,7,9,5,2,4};
	private static int n = p.length-1;
	public static void main(String[] args) {
		int D[][] = new int[n][n];
		int Rec[][] = new int[n][n];
		MatrixChainMultiply(D,Rec,n);

	}
	private static void MatrixChainMultiply(int[][] D, int[][] Rec,int n) {
		for(int i = 0;i<n;++i) {
			D[i][i] = 0;
			Rec[i][i] = i;
		}
		int k,min = Integer.MAX_VALUE;
		for(int i = 1;i<n;++i) {
			for(int j = 0;j<n-i;++j) {
				k = j+i;
				for(int l = j;l<k;++l) {
					int price = D[j][l]+D[l+1][k]+p[j]*p[l+1]*p[k+1];
					if(price<min) {
						min = price;
						D[j][k] = min;
						Rec[j][k] = l+1;
					}
				}
				min = Integer.MAX_VALUE;
			}
		}
		//输出检验结果
		for(int i = 0;i<n;++i) {
			for(int j = 0;j<n;++j) {
				if(i<=j) {
					System.out.print(D[i][j]+"\t");
				}else {
					System.out.print("  "+"\t");
				}
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		for(int i = 0;i<n;++i) {
			for(int j = 0;j<n;++j) {
				if(i<=j) {
					System.out.print(Rec[i][j]+"\t");
				}else {
					System.out.print("  "+"\t");
				}
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
		System.out.print("最短矩阵链乘长度为："+D[0][n-1]+"\n方案为：");
		PrintMatrixChain(Rec,0,n-1);
		
	}
	private static void PrintMatrixChain(int[][] Rec, int i, int j) {
		if(i==j) {
			System.out.print("U"+i);
			return ;
		}
		int k = Rec[i][j]-1;
		if(i!=k) {
			System.out.print("(");			
		}
		PrintMatrixChain(Rec, i, k);
		if(i!=k) {
			System.out.print(")");
		}
		System.out.print("*");
		if(k+1!=j) {
			System.out.print("(");			
		}
		PrintMatrixChain(Rec, k+1, j);
		if(k+1!=j) {
			System.out.print(")");			
		}
		
	}

}
