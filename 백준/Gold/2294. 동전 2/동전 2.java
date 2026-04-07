
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] dp=new int[k+1];
		int max=Integer.MAX_VALUE/10;
		Arrays.fill(dp, max);
		int[] coins=new int[n+1];
		for(int i=1;i<=n;i++) {
			coins[i]=Integer.parseInt(br.readLine());
			if(coins[i]<=k)
				dp[coins[i]]=1;
		}
		for(int i=1;i<=k;i++) {
			if(dp[i]==max)
				continue;
			for(int j=1;j<=n;j++) {
				if((i+coins[j])>k)
					continue;
				dp[i+coins[j]]=Math.min(dp[i+coins[j]], dp[i]+1);
			}
		}
		
		if(dp[k]==max) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[k]);
		}
		
	}
}
