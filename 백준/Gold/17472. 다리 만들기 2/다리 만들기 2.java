import java.util.*;
import java.io.*;

public class Main {
	static int N, M, islandCount;
    static int[][] map, islandMap;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
    	input();
    	//섬 인식
    	islandCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    labelIslands(i, j, ++islandCount);
                }
            }
        }
        //다리 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (islandMap[i][j] != 0) {
                    makeBridges(i, j, islandMap[i][j]);
                }
            }
        }
        
        parent=new int[islandCount+1];
        for(int i=1;i<=islandCount;i++) {
        	parent[i]=i;
        }
        
        int answer=0;
        int islandnum=0;
        while(!pq.isEmpty()) {
        	Edge temp=pq.poll();
        	if(find(temp.u)!=find(temp.v)) {
        		answer+=temp.dist;
        		islandnum++;
        		union(temp.u,temp.v);
        	}
        	if(islandnum>=islandCount-1)
        		break;
        }
        if (islandCount > 1 && islandnum == islandCount - 1) {
            System.out.println(answer);
        } else if (islandCount <= 1) { 
            System.out.println(0);
        } else {
            System.out.println(-1);
        }
        
    }
    
    static void input() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        islandMap = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    static void labelIslands(int r, int c, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        islandMap[r][c] = id;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    islandMap[nr][nc] = id;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
    
    static void makeBridges(int r, int c, int startId) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            int length = 0;

            while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (islandMap[nr][nc] == startId) 
                	break;
                if (islandMap[nr][nc] != 0) { 
                    if (length >= 2) {
                        pq.add(new Edge(startId, islandMap[nr][nc], length));
                    }
                    break;
                }
                length++;
                nr += dr[d];
                nc += dc[d];
            }
        }
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[parent[x]]);
    }
    static void union(int x, int y) {
    	
    	parent[find(y)]=find(x);
    }
    
    static class Edge implements Comparable<Edge> {
        int u, v, dist;
        
        Edge(int u, int v, int d) { 
        	this.u = u; this.v = v; this.dist = d; 
        }
        
        @Override 
        public int compareTo(Edge o) { 
        	return this.dist - o.dist; 
        }
    }
}
