
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] power;
    static int[] dp;
    static final int MAX=Integer.MAX_VALUE/10;
    static int P;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        power=new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                power[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        String input=br.readLine();
        int OnOff=0;
        for(int i=0;i<N;i++){
            if(input.charAt(i)=='Y')
                OnOff|=(1<<i);

        }
        P=Integer.parseInt(br.readLine());
        dp=new int[1<<N];
        Arrays.fill(dp, -1);

        int answer = solve(OnOff);

        if(answer==MAX)
            System.out.println(-1);
        else
            System.out.println(answer);

    }
    public static int solve(int visited){
        if(Integer.bitCount(visited)>=P)
            return 0;

        if(dp[visited]!=-1)
            return dp[visited];

        dp[visited] = MAX;

        for(int i=0;i<N;i++){
            if((visited&(1<<i))!=0){
                for(int j=0;j<N;j++){
                    if((visited&(1<<j))==0){
                        int cost=power[i][j]+solve(visited|(1<<j));
                        dp[visited]=Math.min(dp[visited],cost);
                    }
                }
            }
        }
        return dp[visited];
    }
}
