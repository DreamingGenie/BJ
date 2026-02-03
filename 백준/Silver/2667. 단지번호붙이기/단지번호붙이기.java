
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};

    public static void main(String[] args) throws IOException {
        dfssolve();
        //bfssolve();
    }
    public static void bfssolve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map=new int[N][N];
        boolean[][] visited=new boolean[N][N];
        Queue<int[]> queue=new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input=br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(input.charAt(j)+"");
            }
        }
        List<Integer> list=new ArrayList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(map[y][x]==1&&!visited[y][x]){
                    int count=1;
                    queue.add(new int[]{x,y});
                    visited[y][x]=true;
                    while(!queue.isEmpty()){
                        int[] curr=queue.poll();
                        for(int i=0;i<4;i++){
                            int nx=curr[0]+dx[i];
                            int ny=curr[1]+dy[i];
                            if(nx>=0&&nx<N&&ny>=0&&ny<N){
                                if(!visited[ny][nx]&&map[ny][nx]==1){
                                    count++;
                                    visited[ny][nx]=true;
                                    queue.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(System.out::println);
    }
    public static void dfssolve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map=new int[N][N];
        //boolean[][] visited=new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String input=br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> list=new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x]==1) {
                    list.add(dfs(x,y));
                }
            }

        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (int cnt : list) {
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);

    }
    public static int dfs(int x,int y){
        map[y][x]=0;
        int count=1;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<N&&ny>=0&&ny<N){
                if(map[ny][nx]==1){
                    count+=dfs(nx,ny);
                }
            }
        }
        return count;
    }
}
