import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int X;
    static int Y;
    static int[][] map;
    //static boolean[][] visited;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int cheezeCount =0;
    public static void main(String[] args) throws IOException {
        input();
        int time=0;
        int before=0;
        while(cheezeCount !=0){
            //System.out.println(now+" "+before);
            before= cheezeCount;
            cheezeCount-=bfs();
            //cheezeCount =countCheeze();
            time++;
        }
        System.out.println(time);
        System.out.println(before);

    }
    public static void input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        Y =Integer.parseInt(input[0]);
        X =Integer.parseInt(input[1]);
        map=new int[Y][X];
        for(int i = 0; i< Y; i++){
            input=br.readLine().split(" ");
            for(int j = 0; j< X; j++){
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==1)
                    cheezeCount++;

            }
        }
    }
    public static int bfs(){
        Queue<Dot> now=new LinkedList<>();
        int eraseCount=0;
        //Queue<Dot> next=new LinkedList<>();
        boolean visited[][]=new boolean[Y][X];
        visited[0][0]=true;
        now.add(new Dot(0,0));
        //next.add(new Dot(0,0));
        while(!now.isEmpty()){
            Dot temp=now.poll();
            for(int d=0;d<4;d++){
                int nx=temp.x+dx[d];
                int ny=temp.y+dy[d];
                if(isValid(nx,ny)&&!visited[ny][nx]){
                    visited[ny][nx]=true;
                    if(map[ny][nx]==0)
                        now.add(new Dot(nx,ny));
                    else {
                        map[ny][nx] = 0;
                        eraseCount++;
                    }
                    //next.add(new Dot(nx,ny));
                }
            }
        }
        return eraseCount;
    }
    public static boolean isValid(int x,int y){
        return x >= 0 && x < X && y >= 0 && y < Y;
    }
    public static int countCheeze(){
        int checker=0;
        for(int i = 0; i< Y; i++){
            for(int j = 0; j< X; j++){
                if(map[i][j]==1)
                    checker++;

            }
        }
        return checker;
    }
    public static class Dot {
        int x;
        int y;
        public Dot(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
