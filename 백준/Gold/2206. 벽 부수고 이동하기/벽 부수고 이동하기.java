

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int map[][];

    //static Queue<int[]> waterQ = new LinkedList<>();
    //static Queue<int[]> escapeQ = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        input();
        int result=escape();
        System.out.println(result);
    }
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        map=new int[N][M];
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j]=(line.charAt(j)-'0');
            }
        }

    }
    static int escape(){
        Queue<int[]> escapeQ=new LinkedList<>();
        escapeQ.add(new int[]{0,0,1,1});
        boolean[][][] visited=new boolean[N][M][2];
        visited[0][0][0]=true;
        while(!escapeQ.isEmpty()){
            int[] curr=escapeQ.poll();
            if(curr[0]==M-1&&curr[1]==N-1){
                return curr[3];
            }
            for(int d=0;d<4;d++){
                int x=curr[0]+dx[d];
                int y=curr[1]+dy[d];
                if(isValid(x,y)){
                    if(map[y][x]==1&&curr[2]==1&&!visited[y][x][0]) {
                        escapeQ.add(new int[]{x, y, 0, curr[3] + 1});
                        visited[y][x][1]=true;
                    }
                    if(map[y][x]==0&&!visited[y][x][curr[2]]){
                        escapeQ.add(new int[] {x,y,curr[2],curr[3]+1});
                        visited[y][x][curr[2]]=true;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x <M && y >= 0 && y < N;
    }

}


