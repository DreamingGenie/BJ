
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int t;
	static int s;
	static int g;
	static int h;
	static int distGH = 0;
	static final int INF=Integer.MAX_VALUE/10;
	
	static int[] distG;
	static int[] distH;
	static int[] distS;
	static int[] candidate;
	static ArrayList<Edge>[] edgelist;
	static PriorityQueue<Integer> anslist;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		int T=Integer.parseInt(br.readLine());
		for(int testcase=1;testcase<=T;testcase++) {
			input();
			
			int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);
            distGH=distG[h];
			long min=INF;
			for(int i=0;i<t;i++) {
				long A=distS[g]+distH[candidate[i]]+distGH;
				long B=distS[h]+distG[candidate[i]]+distGH;
				
                long originalShortest = distS[candidate[i]];

                if (originalShortest != INF && (A == originalShortest || B == originalShortest)) {
                    anslist.add(candidate[i]);
                }
				
			}
			
			StringBuilder sb=new StringBuilder();
			while(!anslist.isEmpty())
			{
				sb.append(anslist.poll()).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
	public static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.cost > dist[current.to]) continue;

            for (Edge next : edgelist[current.to]) {
                if (dist[next.to] > dist[current.to] + next.cost) {
                    dist[next.to] = dist[current.to] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
	
	public static void input() throws IOException{
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		
		edgelist=new ArrayList[n+1];
		anslist=new PriorityQueue<>();
		for(int i=1;i<=n;i++) {
			edgelist[i]=new ArrayList<Edge>();
		}
		candidate=new int[t];
		distGH=0;
		st=new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		g=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());	
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			edgelist[from].add(new Edge(to,cost));
			edgelist[to].add(new Edge(from,cost));
			
		}
		for(int i=0;i<t;i++) {
			candidate[i]=Integer.parseInt(br.readLine());
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int to;
		int cost;
		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
		
		
	}
}
