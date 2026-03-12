import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static int[][] busMap;
	static long[] dist;
	static final int INF=Integer.MAX_VALUE/100;
	static Edge[] Earr;
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		busMap=new int[N+1][N+1];
		dist=new long[N+1];
		Earr=new Edge[M+1];
		Arrays.fill(dist, INF);
		dist[1]=0;
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			Earr[i]=new Edge(from,to,cost);
		}
	}
	public static void solve() {
		for(int n=0;n<N-1;n++) {
			for(int m=0;m<M;m++) {
				Edge temp=Earr[m];
				int from=temp.from;
				int to=temp.to;
				int cost=temp.cost;
				if(dist[from]==INF)
					continue;
				if(dist[from]+cost<dist[to])
					dist[to]=dist[from]+cost;
			}
		}
		boolean negative=false;
		for(int m=0;m<M;m++) {
			Edge temp=Earr[m];
			int from=temp.from;
			int to=temp.to;
			int cost=temp.cost;
			if(dist[from]==INF)
				continue;
			if(dist[from]+cost<dist[to])
				negative=true;
		}
		
		StringBuilder sb=new StringBuilder();
		if(negative)
			sb.append(-1).append("\n");
		else
		{
			for(int i=2;i<=N;i++)
				if(dist[i]==INF)
					sb.append(-1).append("\n");
				else
					sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	static class Edge{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
	}
}
