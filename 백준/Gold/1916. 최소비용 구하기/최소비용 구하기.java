import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dist;
    static int start;
    static int end;
    static ArrayList<Edge>[] adj;

    static final int INF=Integer.MAX_VALUE/10;
    public static void main(String[] args) throws Exception{
        input();
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Edge temp=pq.poll();
            int now=temp.to;
            int cost=temp.cost;

            if(cost>dist[now]) continue;

            for (Edge next : adj[now]) {
                if (dist[next.to] > dist[now] + next.cost) {
                    dist[next.to] = dist[now] + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
        System.out.println(dist[end]);
    }
    public static void input() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        dist=new int[N+1];
        Arrays.fill(dist,INF);

        StringTokenizer st;
        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, cost));

        }
        st=new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
    public static class Edge implements Comparable<Edge>{
        int to;
        int cost;
        public Edge(int to, int cost){
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }
}
