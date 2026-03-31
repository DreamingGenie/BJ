import java.util.Scanner;
import java.util.Stack;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<num;i++)
		{
			String braket=scan.nextLine();
			Stack st=new Stack();
			boolean isVPS=true;
			for(int j=0;j<braket.length();j++)
			{
				if(braket.charAt(j)=='(')
					st.add('(');
				else if(braket.charAt(j)==')')
				{
					if(st.isEmpty())
					{
						isVPS=false;
						break;
					}
					else
						st.pop();
				}
			}
			if(!st.isEmpty())
				isVPS=false;
			if(isVPS==true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	
}
