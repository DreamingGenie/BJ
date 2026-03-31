import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in= new Scanner(System.in);
		while(true)
		{
			int temp=in.nextInt();
			if(temp==0)
				break;
			String Stemp=String.valueOf(temp);
			char[] list=Stemp.toCharArray();
			boolean isSame=true;
			int end=Stemp.length();
			for(int i=0;i<end/2;i++)
			{
				if(list[i]!=list[end-i-1])
					isSame=false;
			}
			if(isSame==true)
				System.out.println("yes");
			else
				System.out.println("no");
		}
		
	}

}
