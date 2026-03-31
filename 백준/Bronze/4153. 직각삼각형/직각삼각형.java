import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
        
        while(true)
        {
        	int line1=in.nextInt();
            int line2=in.nextInt();
            int line3=in.nextInt();
            
            if(line1==0&&line2==0&&line3==0)
            {
            	break;
            }
           
            if((line1*line1+line2*line2)==(line3*line3)
            		||(line3*line3+line2*line2)==(line1*line1)
            		||(line1*line1+line3*line3)==(line2*line2))
            {
            	System.out.println("right");
            }
            else
            	System.out.println("wrong");
        }
        
	}
	
}