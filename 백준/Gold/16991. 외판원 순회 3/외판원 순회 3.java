
import java.io.*;
import java.util.*;

public class Main {
	static double[][] dp;
	static double[][] W;
	static int n;
	static final int MAX=Integer.MAX_VALUE/10;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		W=new double[n][n];
		dp=new double[n][1<<n];
		int[][] citys=new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			citys[i][0]=Integer.parseInt(st.nextToken());
			citys[i][1]=Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], -1);
		}
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<n;j++) {
				W[i][j]=Math.sqrt(Math.pow((citys[j][1]-citys[i][1]),2)+Math.pow((citys[j][0]-citys[i][0]),2));				
				W[j][i]=Math.sqrt(Math.pow((citys[j][1]-citys[i][1]),2)+Math.pow((citys[j][0]-citys[i][0]),2));
			}
		}
		System.out.println(solve(0,1<<0));
	}
	public static double solve(int now, int visited) {
		if(visited==(1<<n)-1) {
			if(W[now][0]==0)
				return MAX;
			return W[now][0];
		}
		if(dp[now][visited]!=-1)
			return dp[now][visited];
		
		dp[now][visited]=MAX;
		for(int next=0;next<n;next++) {
			if((visited&(1<<next))==0&&W[now][next]!=0) {//방문한 적 없고 && 갈 수 있으면
				dp[now][visited]=Math.min(dp[now][visited], solve(next,visited|(1<<next))+W[now][next]);
			}
		}
		
		return dp[now][visited];
	}
}
