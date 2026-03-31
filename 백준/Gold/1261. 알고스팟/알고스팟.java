import java.util.*;
import java.io.*;

public class Main {
	static int m;
	static int n;
	static final int INF=Integer.MAX_VALUE/10;
	
	static int[][] map;
	static int[][] dist;
	
	public static void main(String[] args)throws IOException{
		input();
		dijkstra();
	}
	public static void dijkstra() {
		int[] dx= {1,-1,0,0};
		int[] dy= {0,0,1,-1};
		
		PriorityQueue<Edge> pq=new PriorityQueue<>();
		pq.add(new Edge(0,0,0));
		dist[0][0]=0;
		while(!pq.isEmpty()) {
			Edge temp=pq.poll();
			if(temp.x==n-1&&temp.y==m-1)
				break;
			if(temp.cost>dist[temp.y][temp.x])
				continue;
			for(int d=0;d<4;d++) {
				int nx=temp.x+dx[d];
				int ny=temp.y+dy[d];
				if(!isValid(nx,ny))
					continue;
				
				int ncost=dist[temp.y][temp.x]+map[ny][nx];
				
				if(dist[ny][nx]>ncost) {
					dist[ny][nx]=ncost;
					pq.add(new Edge(nx,ny,ncost));
				}
			}
			
		}
		System.out.println(dist[m-1][n-1]);
	}
	public static boolean isValid(int x, int y) {
		return(x>=0&&y>=0&&x<n&&y<m);
	}
	public static void input()throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[m][n];
		dist=new int[m][n];
		for(int j=0;j<m;j++) {
			Arrays.fill(dist[j],INF);
		}
		for(int i=0;i<m;i++) {
			char[] line=br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j]=line[j]-'0';
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int cost;
		
		public Edge(int x, int y, int cost) {
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost-o.cost;
		}
	}

}
