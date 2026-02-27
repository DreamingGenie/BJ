import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static PriorityQueue<Edge> edgelist=new PriorityQueue<>();
	static int N;
	static int E;
	static int[] parent;
	static double answer=0;
	static double[][] star;
	public static void main(String[] args) throws IOException{
		input();
		makeedge();
		solve();
		System.out.printf("%.2f\n", answer);
	}
	public static void solve() {
		int edgeCount = 0;
		while(!edgelist.isEmpty()) {
			Edge temp=edgelist.poll();
			int l=temp.dotA;
			int r=temp.dotB;
			int lparent=find(l);
			int rparent=find(r);
			if(lparent==rparent)
				continue;
			else {
				answer+=temp.value;
				parent[lparent]=rparent;
				edgeCount++;
			}
			if(edgeCount==N-1)
				break;
		}
		
	}
	public static void makeedge() {
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				int A=i;
				int B=j;
				double value=Math.sqrt(Math.pow(star[A][0]-star[B][0],2)+Math.pow(star[A][1]- star[B][1],2));
				edgelist.add(new Edge(A,B,value));
				
			}
		}
	}
	public static int find(int A) {
		if(parent[A]==A)
			return A;
		return parent[A]=find(parent[A]);
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		star=new double[N+1][2];
		parent=new int[N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			star[i][0]=Double.parseDouble(st.nextToken());
			star[i][1]=Double.parseDouble(st.nextToken());
			parent[i]=i;
		}
		
//		for(int i=0;i<E;i++) {
//			st=new StringTokenizer(br.readLine());
//			int A=Integer.parseInt(st.nextToken());
//			int B=Integer.parseInt(st.nextToken());
//			int val=Integer.parseInt(st.nextToken());
//			edgelist.add(new Edge(A,B,val));
//		}
	}
	
	static class Edge implements Comparable<Edge>{
		int dotA;
		int dotB;
		double value;
		public Edge(int A, int B, double val) {
			dotA=A;
			dotB=B;
			value=val;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Double.compare(this.value, other.value);
		}

	}
}
