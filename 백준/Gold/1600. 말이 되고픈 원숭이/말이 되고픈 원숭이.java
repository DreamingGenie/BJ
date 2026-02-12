import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K,m,n;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[] hdx = {-1, -2, -1,-2, 1, 2, 1, 2};
	static int[] hdy = {2, 1, -2, -1, 2, 1, -2,-1};
	static Queue<int[]> q = new LinkedList<>();
	static int[][][] visited;
	static int ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		visited = new int[n][m][K+1];
		arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.offer(new int[] {0,0,0,0});
		visited[0][0][0] = 1;
		ans = bfs();
		System.out.println(ans);
		
		
		//말이동은 장애물 상관 없음
		//원이동은 4방 장애물 안됨 
		//k번을 쓰냐마냐 
		
	}
	private static int bfs() {
		while (!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];
			int horse = cur[2];
			int dist = cur[3];
			
			if(x == n-1 && y == m-1) {
				return dist;
			}
			
			int nx,ny;
			
			for(int i = 0; i <4; i++) { //원이동
				nx = x + dx[i];
				ny = y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m && visited[nx][ny][horse] == 0 && arr[nx][ny] == 0) {
					q.offer(new int[] {nx,ny,horse,dist+1});
					visited[nx][ny][horse] = 1;
				}
				
			}
			if(horse < K) {
				for(int j = 0; j<8; j++) { //말이동
					nx = x + hdx[j];
					ny = y + hdy[j];
					if(0<=nx && nx<n && 0<=ny && ny<m && visited[nx][ny][horse+1] == 0 && arr[nx][ny] == 0) {
						q.offer(new int[] {nx,ny,horse+1,dist+1});
						visited[nx][ny][horse+1] = 1;
					}
				}
			}
			
		}
		
		return -1;	
	}
	

}
