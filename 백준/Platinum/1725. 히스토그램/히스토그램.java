
import java.util.*;
import java.io.*;
public class Main {
	static int[] histo;
	static int[] tree;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		

		int N=Integer.parseInt(br.readLine());

		histo=new int[N];
		tree=new int[N*4];
		for(int i=0;i<N;i++) {
			histo[i]=Integer.parseInt(br.readLine());
		}
		
		init(1,0,N-1);
		
		long maxArea=getMaxArea(0,N-1,N);
		
		sb.append(maxArea).append("\n");
		
		System.out.println(sb);
		
	}
	static void init(int node, int start, int end) {
		if(start==end) {
			tree[node]=start;
			return;
		}
		
		int mid=(start+end)/2;
		init(node*2,start,mid);
		init(node*2+1,mid+1,end);
		if(histo[tree[node*2]]<=histo[tree[node*2+1]]) {
			tree[node]=tree[node*2];
		}
		else {
			tree[node]=tree[node*2+1];
		}
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
	        return -1; 
	    }
		if (left <= start && end <= right) {
	        return tree[node]; 
	    }
		int mid=(start+end)/2;
		int leftidx=query(node*2,start,mid,left,right);
		int rightidx=query(node*2+1,mid+1,end,left,right);
		
		if(leftidx==-1)
			return rightidx;
		if(rightidx==-1)
			return leftidx;
		
		if(histo[leftidx]<=histo[rightidx]) 
			return leftidx;
		else
			return rightidx;
		
	}
	
	static long getMaxArea(int left, int right, int N) {
		int min=query(1,0,N-1,left,right);
		
		long area=(long)(right-left+1)*histo[min];
		
		if(left<=min-1) {
			area=Math.max(area, getMaxArea(left,min-1,N));
		}
		if(right>=min+1) {
			area=Math.max(area,getMaxArea(min+1,right,N));
		}
		return area;
	}
}
