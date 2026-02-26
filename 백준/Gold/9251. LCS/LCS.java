

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception
    {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=1;
//        T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            char[] arrA=st.nextToken().toCharArray();
            st=new StringTokenizer(br.readLine());
            char[] arrB=st.nextToken().toCharArray();
            int lenA=arrA.length;
            int lenB=arrB.length;
            int answer=0;
            int[][] dp=new int[lenA+1][lenB+1];
            for(int a=1;a<=lenA;a++) {
            	for(int b=1;b<=lenB;b++) {
            		if(arrA[a-1]==arrB[b-1]) {
            			dp[a][b]=dp[a-1][b-1]+1;
            		}
            		else {
            			dp[a][b]=Math.max(dp[a-1][b],dp[a][b-1]);
            		}
            	}
            }
            //System.out.println("#"+test_case+" "+dp[lenA][lenB]);
            System.out.println(dp[lenA][lenB]);
        }
    }
	//
}
