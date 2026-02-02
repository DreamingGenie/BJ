import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N=Integer.parseInt(input[0]);
        int M=Integer.parseInt(input[1]);
        int R=Integer.parseInt(input[2]);
        int[][] array=new int[N][M];
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                array[i][j]=Integer.parseInt(input[j]);
            }
        }
        int[][] Rarray=new int[N][M];
        int layersize=Math.min(M,N)/2;
        for(int repeat=0;repeat<layersize;repeat++){
            ArrayList<Integer> list=new ArrayList<>();
            int top=repeat;
            int left=repeat;
            int bottom=N-repeat-1;
            int right=M-repeat-1;
            for(int j=left;j<=right;j++){
                list.add(array[top][j]);
            }
            for(int j=top+1;j<=bottom-1;j++){
                list.add(array[j][right]);
            }
            for(int j=right;j>=left;j--){
                list.add(array[bottom][j]);
            }
            for(int j=bottom-1;j>=top+1;j--){
                list.add(array[j][left]);
            }
            int len=list.size();
            int rotate=R%len;
            Collections.rotate(list,-rotate);

            int idx=0;
            for(int j=left;j<=right;j++){
                array[top][j]=list.get(idx++);
            }
            for(int j=top+1;j<=bottom-1;j++){
                array[j][right]=list.get(idx++);
            }
            for(int j=right;j>=left;j--){
                array[bottom][j]=list.get(idx++);
            }
            for(int j=bottom-1;j>=top+1;j--){
                array[j][left]=list.get(idx++);
            }
        }
        for(int y = 0; y <N; y++){
            for(int x = 0; x <M; x++){
                System.out.print(array[y][x]+" ");
            }
            System.out.println();
        }
    }
}
