
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R;
    static int C;
    static int T;
    static int[][] map;
    static int[] airCleaner;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public static void main(String[] args) throws IOException {
        init();
        for(int i=0;i<T;i++){
            diffusion();
            

            clean();
        }
        answer();
    }
    public static void diffusion(){
        //먼지 확산
        int[][] diffmap=new int[R][C];
        int x=0;
        int y=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]>0){
                    diffmap[i][j]+=map[i][j];
                    int A=map[i][j]/5;
                    for(int d=0;d<4;d++){
                        y=i+dy[d];
                        x=j+dx[d];
                        if(isValid(x,y)){
                            diffmap[y][x]+=A;
                            diffmap[i][j]-=A;
                        }
                    }
                }
            }
        }
        map=diffmap;
    }
    public static void clean(){
        //공기청정기 동작
        int top=airCleaner[0];
        int bottom=airCleaner[0]+1;
        for(int i=top-1;i>0;i--){
            map[i][0]=map[i-1][0];
        }
        for(int i=bottom+1;i<R-1;i++){
            map[i][0]=map[i+1][0];
        }
        for(int i=0;i<C-1;i++){
            map[0][i]=map[0][i+1];
            map[R-1][i]=map[R-1][i+1];
        }
        for(int i=0;i<top;i++){
            map[i][C-1]=map[i+1][C-1];
        }
        for(int i=R-1;i>bottom;i--){
            map[i][C-1]=map[i-1][C-1];
        }
        for(int i=C-1;i>1;i--){
            map[top][i]=map[top][i-1];
            map[bottom][i]=map[bottom][i-1];
        }
        map[top][1]=0;
        map[bottom][1]=0;
    }
    public static boolean isValid(int x,int y){
        //유효성 검사 1. 범위 안인가, 2. 공기청정기 위치가 아닌가
        if(!(x>=0&&y>=0&&x<C&&y<R))
            return false;
        else if((x==airCleaner[1])&&(y==airCleaner[0]||y==airCleaner[0]+1))
            return false;

        return true;

    }
    public static void init() throws IOException {
        //초기값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R=Integer.parseInt(input[0]);
        C=Integer.parseInt(input[1]);
        T=Integer.parseInt(input[2]);
        map=new int[R][C];
        for(int i=0;i<R;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<C;j++){
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==-1&&airCleaner==null){
                    airCleaner=new int[]{i,j};
                }
            }
        }

    }
    public static void answer(){
        //정답 출력
        int sum=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                sum+=map[i][j];
            }
        }
        System.out.println(sum);
    }
}
