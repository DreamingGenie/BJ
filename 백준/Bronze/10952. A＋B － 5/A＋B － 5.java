import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in= new Scanner(System.in);
		//int testcase = in.nextInt();
		while (in.hasNextInt())
		{
			int a= in.nextInt();
			int b= in.nextInt();
			if(a==0&&b==0)
				break;
			System.out.println(a+b);
		}
		in.close();
	}
}
