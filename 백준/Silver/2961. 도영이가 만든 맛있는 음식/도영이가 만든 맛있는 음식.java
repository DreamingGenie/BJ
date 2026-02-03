
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[][] list;
    static ArrayList<Integer> arrlist;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list=new int[N][2];

        for(int i=0;i<N;i++){
            String[] input =br.readLine().split(" ");
            list[i][0]=Integer.parseInt(input[0]);
            list[i][1]=Integer.parseInt(input[1]);
        }
        arrlist=new ArrayList<>();
        bt(arrlist,0);
        System.out.println(answer);
    }
    public static void bt(ArrayList<Integer> arrlist,int index){
        if(index==N&& !arrlist.isEmpty()){
            int sour=1;
            int acerbity=0;
            for(int i=0;i<arrlist.size();i++){
                int temp=arrlist.get(i);
                sour*=list[temp][0];
                acerbity+=list[temp][1];
            }
            answer=Math.min(answer,(Math.abs(sour-acerbity)));
        }
        for(int i=index;i<N;i++){
            arrlist.add(i);
            bt(arrlist,i+1);
            arrlist.remove(arrlist.indexOf(i));
            bt(arrlist,i+1);
        }
    }
}
