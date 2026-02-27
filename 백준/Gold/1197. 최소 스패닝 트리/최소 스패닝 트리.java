
import java.io.*;
import java.util.*;

public class Main {
	static PriorityQueue<Edge> edgelist=new PriorityQueue<>();
	static int V;
	static int E;
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
			if(edgeCount==V-1)
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
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		parent=new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i]=i;
		}
		for(int i=0;i<E;i++) {
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
