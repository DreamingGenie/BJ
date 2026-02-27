

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static PriorityQueue<Edge> edgelist=new PriorityQueue<>();
	static int N;
	static int M;
	static Long K;
	static int[] cost;
	static boolean[] block;
	static Long answer=0L;
	
	public static void main(String[] args) throws IOException{
		input();
		if(M<=1)
		{
			System.out.println("YES");
			return;
		}
		solve();
		//System.out.println(answer);

		if(answer<=K)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	public static void solve() {
		int currentMin=Integer.MAX_VALUE;
		int firstMin=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			currentMin=Math.min(currentMin,cost[i]);
			if(block[i]) {
				answer+=currentMin;
				if(firstMin==Integer.MAX_VALUE)
					firstMin=currentMin;
				currentMin=Integer.MAX_VALUE;
			}
		}
		if(!block[N]) {
			answer=answer-firstMin+Math.min(currentMin, firstMin);
		}
	}


	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Long.parseLong(st.nextToken());
		cost=new int[N+1];
		block=new boolean[N+1];

	    st = new StringTokenizer(br.readLine());
	    for (int i = 1; i <= N; i++) {
	        if (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine()); 
	        cost[i] = Integer.parseInt(st.nextToken());
	    }

	    for (int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int u = Integer.parseInt(st.nextToken());
	        int v = Integer.parseInt(st.nextToken());
	        
	        if ((u == 1 && v == N) || (u == N && v == 1)) {
	            block[N] = true;
	        } else {
	            block[Math.min(u, v)] = true;
	        }
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
