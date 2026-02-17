import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numlist;
    static int[] buho;
    static boolean[] visited;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static ArrayList<Integer> buholist=new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(max);
        System.out.println(min);
    }
    public static void input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        numlist=new int[N];
        buho=new int[N-1];
        visited=new boolean[N-1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            numlist[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int index=0;
        for(int i=0;i<4;i++) {
            int a=Integer.parseInt(st.nextToken());
            while(a-->0) {
                buho[index++]=i;
            }
        }
    }
    public static void solve(){
        //ystem.out.println(Arrays.toString(buho));
        combi(0);

    }
    public static void combi(int index){
        if(index==N-1){
            //System.out.println(Arrays.toString(buholist.toArray()));
            int result=calculate();
            max=Math.max(result,max);
            min=Math.min(result,min);
            return;
        }
        for(int i=0;i<N-1;i++) {
            if(visited[i]){continue;}
            visited[i]=true;
            buholist.add(buho[i]);
            combi(index+1);
            visited[i]=false;
            buholist.remove(index);
        }
    }
    public static int calculate(){
        int a=numlist[0];
        int b;
        for(int i=0;i<N-1;i++) {
            b=numlist[i+1];
            if(buholist.get(i)==0){
                a=a+b;
            }
            else if(buholist.get(i)==1){
                a=a-b;
            }
            else if(buholist.get(i)==2){
                a=a*b;
            }
            else if(buholist.get(i)==3){
                a=a/b;
            }
        }
        return a;
    }
}
