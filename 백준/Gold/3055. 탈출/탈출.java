
import java.io.*;
import java.util.*;
public class Main {
    static int r;
    static int c;
    static char map[][];

    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> escapeQ = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        input();
        int result=escape();
        if(result!=-1)
            System.out.println(result);
        else
            System.out.println("KAKTUS");
    }
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r=Integer.parseInt(input[0]);
        c=Integer.parseInt(input[1]);
        map=new char[r][c];
        for(int i=0;i<r;i++) {
            String line = br.readLine();
            for(int j=0;j<c;j++) {
                map[i][j]=(line.charAt(j));
                if(map[i][j]=='S'){
                    escapeQ.add(new int[] {j,i,0});
                }
                if(map[i][j]=='*'){
                    waterQ.add(new int[] {j,i});
                }
            }
        }

    }
    static int escape(){
        while(!escapeQ.isEmpty()){
            int watersize=waterQ.size();
            for(int i=0;i<watersize;i++){
                int[] curr=waterQ.poll();
                for(int d=0;d<4;d++){
                    int x=curr[0]+dx[d];
                    int y=curr[1]+dy[d];
                    if(isValid(x,y)&&map[y][x]=='.'){
                        map[y][x]='*';
                        waterQ.add(new int[] {x,y});
                    }
                }
            }
            int escapesize=escapeQ.size();
            for(int i=0;i<escapesize;i++){
                int[] curr=escapeQ.poll();
                for(int d=0;d<4;d++){
                    int x=curr[0]+dx[d];
                    int y=curr[1]+dy[d];
                    if(isValid(x,y)){
                        if(map[y][x]=='D'){
                            return curr[2]+1;
                        }
                        if(map[y][x]=='.'){
                            map[y][x]=' ';
                            escapeQ.add(new int[] {x,y,curr[2]+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
    static void setWater(){

    }
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < c && y >= 0 && y < r;
    }

}


