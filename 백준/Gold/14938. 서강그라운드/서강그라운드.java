import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static int m;
    static int r;
    static int[] item;
    static int[][] map;

    static final int INF=Integer.MAX_VALUE/10;
    public static void main(String[] args) throws IOException {
        input();
        pluid();
        calculate();
    }

    private static void calculate() {
        int answer=0;
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=1;j<=n;j++){
                if(map[i][j]<=m)
                    sum+=item[j];
            }
            answer=Math.max(answer,sum);
        }
        System.out.println(answer);
    }

    private static void pluid() {
        for(int k=1;k<=n;k++){
            for(int j=1;j<=n;j++){
                for(int l=1;l<=n;l++){

                    if(map[j][l]>map[j][k]+map[k][l]){
                        map[j][l]=map[j][k]+map[k][l];
                    }
                }
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        map = new int[n+1][n+1];
        for(int j = 1; j <= n; j++){
            Arrays.fill(map[j],INF);
            map[j][j]=0;
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from][to] = cost;
            map[to][from] = cost;
        }
    }
}
