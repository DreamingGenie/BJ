import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner in= new Scanner(System.in);
		int qun = in.nextInt();
		//in.nextLine();
		
		int max= Integer.MIN_VALUE;
		int min= Integer.MAX_VALUE;
		for (int i = 0; i< qun ; i++)
		{
			int num1 = in.nextInt();
			if(num1>max)
				max=num1;
			if(num1<min)
				min=num1;
		}
		System.out.printf("%d %d", min,max);
		in.close();
	}

}
