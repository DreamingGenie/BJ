import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr=new int[9];
		for(int i=0;i<9;i++)
		{
			arr[i]=in.nextInt();
		}
		int max=-9999;
		int maxindex=-1;
		for(int i=0;i<9;i++)
		{
			if(arr[i]>max)
			{
				maxindex=i;
				max=arr[i];
			}
				
		}
		System.out.println(max);
		System.out.println(maxindex+1);

	}

}
