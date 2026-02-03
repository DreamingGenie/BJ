
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] array;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int answer=Integer.MAX_VALUE;
        int size=Integer.parseInt(input[0]);
        int goal=Integer.parseInt(input[1]);
        int start=0;
        int end=1;
        array=new int[size+1];
        array[0]=0;
        input=br.readLine().split(" ");
        for(int i=1;i<=size;i++){
            array[i]=array[i-1]+Integer.parseInt(input[i-1]);
        }
        while(start<end){
            if((array[end]-array[start])>=goal){
                answer=Math.min(answer,end-start);
                start++;
            }
            else{
                if(end<size)
                    end++;
                else
                    break;
            }

        }
        if(answer==Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(answer);
    }
}
