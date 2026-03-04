
import java.io.*;
import java.util.*;

public class Main {
	static int N,M,X;
	static int[] dist;
	static ArrayList<Edge>[] graph;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		int[] answer=new int[N+1];
		graph=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			graph[start].add(new Edge(end,weight));
		}
		for(int i=1;i<=N;i++) {
			PriorityQueue<Edge> pq=new PriorityQueue<>();
			dist=new int[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			pq.add(new Edge(i,0));
			dist[i]=0;
			while(!pq.isEmpty()) {
				Edge now=pq.poll();
				int to=now.to;
				int weight=now.weight;
				if(weight>dist[to])
					continue;
				for(Edge e:graph[to]) {
					int nto=e.to;
					int nweight=weight+e.weight;
					if(dist[nto]>nweight) {
						dist[nto]=nweight;
						pq.add(new Edge(nto,nweight));
					}
				}
			}
			//System.out.println(Arrays.toString(dist));
			if(i==X) {
				for(int d=1;d<=N;d++) {
					answer[d]+=dist[d];
				}
			}
			else {
				answer[i]+=dist[X];
			}
			
		}
		int max=0;
		for(int i=1;i<=N;i++)
			max=Math.max(max, answer[i]);
		System.out.println(max);
		
		
	}
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		public Edge(int to, int weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
	}
}
