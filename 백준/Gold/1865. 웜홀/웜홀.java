
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int M;
	static int W;
	static long[] dist;
	static final int INF=Integer.MAX_VALUE/100;
	static Edge[] Earr;
	static int edgeSize;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			input();
			solve();
		}
	}
	public static void solve() {
		Arrays.fill(dist, 0);
		int totalEdges = M * 2 + W; 
	    for(int i = 0; i < N - 1; i++) {
	        for(int j = 0; j < totalEdges; j++) {
	            Edge temp = Earr[j];
	            if(dist[temp.from] + temp.cost < dist[temp.to])
	                dist[temp.to] = dist[temp.from] + temp.cost;
	        }
	    }

	    boolean negative = false;
	    for(int j = 0; j < totalEdges; j++) {
	        Edge temp = Earr[j];
	        if(dist[temp.from] + temp.cost < dist[temp.to]) {
	            negative = true;
	            break;
	        }
	    }
		if(negative) {
			System.out.println("YES");
		
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static void input() throws IOException{
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		dist=new long[N+1];
		Arrays.fill(dist, INF);
		dist[1]=0;
		
		Earr = new Edge[M * 2 + W];
		int edgeCount = 0;

		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int from = Integer.parseInt(st.nextToken());
		    int to = Integer.parseInt(st.nextToken());
		    int cost = Integer.parseInt(st.nextToken());
		    Earr[edgeCount++] = new Edge(from, to, cost);
		    Earr[edgeCount++] = new Edge(to, from, cost);
		}

		for (int i = 0; i < W; i++) {
		    st = new StringTokenizer(br.readLine());
		    int from = Integer.parseInt(st.nextToken());
		    int to = Integer.parseInt(st.nextToken());
		    int cost = Integer.parseInt(st.nextToken());
		    Earr[edgeCount++] = new Edge(from, to, -cost);
		}
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
