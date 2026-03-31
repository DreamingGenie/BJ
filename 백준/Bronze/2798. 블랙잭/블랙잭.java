import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
        int qun = scan.nextInt();
        int blackjack=scan.nextInt();
        int sum=Integer.MIN_VALUE;
        int[] list= new int[qun];

        for(int i=0;i<qun;i++)
        {
           list[i] = scan.nextInt();
        }
        
        Arrays.sort(list);
        
        for(int i=0;i<qun;i++)
        {
        	for(int j=i+1;j<qun;j++)
        	{
        		for(int k=j+1;k<qun;k++)
        		{
        			int sum1=list[i]+list[j]+list[k];
                	if(sum1<=blackjack&&sum<sum1)
                		sum=sum1;
        		}
        	}
        }
        System.out.println(sum);
	}
	
}