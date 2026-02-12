
import java.io.*;
import java.util.*;

public class Main {
	static int answer=0;
	static int n;
	static int m;
	static int map[][];
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int wallsize=0;
	static ArrayList<Integer> empty=new ArrayList<>();
	static ArrayList<Integer> virus=new ArrayList<>();
	//static ArrayList<Dot> wall=new ArrayList<>();
	public static void main(String[] args) throws Exception{
		input();
		makecombi(0,0);
		System.out.println(answer);
	}
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()); 
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			String[] input=br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(input[j]);
				if(map[i][j]==2)
					virus.add(i*m+j);
				else if(map[i][j]==1)
					wallsize++;
				else
					empty.add(i*m+j);
				
			}
		}
	}
	public static void makecombi(int index, int cnt) {
		if(cnt==3)
		{
			int vi=dfs();
			answer=Math.max(answer, n*m-vi-wallsize);
			return;
		}
		for(int i=index;i<empty.size();i++) {
			int newwall=empty.get(i);
			//wall.add(newwall);
			wallsize++;
			map[newwall/m][newwall%m]=1;
			makecombi(i+1,cnt+1);
			//wall.remove(newwall);
			wallsize--;
			map[newwall/m][newwall%m]=0;
			
		}
	}
	public static int dfs() {
		Queue<Integer> q=new LinkedList<>();
		boolean[][] visited=new boolean[n][m];
		int visize=0;
		for(int i=0;i<virus.size();i++) {
			q.add(virus.get(i));
			//visited[virus.get(i).y][virus.get(i).x]=true;
			visize++;
		}
		while(!q.isEmpty()) {
			int temp=q.poll();
			for(int d=0;d<4;d++) {
				int nx=temp%m+dx[d];
				int ny=temp/m+dy[d];
				if(!isValid(nx,ny))
					continue;
				if(visited[ny][nx])
					continue;
				if(map[ny][nx]!=0)
					continue;
				q.add(ny*m+nx);
				visited[ny][nx]=true;
				visize++;
			}
		}
		return visize;
	}
	public static boolean isValid(int x, int y) {
		return(x>=0&&x<m&&y>=0&&y<n);
	}
	
	
//	public static class Dot{
//		int x;
//		int y;
//		public Dot(int x, int y) {
//			this.x=x;
//			this.y=y;
//		}
//	}
}
