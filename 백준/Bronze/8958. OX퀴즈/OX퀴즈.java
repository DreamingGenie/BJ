import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in= new Scanner(System.in);
		int testcase = in.nextInt();
		in.nextLine();
		for (int i = 0; i<testcase; i++)
		{
			String S = in.nextLine();
			int seq=0;
			int score=0;
			for(int j=0;j<S.length();j++)
			{
				if(S.charAt(j)=='O')
				{
					score=score+seq+1;
					seq++;
				}
				else if(S.charAt(j)=='X')
				{
					seq=0;
				}
				
			}
			System.out.println(score);
		}
		in.close();
	}

}
