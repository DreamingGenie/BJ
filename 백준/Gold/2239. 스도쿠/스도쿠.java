

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku;
    static boolean isprint=false;
    public static void main(String[] args) throws IOException {
        input();
        solve(0);

    }
    public static void solve(int index){
        if(isprint){
            return;
        }
        if(index>80){
            isprint=true;
            print();
            return;
        }
        int x=index%9;
        int y=index/9;
        //System.out.println(y+" "+x);
        if(sudoku[y][x]!=0) {
            solve(index + 1);
            return;
        }
        for(int i=1;i<=9;i++){
            if(checkbox(x,y,i)&&checkcol(x,y,i)&&checkrow(x,y,i)){
                sudoku[y][x]=i;
                solve(index+1);
                sudoku[y][x]=0;
            }
        }
    }
    public static void print(){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[i].length;j++){
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean isValid(int x, int y){
        return (x>=0&&x<9&&y>=0&&y<9);
    }
    public static boolean checkrow(int x,int y,int value){

        for(int i=0;i<9;i++){
            if(i==x)
                continue;
            if(value==sudoku[y][i]){
                return false;
            }
        }
        return true;
    }
    public static boolean checkcol(int x,int y,int value){
        for(int i=0;i<9;i++){
            if(i==y)
                continue;
            if(value==sudoku[i][x]){
                return false;
            }
        }
        return true;
    }
    public static boolean checkbox(int x,int y,int value){
        int boxy=y/3;
        int boxx=x/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int tempx=j+boxx*3;
                int tempy=i+boxy*3;

                if(tempx==x&&tempy==y){
                    continue;
                }
                if(value==sudoku[tempy][tempx]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = chars[j] - '0';
            }
        }
    }
}
