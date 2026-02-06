
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static boolean[][] board;
    static int[] visited;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        board=new boolean[N][N];
        visited=new int[N];
        //Arrays.fill(visited,-1);
        search(0);
        System.out.println(answer);
    }
    public static void search(int index){

        if(index==N){
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            visited[index]=i;
            //System.out.println(isPossible(i,index));
            if(isPossible(i,index)){
                //System.out.println(index);
                //answer++;
                search(index+1);
                //visited[index]=-1;
            }
        }
    }
    public static boolean isPossible(int x, int y){
        for(int i=0;i<y;i++){
            if(visited[i]==x)
                return false;
            if(Math.abs(visited[i]-x)==Math.abs(i-y)){
                return false;
            }
        }
        return true;
    }
}
