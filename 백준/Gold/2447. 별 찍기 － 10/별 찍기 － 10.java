

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] array;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        array=new int[N][N];
        draw(0,0,N);
        print();
    }
    public static void draw(int r,int c,int size){
        if(size==1){
            array[r][c]=1;
            return;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!(i==1&&j==1)){
                    draw(r+i*size/3,c+j*size/3,size/3);
                }
            }
        }
    }
    public static void print(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j]==1)
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
