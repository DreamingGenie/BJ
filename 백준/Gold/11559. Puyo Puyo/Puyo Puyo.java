import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static char[][] map=new char[12][6];
	static int answer=0;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		input();
		while(true) {
			if(!find())
				break;
			
			Gravity();
			//printmap();
			answer++;
		}
		System.out.println(answer);
		
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int y=0;y<12;y++) {
			String input=br.readLine();
			for(int x=0;x<6;x++) {
				map[y][x]=input.charAt(x);
			}
		}
	}
	public static boolean find() {
		boolean isfind=false;
		boolean[][] visited=new boolean[12][6];
		for(int y=0;y<12;y++) {
			for(int x=0;x<6;x++) {
				char flag=map[y][x];
				if(flag=='.'||visited[y][x])
					continue;
				
				Queue<Puyo> save=new LinkedList<>();
				visited[y][x]=true;
				bfs(save,x,y,visited,flag);
				
				if(save.size()>=4) {
					while(!save.isEmpty()) {
						Puyo temp=save.poll();
						map[temp.y][temp.x]='.';
					}
					isfind=true;
				}	
			}
		}
		
		return isfind;	
	}
	public static void bfs(Queue<Puyo> save, int x, int y, boolean[][] visited, char flag) {
		Queue<Puyo> bfs=new LinkedList<>();
		bfs.offer(new Puyo(x,y));
		save.offer(new Puyo(x,y));
		while(!bfs.isEmpty()) {
			Puyo temp=bfs.poll();
			for(int d=0;d<4;d++) {
				int nx=temp.x+dx[d];
				int ny=temp.y+dy[d];
				if(isValid(nx,ny)&&map[ny][nx]==flag&&!visited[ny][nx]) {
					visited[ny][nx]=true;
					bfs.offer(new Puyo(nx,ny));
					save.offer(new Puyo(nx,ny));						
				}
			}
		}
	}
	public static void printmap() {
		for(int y=0;y<12;y++) {
			for(int x=0;x<6;x++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isValid(int x,int y) {
		return (x>=0&&x<6&&y>=0&&y<12);
	}
	public static void Gravity() {
        for (int x = 0; x < 6; x++) {
            Queue<Character> column = new LinkedList<>();
            for (int y = 11; y >= 0; y--) {
                if (map[y][x] != '.') {
                    column.add(map[y][x]);
                    map[y][x] = '.';
                }
            }
            int index = 11;
            while (!column.isEmpty()) {
                map[index--][x] = column.poll();
            }
        }
    }
	public static class Puyo{
		int x;
		int y;
		public Puyo(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}
