

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        //int N=16;
        int[] array=new int[N];
        //int[] dp=new int[N];
        int[] indexRecord=new int[N];
        //int last=0;
        //Arrays.fill(parent,-1);;
        //int answer=0;
        ArrayList<Integer> taillist =new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        //StringTokenizer st=new StringTokenizer("10 20 10 30 20 50 1 2 3 4 5 6 10 20 30 40");
        for(int i=0;i<N;i++){
            array[i]=Integer.parseInt(st.nextToken());
            if(taillist.isEmpty()||array[i]>taillist.get(taillist.size()-1)){
                taillist.add(array[i]);
                indexRecord[i]=taillist.size()-1;
            }
            else{
                int start=0;
                int end=taillist.size()-1;
                while(start<end){
                    int middle=(start+end)/2;
                    if(taillist.get(middle)>=array[i]){
                        end=middle;
                    }
                    else{
                        start=middle+1;
                    }
                }
                taillist.set(start,array[i]);
                indexRecord[i]=start;
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append(taillist.size()).append("\n");
        int index=taillist.size()-1;
        int[] result=new int[index+1];

        for(int i = N-1; i>=0; i--){
            if(indexRecord[i]==index)
            {
                result[index]=array[i];
                index--;
            }
        }
        for(int i=0;i<result.length;i++){
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
        //System.out.println(Arrays.toString(result));

    }
}
