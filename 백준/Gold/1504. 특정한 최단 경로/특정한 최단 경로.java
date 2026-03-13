

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	static int N;
	static int E;
	static int[][] map;
	static int[] dist;
	static final int INF=Integer.MAX_VALUE/100;
	
	static PriorityQueue<Edge> pq;
	static int v1;
	static int v2;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
		int answer=Math.min(dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,N),
				dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,N));
		
		if(answer>=INF)
			System.out.println(-1);
		else
			System.out.println(answer);
		
	}
	public static int dijkstra(int start, int end) {
		dist=new int[N+1];
		Arrays.fill(dist, INF);
		pq=new PriorityQueue<>();
		
		dist[start]=0;
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge temp=pq.poll();
			int now=temp.to;
			if(now==end)
				return temp.cost;
			for(int i=1;i<=N;i++) {
				if(map[now][i]==0)
					continue;
				int nto=i;
				int ncost=temp.cost+map[now][i];
				if(dist[nto]>ncost) {
					dist[nto]=ncost;
					pq.add(new Edge(nto,ncost));
					
				}
				
			}
		}
		return INF;
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][N+1];
		
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			map[from][to]=cost;
			map[to][from]=cost;
			//students[to][from]=-1;
		}
		st=new StringTokenizer(br.readLine());
		v1=Integer.parseInt(st.nextToken());
		v2=Integer.parseInt(st.nextToken());
	}
	
	static class Edge implements Comparable<Edge>{
		//int from;
		int to;
		int cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge e) {
			return cost-e.cost;
		}
	}

}
