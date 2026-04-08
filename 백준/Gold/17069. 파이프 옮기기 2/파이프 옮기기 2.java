
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] map=new int[n][n];
		for(int y=0;y<n;y++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int x=0;x<n;x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
		long[][][] dp=new long[n][n][3];
		//0 : 가로, 1 : 세로, 2 : 대각
		dp[0][1][0]=1;
		for(int y=0;y<n;y++) {
			for(int x=1;x<n;x++) {
				if(x==1&&y==0||map[y][x]==1)
					continue;
				if(x-1>=0)
					dp[y][x][0]=dp[y][x-1][0]+dp[y][x-1][2];
				if(y-1>=0)
					dp[y][x][1]=dp[y-1][x][1]+dp[y-1][x][2];
				if (y - 1 >= 0 && x - 1 >= 0&&map[y - 1][x] == 0 && map[y][x - 1] == 0)
					dp[y][x][2]=dp[y-1][x-1][2]+dp[y-1][x-1][1]+dp[y-1][x-1][0];
				
			}
		}
		System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);
		
		
	}

}
