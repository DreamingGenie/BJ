
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] A=br.readLine().toCharArray();
        char[] B=br.readLine().toCharArray();
        int alen=A.length;
        int blen=B.length;
        int[][] dp=new int[alen+1][blen+1];
        for(int i=1;i<=alen;i++){
            for(int j=1;j<=blen;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[alen][blen]);
        if(dp[alen][blen]>0){
            StringBuffer sb=new StringBuffer();
            int aindex=alen;
            int bindex=blen;
            while(aindex>0&&bindex>0){

                if(A[aindex-1]==B[bindex-1]){
                    sb.append(A[aindex-1]);
                    aindex--;
                    bindex--;
                }
                else{
                    if(dp[aindex-1][bindex]>dp[aindex][bindex-1]){
                        aindex=aindex-1;
                    }
                    else{
                        bindex=bindex-1;
                    }
                }
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
