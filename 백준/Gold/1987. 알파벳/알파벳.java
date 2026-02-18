import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static int R;
    static int C;
    static char[][] map;
    static boolean[][] visited;
    static int answer=0;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[] alpha=new boolean[26];
    public static void main(String[] args) throws Exception{
        input();
        alpha[map[0][0]-'A']=true;
        visited[0][0]=true;
        dfs(0,0,1);
        System.out.println(answer);
    }
    public static void dfs(int x, int y,int level){
        answer=Math.max(answer,level);
        for(int d=0;d<4;d++){
            int nx=x+dx[d];
            int ny=y+dy[d];
            if(!isValid(nx,ny)){continue;}
            if(visited[ny][nx]){continue;}
            char now=map[ny][nx];
            if(alpha[now-'A']){continue;}
            alpha[now-'A']=true;
            visited[ny][nx]=true;
            dfs(nx,ny,level+1);
            visited[ny][nx]=false;
            alpha[now-'A']=false;

        }
    }
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        R =Integer.parseInt(input[0]);
        C =Integer.parseInt(input[1]);
        map=new char[R][C];
        visited=new boolean[R][C];
        for(int i = 0; i< R; i++) {
            String line=br.readLine();
            for(int j = 0; j< C; j++) {
                map[i][j]=line.charAt(j);
            }
        }

    }
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < C && y >= 0 && y < R;
    }

}
