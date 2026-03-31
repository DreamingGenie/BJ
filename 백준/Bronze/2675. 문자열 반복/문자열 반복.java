import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in= new Scanner(System.in);
		int testcase = in.nextInt();
		for (int i = 0; i<testcase; i++)
		{
			int repeat=in.nextInt();

			String S = in.nextLine();
			for(int j=1;j<S.length();j++)
			{
				for(int k=0;k<repeat;k++)
				{
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();
		}
		in.close();
	}

}
