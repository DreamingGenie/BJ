
import java.io.*;
import java.util.*;

public class Main {
	static final int MAX=Integer.MAX_VALUE/10;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] matrix=new int[n+1][2];
		int[][] dp=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			matrix[i][0]=Integer.parseInt(st.nextToken());
			matrix[i][1]=Integer.parseInt(st.nextToken());
			
		}
		
		for(int length=2;length<=n;length++) {
			for(int start=1;start<=n-length+1;start++) {
				int end=start+length-1;
				dp[start][end]=MAX;
				for(int middle=start;middle<end;middle++) {
					int cost=dp[start][middle]+dp[middle+1][end]
							+(matrix[start][0] * matrix[middle][1] * matrix[end][1]);
					dp[start][end]=Math.min(dp[start][end], cost);
				}
			}
		}
		System.out.println(dp[1][n]);
	}
}
