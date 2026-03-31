import java.util.Scanner;

public class Main {
	public static int[] stack;
	public static int backsize=0;
	public static int frontsize=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int ordercount = in.nextInt();
		stack=new int[ordercount];
		
		for (int i = 0; i < ordercount; i++) {
			String order=in.next();
			switch (order)
			{
			case "push":
				push(in.nextInt());
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
			case "size":
				sb.append(backsize-frontsize).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "front":
				sb.append(front()).append('\n');
				break;
			case "back":
				sb.append(back()).append('\n');
				break;
			
			}
			
		}
		System.out.println(sb);
	}
	
	static void push(int num)
	{
		stack[backsize]=num;
		backsize++;
	}
	
	static int pop()
	{
		if(backsize-frontsize!=0)
		{
			frontsize++;
			return(stack[frontsize-1]);	
		}
		else
			return (-1);
	}
	
	
	static int empty()
	{
		if(backsize-frontsize==0)
			return(1);
		else
			return(0);
	}
	
	static int front()
	{
		if(backsize-frontsize!=0)
		{
			return(stack[frontsize]);	
		}
		else
			return (-1);
	}
	
	static int back()
	{
		if(backsize-frontsize!=0)
		{
			return(stack[backsize-1]);	
		}
		else
			return (-1);
	}
}

