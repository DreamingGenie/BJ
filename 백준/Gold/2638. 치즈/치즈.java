

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int X;
    static int Y;
    static int[][] map;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int cheezeCount =0;
    public static void main(String[] args) throws IOException {
        input();
        updateOutside(0,0);
        int time=0;
        while(cheezeCount >0){
            //System.out.println(cheezeCount);
            cheezeCount-=bfs();
            //printMap();
            time++;
        }
        System.out.println(time);

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
    public static void updateOutside(int x, int y){
        Queue<Dot> now=new LinkedList<>();
        boolean visited[][]=new boolean[Y][X];
        visited[y][x]=true;
        now.add(new Dot(x,y));
        map[y][x]=2;
        while(!now.isEmpty()){
            Dot temp=now.poll();
            for(int d=0;d<4;d++){
                int nx=temp.x+dx[d];
                int ny=temp.y+dy[d];
                if(isValid(nx,ny)&&!visited[ny][nx]){
                    visited[ny][nx]=true;
                    if(map[ny][nx]==0) {
                        map[ny][nx] = 2;
                        now.add(new Dot(nx,ny));
                    }

                }
            }
        }
    }
    public static int bfs(){
        int[][] origin=new int[Y][X];
        for(int i=0;i<Y;i++){
            origin[i]=map[i].clone();
        }
        Queue<Dot> now=new LinkedList<>();
        int eraseCount=0;
        boolean visited[][]=new boolean[Y][X];
        visited[0][0]=true;
        now.add(new Dot(0,0));
        while(!now.isEmpty()){
            Dot temp=now.poll();
            for(int d=0;d<4;d++){
                int nx=temp.x+dx[d];
                int ny=temp.y+dy[d];
                if(isValid(nx,ny)&&!visited[ny][nx]){
                    visited[ny][nx]=true;
                    if(map[ny][nx]==2)
                        now.add(new Dot(nx,ny));
                    else if(checkNear(nx,ny,origin)>1){
                        updateOutside(nx,ny);
                        eraseCount++;
                    }
                }
            }
        }
        return eraseCount;
    }
    public static boolean isValid(int x,int y){
        return x >= 0 && x < X && y >= 0 && y < Y;
    }
    public static int checkNear(int x,int y,int[][] origin){
        int near=0;
        for(int d=0;d<4;d++){
            int nx=x+dx[d];
            int ny=y+dy[d];
            if(isValid(nx,ny)&&origin[ny][nx]==2)
                near++;
        }
        return near;
    }
    public static void printMap(){
        System.out.println();
        for(int i = 0; i< Y; i++){
            for(int j = 0; j< X; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
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
