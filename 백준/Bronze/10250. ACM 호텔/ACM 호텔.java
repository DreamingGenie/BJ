import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int testcase=in.nextInt();
		for(int i=0;i<testcase;i++)
		{
			int height=in.nextInt();
			int width=in.nextInt();
			int person=in.nextInt();
			//int num=person;
			int room=0;
			if(person%height==0)
				room=height*100+person/height;
			else
				room=person%height*100+person/height+1;
			System.out.println(room);
		}
	}
}