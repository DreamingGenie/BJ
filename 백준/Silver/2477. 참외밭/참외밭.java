

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int K;
    static int[][] inputarray;
    static int maxWidth=0;
    static int maxLength=0;
    static int widthIndex=0;
    static int lengthIndex=0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());
        inputarray=new int[6][2];
        String[] input;
        for(int i=0;i<6;i++){
            input=br.readLine().split(" ");
            inputarray[i][0]=Integer.parseInt(input[0]);
            inputarray[i][1]=Integer.parseInt(input[1]);
            if(inputarray[i][0]>2){
                if(maxLength<inputarray[i][1]){
                    maxLength=inputarray[i][1];
                    lengthIndex=i;
                }
            }
            else{
                if(maxWidth<inputarray[i][1]){
                    maxWidth=inputarray[i][1];
                    widthIndex=i;
                }
            }
        }
        System.out.println(calArea()*K);
    }
    public static Long calArea(){
        Long area=(long)maxWidth*(long)maxLength;
        Long minusarea=0L;
        if(((widthIndex==0&&lengthIndex!=1)||(lengthIndex==0)&&(widthIndex!=1))){
            minusarea=(long)inputarray[2][1]*(long)inputarray[3][1];
        }
        else{
            int index=Math.max(widthIndex,lengthIndex);
            minusarea=(long)inputarray[(index+2)%6][1]*(long)inputarray[(index+3)%6][1];
            //System.out.println(area+" "+minusarea+" "+inputarray[(index+2)%6][1]+" "+(long)inputarray[(index+3)%6][1]);
        }

        return area-minusarea;
    }
}
