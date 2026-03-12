

import java.util.*;
import java.io.*;
public class Main {
	static final int INF=Integer.MAX_VALUE/100;
	static int V;
	static int E;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		input();
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(map[i][j]>map[i][k]+map[k][j])
						map[i][j]=map[i][k]+map[k][j];
				}
			}
		}
		int answer=INF;
		for(int i=1;i<=V;i++) {
			if(map[i][i]<answer){
				answer=map[i][i];
			}
		}
		if(answer==INF)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		map=new int[V+1][V+1];
		for(int i=1;i<=V;i++) {
			Arrays.fill(map[i],INF);
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			map[from][to]=cost;
		}
		
	}
}
