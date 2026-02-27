
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main{
	static PriorityQueue<Edge> edgelist=new PriorityQueue<>();
	static int N;
	static int M;
	static int[] parent;
	static int answer=0;
	public static void main(String[] args) throws IOException{
		input();
		solve();
		System.out.println(answer);
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
	public static int find(int A) {
		if(parent[A]==A)
			return A;
		return parent[A]=find(parent[A]);
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			int val=Integer.parseInt(st.nextToken());
			edgelist.add(new Edge(A,B,val));
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int dotA;
		int dotB;
		int value;
		public Edge(int A, int B, int val) {
			dotA=A;
			dotB=B;
			value=val;
		}
		
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.value, other.value);
		}

	}
}
