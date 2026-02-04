import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int w;
    static int h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1,-1,-1,1,1};
    static int[] dy={1,-1,0,0,-1,1,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int answer=0;
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            if(w==0&&h==0)
                break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        bfs(j, i);
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static class Dot{
        int x;
        int y;
        public Dot(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void bfs(int x,int y){
        int nx;
        int ny;
        Queue<Dot> queue=new LinkedList<>();
        visited[y][x]=true;
        queue.add(new Dot(x,y));
        while(!queue.isEmpty()){
            Dot temp=queue.poll();

            for(int d=0;d<8;d++){
                nx=temp.x+dx[d];
                ny=temp.y+dy[d];
                if(isValid(nx,ny)){
                    if(map[ny][nx]==1&&!visited[ny][nx]){
                        visited[ny][nx]=true;
                        queue.add(new Dot(nx,ny));
                    }
                }
            }
        }
    }
    public static boolean isValid(int x,int y){
        if(x>=0&&x<w&&y>=0&&y<h){
            return true;
        }
        return false;
    }
}
