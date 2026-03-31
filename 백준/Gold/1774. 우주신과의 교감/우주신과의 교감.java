
import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static PriorityQueue<Edge> pq=new PriorityQueue<>();
	static int[] lineX;
	static int[] lineY;
	static int[] parents;
	public static void main(String[] args) throws IOException{
		input();
		int count=0;
		double answer=0;
		while(!pq.isEmpty()) {
			Edge temp=pq.poll();
			int X=temp.x;
			int Y=temp.y;
			if(find(X)!=find(Y)) {
				union(X,Y);
				answer+=temp.cost;
			}
		}
		System.out.printf("%.2f",Math.round(answer*100)/100.0);
	}
	public static int find(int i) {
		if(parents[i]==i)
			return i;

			return find(parents[i]);
	}
	public static void union(int i, int j) {
		int X=find(i);
		int Y=find(j);
		if(X!=Y)
			parents[Y]=X;
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		lineX=new int[N+1];
		lineY=new int[N+1];
		parents=new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			lineX[i]=Integer.parseInt(st.nextToken());
			lineY[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			pq.add(new Edge(from,to,0));
		}
		for(int i=1;i<=N;i++) {
			int fromX=lineX[i];
			int fromY=lineY[i];
			for(int j=i+1;j<=N;j++) {
				int toX=lineX[j];
				int toY=lineY[j];
				
				double cost=Math.sqrt((double)Math.pow(Math.abs(fromX-toX), 2)+((Math.pow(Math.abs(fromY-toY), 2))));
				pq.add(new Edge(i,j,cost));
			}
			
		}
	}
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		double cost;
		public Edge(int X, int Y, double Cost) {
			this.x=X;
			this.y=Y;
			this.cost=Cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
}
