package ��̬�滮��;
/**
 * ���������̱༭��������
* @author tony_Shx
* @version ����ʱ�䣺2020��5��5�� ����3:52:13
*/
public class MinimumEditDistance_DP {
	
	//private static char s[] = {'A','B','C','B','D','A','B'};
	//private static char t[] = {'B','D','C','A','B','A'};
	private static char s[] = {'K','I','T','T','C','H','E','N'};
	private static char t[] = {'S','I','T','T','I','N','G'};
	private static int D[][] = new int[s.length+1][t.length+1];
	private static int Rec[][] = new int[s.length+1][t.length+1];
	private static int count = 1;
	public static void main(String[] args) {
		int n = s.length;
		int m = t.length;
		MinimumEditDistance(n,m);
		

	}
	private static void MinimumEditDistance(int n, int m) {
		for (int i = 0; i <= n; i++) {
			D[i][0] = i;//��Ӧɾ��
			Rec[i][0] = 1;
		}
		for (int i = 0; i <= m; i++) {
			D[0][i] = i;//��Ӧ����
			Rec[0][i] = -1;
		}
		int c;
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j<=m; j++) {
				if(s[i-1]==t[j-1]) {
					c = 0;					
				}else {
					c = 1;					
				}
				 if((D[i][j-1]+1<(D[i-1][j-1]+c))&&D[i][j-1]<=D[i-1][j]) {
					D[i][j] = D[i][j-1]+1;
					Rec[i][j] = -1; //��Ӧɾ������
				}else if((D[i-1][j]+1<(D[i-1][j-1]+c))&&D[i-1][j]<=D[i][j-1]) {
					D[i][j] = D[i-1][j]+1;
					Rec[i][j] = 1; //��Ӧ�������
				}else{
					D[i][j] = D[i-1][j-1]+c;
					Rec[i][j] = 0; //��Ӧ�滻����
				}
			}
		}
		//����������
		for (int i = 0; i <= n; i++) {
			for(int j = 0; j<=m; j++) {
				System.out.print(D[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i <= n; i++) {
			for(int j = 0; j<=m; j++) {
				System.out.print(Rec[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("��̱༭����Ϊ��"+D[n][m]);
		System.out.println("����༭�������£�");
		PrintMed(n,m);
	}
	private static void PrintMed(int n, int m) {
		if(n<1||m<0) {
			return ;
		}
		if(Rec[n][m]==1) {
			PrintMed(n-1, m);
			System.out.println((count++)+". ɾ��Ԫ�أ�"+s[n-1]);
		}else if(Rec[n][m]==-1) {
			PrintMed(n, m-1);
			System.out.println((count++)+". ����Ԫ��:"+t[m-1]);
		}else {
			PrintMed(n-1, m-1);
			if(s[n-1]!=t[m-1]) {
				System.out.println((count++)+". �滻Ԫ��:"+s[n-1]+"��Ϊ"+t[m-1]);				
			}else {
				System.out.println((count++)+". �ֿ�");
			}
			
		}
		
	}

}
