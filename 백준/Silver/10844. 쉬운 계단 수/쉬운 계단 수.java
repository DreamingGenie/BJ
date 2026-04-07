
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long[][] dp=new long[n+1][10];
		for(int i=1;i<=9;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][1]%1000000000;
			dp[i][9]=dp[i-1][8]%1000000000;
			for(int j=1;j<=8;j++) {
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			}
		}
		
		long answer=0L;
		for(int i=0;i<=9;i++) {
			answer+=dp[n][i];
			answer%=1000000000;
		}
		System.out.println(answer);
		
	}

}
