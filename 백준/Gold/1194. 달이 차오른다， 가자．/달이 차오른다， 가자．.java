import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static boolean[][][] visited;
	static int startx;
	static int starty;
	static int endx;
    static int endy;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		input();
		escape();
		//System.out.println(answer);
	}
	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[]=(br.readLine()).split(" ");
		n=Integer.parseInt(input[0]);
		m=Integer.parseInt(input[1]);
		map=new char[n][m];
		visited=new boolean[n][m][64];
		
		for(int i=0;i<n;i++) {
			String inputmap=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=inputmap.charAt(j);
				if(map[i][j]=='0') {
					startx=j;
					starty=i;
				}
                if(map[i][j]=='1') {
                    endx=j;
                    endy=i;
                }
			}
		}
		
	}
	public static void escape() {
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {startx,starty,0,0});
		visited[starty][startx][0]=true;
		while(!q.isEmpty()) {
			int[] temp=q.poll();
            if(map[temp[1]][temp[0]]=='1'){
                System.out.println(temp[3]);
                return;
            }
            for(int i=0;i<4;i++) {
                int x=temp[0]+dx[i];
                int y=temp[1]+dy[i];
                int key=temp[2];
                int distance=temp[3];
                if(!isValid(x,y))
                    continue;
                if(map[y][x]=='#')
                    continue;
                if(map[y][x]>='A'&&map[y][x]<='F') {
                    if(!checkKey(key,map[y][x]))
                        continue;
                }
                if(map[y][x]>='a'&&map[y][x]<='f') {
                    key=(key|(1<<map[y][x]-'a'));
                }
                if(visited[y][x][key])
                    continue;
                visited[y][x][key]=true;
                q.add(new int[] {x,y,key,distance+1});
                //System.out.println(x+" "+y+" "+key+" "+distance);
            }
		}
        System.out.println(-1);
		
	}
    public static boolean checkKey(int key,char door){
        return((key&(1<<door-'A'))!=0);
    }
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
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


