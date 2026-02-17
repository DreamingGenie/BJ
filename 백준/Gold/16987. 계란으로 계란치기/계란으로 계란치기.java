import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int egg[][];
    static int[] progress;
    static int answer=0;
    public static void main(String[] args) throws Exception{
        input();
        solve(0);
        System.out.println(answer);
    }
    public static void solve(int index) {

        if(index==n){
            int count=0;
            for(int i=0;i<n;i++){
                if(progress[i]>=egg[i][0])
                    count++;
            }
            answer=Math.max(count,answer);
        }
        else{
            for(int i=0;i<n;i++){
                //System.out.println(index+" "+i);
                if(i==index)
                    continue;
                if(progress[i]>=egg[i][0]||progress[index]>=egg[index][0]){
                    solve(index+1);
                    continue;
                }
                //System.out.println(index+" "+i);
                progress[i]+=egg[index][1];
                progress[index]+=egg[i][1];
                solve(index+1);
                progress[i]-=egg[index][1];
                progress[index]-=egg[i][1];
            }
        }
    }
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        egg=new int[n][2];
        progress=new int[n];
        for(int i=0;i<n;i++) {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<2;j++) {
                egg[i][j]=Integer.parseInt(input[j]);
            }
        }

    }

}


