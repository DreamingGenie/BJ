
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int map[][];
	static boolean[][] visited;
	static int answer=1;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		input();
		solve();
		System.out.println(answer);
	}
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			String[] input=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(input[j]);
				min=Math.min(min, map[i][j]);
				max=Math.max(max, map[i][j]);
			}
		}
	}
	public static void solve() {
		for(int level=min;level<max;level++) {
			visited=new boolean[n][n];
			int count=0;
			//System.out.println(level+" "+count);
			for(int y=0;y<n;y++) {
				for(int x=0;x<n;x++) {
					//System.out.println(map[y][x]+" "+!visited[y][x]);
					if(map[y][x]>level&&!visited[y][x]) {
						count++;
						bfs(x,y,level);
					}
				}
			}
			//System.out.println(level+" "+count);
			answer=Math.max(answer, count);
		}
	}
	public static void bfs(int x, int y, int level) {
		Queue<Dot> q=new LinkedList<>();
		visited[y][x]=true;
		q.add(new Dot(x,y));
		while(!q.isEmpty()) {
			Dot temp=q.poll();
			for(int d=0;d<4;d++) {
				int nx=temp.x+dx[d];
				int ny=temp.y+dy[d];
				if(isValid(nx,ny)&&!visited[ny][nx]&&map[ny][nx]>level) {
					visited[ny][nx]=true;
					q.offer(new Dot(nx,ny));
				}
			}
		}		
	}
	
	public static boolean isValid(int x,int y) {
		return (x<n&&x>=0&&y<n&&y>=0);
	}
	public static class Dot{
		int x;
		int y;
		public Dot(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
