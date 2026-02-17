
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
        Queue<Node> escapeQ=new ArrayDeque<>();
        escapeQ.add(new Node(0,0,1,1));
        boolean[][][] visited=new boolean[N][M][2];
        visited[0][0][1]=true;
        while(!escapeQ.isEmpty()){
            Node curr=escapeQ.poll();
            if(curr.x==M-1&&curr.y==N-1){
                return curr.dist;
            }
            for(int d=0;d<4;d++){
                int x=curr.x+dx[d];
                int y=curr.y+dy[d];
                if(isValid(x,y)){
                    if(map[y][x]==1&&curr.chance==1&&!visited[y][x][0]) {
                        escapeQ.add(new Node(x, y, 0, curr.dist + 1));
                        visited[y][x][0]=true;
                    }
                    if(map[y][x]==0&&!visited[y][x][curr.chance]){
                        escapeQ.add(new Node(x,y,curr.chance,curr.dist+1));
                        visited[y][x][curr.chance]=true;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x <M && y >= 0 && y < N;
    }
    static class Node {
        int x,y, chance, dist;
        Node(int x, int y, int chance, int dist) {
            this.x = x; this.y =y; this.chance = chance; this.dist = dist;
        }
    }
}


