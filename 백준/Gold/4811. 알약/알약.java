
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		long[][] dp=new long[32][32];
		for(int i=0;i<31;i++) {
			dp[0][i]=1;
		}
		for(int w=1;w<=30;w++) {
			for(int h=0;h<=30;h++) {
				if(h==0) {
					dp[w][h]=dp[w-1][h+1];
				}
				else {
					dp[w][h]=dp[w-1][h+1]+dp[w][h-1];
				}
				
			}
		}
		while(true) {
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				break;
			System.out.println(dp[n][0]);
			
		}
		
	}

}
