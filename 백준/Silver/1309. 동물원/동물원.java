
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] dp=new int[n+1][3];
		dp[1][0]=1;
		dp[1][1]=1;
		dp[1][2]=1;
		//0 : 왼쪽, 1 : 오른쪽, 2 : 안 놓음
		for(int i=2;i<=n;i++) {
			dp[i][0]=(dp[i-1][1]+dp[i-1][2])%9901;
			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
			dp[i][2]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
		}
		System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%9901);
		
	}
}
