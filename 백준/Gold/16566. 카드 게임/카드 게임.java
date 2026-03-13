import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int K;
	
	static int[] cardArr;
	static int[] iron;
	
	static int[] tree;
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		cardArr=new int[M];
		iron=new int[K];
		tree=new int[M*4];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			cardArr[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			iron[i]=Integer.parseInt(st.nextToken());
		}
		
	}
	static void solve() {
		Arrays.sort(cardArr);
		buildSegment(1,0, M-1);
		for(int i=0;i<K;i++) {
			int target=iron[i];
			int targetidx=getTargetidx(target);
			int resultidx=find(1,0,M-1,targetidx,target);
			System.out.println(cardArr[resultidx]);
			
			update(1,0,M-1,resultidx,0);
			
		}
	}
	static int buildSegment(int node, int start, int end) {
		if(start==end)
			return tree[node]=cardArr[start];
		int mid=(start+end)/2;
		return tree[node]=Math.max(buildSegment(node*2,start,mid),
				buildSegment(node*2+1,mid+1,end));
	}
	
	static int find(int node, int start, int end, int targetIdx, int X) {
	    // 현재 노드의 구간 최댓값이 X보다 작거나, 탐색 범위를 벗어나면 가망 없음
	    if (tree[node] <= X || end < targetIdx) return -1;

	    if (start == end) return start;

	    int mid = (start + end) / 2;
	    int result = find(node * 2, start, mid, targetIdx, X);
	    
	    if (result == -1) {
	        result = find(node * 2 + 1, mid + 1, end, targetIdx, X);
	    }
	    
	    return result;
	}
	static int update(int node, int start, int end, int targetIdx, int X) {
		if(start>targetIdx||targetIdx>end)
			return tree[node];
		if(start==end) 
			return tree[node]=X;
		
		int mid=(start+end)/2;
		
		return tree[node] = Math.max(update(node * 2, start, mid, targetIdx, X), 
                update(node * 2 + 1, mid + 1, end, targetIdx, X));
		
	}
	static int getTargetidx(int X) {
		int start=0;
		int end=M-1;
		int res=M;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(cardArr[mid]>X) {
				res=mid;
				end=mid-1;
			}
			else
				start=mid+1;
		}
		return res;
		
	}

}
