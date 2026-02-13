import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int[][] move;
	static Queue<int[]> q;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int cost;
	static int t;

	public static void main(String[] args) throws IOException {
		t = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			t++;
			arr = new int[n][n];
			move = new int[n][n];
			q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

			
			for(int i = 0; i <n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i <n; i++) {
				Arrays.fill(move[i], Integer.MAX_VALUE);
			}
			
			q.add(new int[] {0,0,arr[0][0]});
			move[0][0] = arr[0][0];
			cost = bfs();
			System.out.println("Problem"+" "+t+":"+" "+cost);
			
			
			
		}

	}

	private static int bfs() {
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int x = cur[0];
			int y = cur[1];
			int cost = cur[2];
			if(x == n-1 && y == n-1) {
				return cost;
			}
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(!(0<=nx && nx<n && 0<=ny && ny<n)) continue;
				
				if(cost+arr[nx][ny] < move[nx][ny]) {
					move[nx][ny] = cost+arr[nx][ny];
					q.add(new int[] {nx,ny,cost+arr[nx][ny]});
				}
			}
		}
		return -1;
	}

}
