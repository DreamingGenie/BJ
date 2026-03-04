
import java.util.*;
import java.io.*;

public class Main {
	static int V,E,goal;
	static int[] dist;
	static ArrayList<Edge>[] graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		goal=Integer.parseInt(br.readLine());
		graph=new ArrayList[V+1];
		dist=new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0;i<=V;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			graph[start].add(new Edge(end,value));
		}
		PriorityQueue<Edge> pq=new PriorityQueue<>();

		dist[goal]=0;
		pq.add(new Edge(goal, 0));
		while(!pq.isEmpty()) {
			Edge start=pq.poll();
			int now = start.to;
		    int weight = start.weight;
		    
		    if (dist[now] < weight) continue;
			for(Edge e:graph[now]) {
				int nto=e.to;
				int nweight=e.weight+weight;
				
				if(dist[nto]>nweight) {
					dist[nto]=nweight;
					pq.add(new Edge(nto,nweight));
				}
			}
	
		}
		for(int i=1;i<=V;i++) {
			if(dist[i]!=Integer.MAX_VALUE)
				System.out.println(dist[i]);
			else
				System.out.println("INF");
		}
		
	}
	static class Edge implements Comparable<Edge> {
	    int to;
	    int weight;

	    public Edge(int to, int weight) {
	        this.to = to;
	        this.weight = weight;
	    }

	    @Override
	    public int compareTo(Edge o) {
	        return this.weight - o.weight; 
	    }
	}
}
