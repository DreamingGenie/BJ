

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int answer=0;
	static int N;
	//static int K;
	static int M;
	static int[] item;
	public static void main(String[] args) throws IOException{
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			
			input();
			answer=solve();
			System.out.println(answer);
		}
	}
	public static void input() throws IOException{
		N=Integer.parseInt(br.readLine());
		//K=Integer.parseInt(st.nextToken());
		item=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			
			item[i]=Integer.parseInt(st.nextToken());
		}
		M=Integer.parseInt(br.readLine());
	}
	public static int solve() {
		int[] dp=new int[M+1];
		dp[0]=1;
		for(int i=1;i<=N;i++) {
			int coin=item[i-1];
			for(int w=coin;w<=M;w++) {
				dp[w]=dp[w]+dp[w-coin];
			}
		}
		return dp[M];
	}
}
