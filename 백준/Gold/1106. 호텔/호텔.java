

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int C;
    static int N;
    static int[][] citys;
    public static void main(String[] args) throws Exception {
        input();
        int[] dp=new int[C+101];
        Arrays.fill(dp,Integer.MAX_VALUE/100);
        dp[0]=0;
        for(int i=1;i<=C+100;i++)
        {
            for(int j=0;j<N;j++){
                int cost=citys[j][0];
                int value=citys[j][1];
                if(i-value>=0){
                    if(dp[i]>dp[i-value]+cost){
                        //System.out.println("in"+j);
                        dp[i]=dp[i-value]+cost;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        citys = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            citys[i][0] = Integer.parseInt(st.nextToken());
            citys[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
