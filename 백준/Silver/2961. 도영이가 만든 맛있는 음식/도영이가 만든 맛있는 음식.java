

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[][] list;
    //static ArrayList<Integer> arrlist;
    static int answer=Integer.MAX_VALUE;
    static int sour=1;
    static int acerbity=0;
    static int count=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list=new int[N][2];

        for(int i=0;i<N;i++){
            String[] input =br.readLine().split(" ");
            list[i][0]=Integer.parseInt(input[0]);
            list[i][1]=Integer.parseInt(input[1]);
        }
        //arrlist=new ArrayList<>();

        bt(sour,acerbity,0,count);
        System.out.println(answer);
    }
    public static void bt(int sour, int acerbity,int index,int count){
        if(index==N) {
            if (count!=0) {
                answer = Math.min(answer, (Math.abs(sour - acerbity)));
            }
            return;
        }


        bt(sour*list[index][0],acerbity+list[index][1],index+1,count+1);

        bt(sour,acerbity,index+1,count);

    }
}
