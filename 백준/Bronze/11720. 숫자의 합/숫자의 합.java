import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in= new Scanner(System.in);
		int testcase = in.nextInt();
		in.nextLine();
		int sum=0;
		String line=in.nextLine();
		for (int i=0;i<line.length();i++)
		{
			char ctemp=line.charAt(i);
			int temp=Integer.parseInt(String.valueOf(ctemp));
			sum+=temp;
			
		}
		System.out.println(sum);
		in.close();
	}

}
