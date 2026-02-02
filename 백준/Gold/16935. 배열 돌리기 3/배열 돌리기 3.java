
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int[][] array;
    static int[][] result;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String[] input = br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        int R=Integer.parseInt(input[2]);
        array=new int[N][M];
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<M;j++){
                array[i][j]=Integer.parseInt(input[j]);
            }
        }
        String[] order=(br.readLine().split(" "));
        for(int r=0;r<R;r++){
            if(order[r].equals("1"))
                flipUpDown();
            else if(order[r].equals("2")){
                flipLefttoRight();
            }
            else if(order[r].equals("3")){
                rotateByClockwise();
            }
            else if(order[r].equals("4")){
                rotateByCounterClockwise();
            }
            else if(order[r].equals("5")){
                rotatePartClockwise();
            }
            else if(order[r].equals("6")){
                rotatePartCounterClockwise();
            }
            N= result.length;
            M= result[0].length;
            array=new int[N][M];
            for(int j=0;j<N;j++){
                array[j]=Arrays.copyOf(result[j],M);
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void flipUpDown(){
        result=new int[N][M];
        for(int j=0;j<N;j++){
            result[j]=Arrays.copyOf(array[N-j-1],M);
        }
    }
    public static void flipLefttoRight(){
        result=new int[N][M];
        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                result[j][i]=array[j][M-i-1];
            }
        }
    }
    public static void rotateByClockwise(){
        result=new int[M][N];

        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                //System.out.println(j+" "+i+" "+(M-j-1));
                result[i][N-j-1]=array[j][i];
            }
        }
    }
    public static void rotateByCounterClockwise(){
        result=new int[M][N];

        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                //System.out.println(j+" "+i+" "+(M-j-1));
                result[M-i-1][j]=array[j][i];
            }
        }
    }
    public static void rotatePartClockwise(){
        result=new int[N][M];
        for(int i=0;i<N/2;i++){
            for(int j=0;j<M/2;j++){
                result[i][j]=array[i+(N/2)][j];
            }
        }
        for(int i=0;i<N/2;i++){
            for(int j=M/2;j<M;j++){
                result[i][j]=array[i][j-M/2];
            }
        }
        for(int i=N/2;i<N;i++){
            for(int j=M/2;j<M;j++){
                result[i][j]=array[i-(N/2)][j];
            }
        }
        for(int i=N/2;i<N;i++){
            for(int j=0;j<M/2;j++){
                result[i][j]=array[i][j+M/2];
            }
        }
    }
    public static void rotatePartCounterClockwise(){
        result=new int[N][M];
        for(int i=0;i<N/2;i++){
            for(int j=0;j<M/2;j++){
                result[i][j]=array[i][j+M/2];
            }
        }
        for(int i=0;i<N/2;i++){
            for(int j=M/2;j<M;j++){

                result[i][j]=array[i+N/2][j];
            }
        }
        for(int i=N/2;i<N;i++){
            for(int j=M/2;j<M;j++){

                result[i][j]=array[i][j-M/2];
            }
        }
        for(int i=N/2;i<N;i++){
            for(int j=0;j<M/2;j++){
                result[i][j]=array[i-(N/2)][j];
            }
        }
    }
}
