
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static long[] lazy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N + 1];
        tree=new long[N*4];
        lazy=new long[N*4];
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        init(1,1,N);
        
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 1: 변경, 2: 구간 합
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
            	long d=Long.parseLong(st.nextToken());
                updateRange(1,1,N,b,c,d);
            } else if (a == 2) {
            	sb.append(query(1,1,N,b,(int)c)).append("\n");
            }
            
        }
        System.out.print(sb);
    }
    
    // 지연 처리
    static void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }
    
    public static void init(int node, int start, int end) {
    	if(start==end) {
    		tree[node]=nums[start];
    		return;
    	}
    	
    	int mid=(start+end)/2;
    	init(node*2,start,mid);
    	init(node*2+1,mid+1,end);
    	
    	tree[node]=tree[node*2]+tree[node*2+1];
    }
    
    public static void updateRange(int node, int start, int end, int left, int right, long diff) {
    	propagate(node, start, end);
    	
    	if (left > end || right < start) return;

    	if (left <= start && end <= right) {
            lazy[node] += diff;
            propagate(node, start, end);
            return;
        }
        
    	int mid=(start+end)/2;
    	updateRange(node * 2, start, mid, left, right, diff);
        updateRange(node * 2 + 1, mid + 1, end, left, right, diff);
    	
    	tree[node]=tree[node*2]+tree[node*2+1];
    }
    public static long query(int node, int start, int end,int left, int right) {
    	propagate(node, start, end);
    	
    	if(left>end||right<start) {
    		return 0;
    	}
    	if (left <= start && end <= right) {
            return tree[node]; 
        }
    	int mid=(start+end)/2;
    	long leftsum=query(node*2,start,mid,left,right);
    	long rightsum=query(node*2+1,mid+1,end,left,right);
    	
    	return leftsum+rightsum;
    }
}