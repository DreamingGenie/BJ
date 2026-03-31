
import java.util.*;
import java.io.*;
public class Main{
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=1;i<N+1;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp=new int[N+1][N+1];
		dp();
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			sb.append(dp[L][R]).append("\n");
		}
		System.out.println(sb);
	}
	public static void dp() {
		for(int i=1;i<N+1;i++) {
			dp[i][i]=1;
		}
		for(int i=1;i<N;i++) {
			if(arr[i]==arr[i+1])
				dp[i][i+1]=1;
		}
		for(int len=3;len<=N;len++) {
			for(int j=1;j<=N-len+1;j++) {
				if(arr[j]==arr[j+len-1]&&dp[j+1][j+len-2]==1)
					dp[j][j+len-1]=1;
			}
		}
	}
}
