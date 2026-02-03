import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        solve();
    }
    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map= new int[N][N];
        int[][] sum= new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N ; j++) {
                sum[i][j]=Integer.parseInt(st.nextToken())+sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1];
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //int[] dot= new int[4];
            int firstx= Integer.parseInt(st.nextToken());
            int firsty= Integer.parseInt(st.nextToken());
            int secondx= Integer.parseInt(st.nextToken());
            int secondy= Integer.parseInt(st.nextToken());

            System.out.println(sum[secondx][secondy]-sum[secondx][firsty-1]-sum[firstx-1][secondy]+sum[firstx-1][firsty-1]);

        }
    }
}