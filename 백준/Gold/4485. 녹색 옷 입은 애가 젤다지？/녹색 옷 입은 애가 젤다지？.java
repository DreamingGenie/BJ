

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int min=Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dist;
    public static void main(String[] args) throws Exception{
        int i=1;
        while(input()){
            escape();
            System.out.println("Problem "+i+": "+dist[N-1][N-1]);
            i++;
        }
    }
    public static boolean input() throws Exception{
        N=Integer.parseInt(br.readLine());
        if(N==0)return false;
        map=new int[N][N];
        dist=new int[N][N];
        min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j]=(Integer.parseInt(st.nextToken()));
            }
        }
        return true;
    }
    static void escape(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int[] r : dist) Arrays.fill(r, Integer.MAX_VALUE);
        pq.offer(new Node(0,0,map[0][0]));
        dist[0][0]=map[0][0];
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            int x=curr.x;
            int y=curr.y;
            if(dist[y][x]<curr.value)
                continue;
            if(x==N-1&&y==N-1){
                return;
            }
            for(int d=0;d<4;d++){
                int nx=x+dx[d];
                int ny=y+dy[d];
                if(!isValid(nx,ny)){continue;}
                if(dist[ny][nx]>curr.value+map[ny][nx]){
                    dist[ny][nx]=curr.value+map[ny][nx];
                    pq.offer(new Node(nx,ny,dist[ny][nx]));
                }
            }
        }

    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x <N && y >= 0 && y < N;
    }
    static class Node implements Comparable<Node> {
        int x,y, value;
        Node(int x, int y, int value) {
            this.x = x; this.y =y; this.value=value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(value, o.value);
        }
    }
}


