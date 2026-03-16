
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int n;
    static int total;
    static int[] parents;
    static PriorityQueue<Edge> pq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(input())
            solve();
    }
    public static void solve(){
        int answer=0;
        int selected=0;
        while(!pq.isEmpty()){
            Edge temp=pq.poll();
            int from=temp.from;
            int to=temp.to;
            int cost=temp.cost;
            if(find(from)!=find(to))
            {
                answer+=cost;
                union(from,to);
                selected++;
            }
            if(selected==m-1)
                break;
        }
        System.out.println(total-answer);
    }
    public static int find(int i){
        if(parents[i]==i){
            return i;
        }
        return find(parents[i]);
    }
    public static void union(int i, int j){
        int x=find(i);
        int y=find(j);
        if(x!=y){
            parents[y]=x;
        }
    }
    public static boolean input() throws IOException {
        String line = br.readLine();
        if (line == null) return false;

        StringTokenizer st = new StringTokenizer(line);
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        if(m==0&&n==0)
            return false;

        total=0;
        pq=new PriorityQueue<>();
        parents = new int[m];
        for(int i=0;i<m;i++){
            parents[i]=i;
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from,to,cost));
            total+=cost;
            //System.out.println(i+" "+from+" "+to+" "+cost);
        }
        return true;
    }
    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
