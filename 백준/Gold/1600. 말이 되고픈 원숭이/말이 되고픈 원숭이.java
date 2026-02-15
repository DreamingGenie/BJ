import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int w;
	static int h;
	static int map[][];
	static int answer=0;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[] jx={-2,-2,-1,-1,1,1,2,2};
    static int[] jy={1,-1,2,-2,2,-2,1,-1};
	public static void main(String[] args) throws Exception{
		input();
		solve();
	}
    public static void solve(){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {0,0,k,0});
        boolean[][][] visited=new boolean[h][w][k+1];
        visited[0][0][k]=true;
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            int x=temp[0];
            int y=temp[1];
            int z=temp[2];
            int distance=temp[3];
            //System.out.println(temp[0]+" "+temp[1]);
            if(temp[0]==w-1&&temp[1]==h-1){
                System.out.println(temp[3]);
                return;
            }
            if(temp[2]>0){
                for(int d=0;d<8;d++){
                    x=temp[0]+jx[d];
                    y=temp[1]+jy[d];

                    if(isValid(x,y)&&map[y][x]==0&&!visited[y][x][z-1]){
                        queue.offer(new int[] {x,y,z-1,distance+1});
                        visited[y][x][z-1]=true;
                    }
                }
            }
            for(int d=0;d<4;d++){
                x=temp[0]+dx[d];
                y=temp[1]+dy[d];
                if(isValid(x,y)&&map[y][x]==0&&!visited[y][x][z]){
                    queue.offer(new int[] {x,y,z,distance+1});
                    visited[y][x][z]=true;
                }
            }
        }
        System.out.println(-1);
    }

	public static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        w=Integer.parseInt(input[0]);
        h=Integer.parseInt(input[1]);
        map=new int[h][w];
		for(int i=0;i<h;i++) {
            input=br.readLine().split(" ");
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(input[j]);
			}
		}
	}
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < w && y >= 0 && y < h;
	}
}


