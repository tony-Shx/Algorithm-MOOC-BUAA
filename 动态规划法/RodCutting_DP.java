package ��̬�滮��;
/**
 * �����������и����⣨���䶯̬�滮��
* @author tony_Shx
* @version ����ʱ�䣺2020��5��5�� ����8:31:34
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
		//���������
		for(int it:C) {
			System.out.print(it+"\t");
		}
		System.out.println("\n�������Ϊ��"+C[n]);
		System.out.print("�и��Ϊ��{");
		int index = n;
		while(Rec[index]<index) {
			System.out.print(Rec[index]+",");
			index = index-Rec[index];
		}
		System.out.println(Rec[index]+"}");
		
	}

}
