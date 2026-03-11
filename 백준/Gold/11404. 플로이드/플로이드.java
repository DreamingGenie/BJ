

import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static int n;
	static int m;
	static final int MAXVAL=Integer.MAX_VALUE/100;
	public static void main(String[] args) throws IOException{
		input();
		solve();
		print();
	}
	static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		map=new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			Arrays.fill(map[i],MAXVAL);
			map[i][i]=0;
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			if(map[from][to]>cost)
				map[from][to]=cost;
		}
	}
	static void print() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==MAXVAL)
					System.out.print("0 ");
				else
					System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void solve() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					continue;
				for(int k=1;k<=n;k++) {
					if(i==k)
						continue;
					map[j][k]=Math.min(map[j][k], map[j][i]+map[i][k]);
				}
			}
		}
	}
}
