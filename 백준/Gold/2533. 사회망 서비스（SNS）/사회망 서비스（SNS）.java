
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] head=new int[N+1];
        int[] next=new int[2*N];
        int[] to=new int[2*N];
        int edgeCount=0;

        for(int i=0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            to[++edgeCount] = v;
            next[edgeCount] = head[u];
            head[u] = edgeCount;

            to[++edgeCount] = u;
            next[edgeCount] = head[v];
            head[v] = edgeCount;
        }
        int[] order=new int[N+1];
        int[] parent = new int[N+1];
        boolean[] visited=new boolean[N+1];
        int index=0;

        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        visited[1]=true;
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            order[index++]=curr;
            for(int i=head[curr];i!=0;i=next[i]){
                int neighbor=to[i];
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.add(neighbor);
                    parent[neighbor]=curr;
                }
            }
        }
        //dp 시작
        int[][] dp=new int[N+1][2];
        for(int i=N-1;i>=0;i--){
            int curr=order[i];
            dp[curr][1]=1;
            dp[curr][0]=0;
            for(int j=head[curr];j!=0;j=next[j]){
                int v=to[j];
                if(v==parent[curr])
                    continue;

                dp[curr][0]+=dp[v][1];
                dp[curr][1]+=Math.min(dp[v][0],dp[v][1]);
            }
        }
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
}
