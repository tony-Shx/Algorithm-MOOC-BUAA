package 贪心法;


/**
 * 贪心策略求解部分背包问题
* @author tony_Shx
* @version 创建时间：2020年5月6日 下午10:23:02
*/
public class FractionalKnapsack_greed {

	private static int p[] = {60,10,36,16,45};
	private static int v[] = {600,250,200,100,300};
	public static void main(String[] args) {
		int n = p.length;
		int C = 800;
		float Ratio[] = new float[n];
		for(int i = 0;i<n;++i) {
			Ratio[i] = (float) ((p[i]+0.0)/v[i]);
		}
		int max_index;
		//简单选择排序
		for(int i = 0;i<n-1;++i) {
			max_index = i;
			for(int j = i+1;j<n;++j) {
				if(Ratio[j]>Ratio[max_index]) {
					max_index = j;
				}
			}
			if(max_index!=i) {
				float temp = Ratio[i];
				Ratio[i] = Ratio[max_index];
				Ratio[max_index] = temp;
				int t = p[i];
				p[i] = p[max_index];
				p[max_index] = t;
				t = v[i];
				v[i] = v[max_index];
				v[max_index] = t;
			}
		}
		FractionalKnapsack(Ratio,n,C);
	}
	private static void FractionalKnapsack(float[] Ratio, int n,int C) {
		float ans = 0;
		int i=0;
		while(C>0&&i<n) {
			if(v[i]<C) {
				ans = ans+p[i];
				C = C-v[i];
			}else {
				ans = ans +p[i]*C/v[i];
				C = 0;
			}
			i++;
		}
		System.out.println(ans);
		
	}

}
