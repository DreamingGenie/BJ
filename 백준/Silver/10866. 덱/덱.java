import java.util.Scanner;

public class Main {
	public static int[] stack;
	public static int backsize=0;
	public static int frontsize=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int ordercount = in.nextInt();
		stack=new int[ordercount*2];
		backsize=ordercount+1;
		frontsize=ordercount;
		
		for (int i = 0; i < ordercount; i++) {
			String order=in.next();
			switch (order)
			{
			case "push_front":
				push_front(in.nextInt());
				break;
			case "push_back":
				push_back(in.nextInt());
				break;
			case "pop_front":
				sb.append(pop_front()).append('\n');
				break;
			case "pop_back":
				sb.append(pop_back()).append('\n');
				break;
			case "size":
				sb.append(backsize-frontsize-1).append('\n');
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
	
	static void push_front(int num)
	{
		stack[frontsize]=num;
		frontsize--;
	}
	
	static void push_back(int num)
	{
		stack[backsize]=num;
		backsize++;
	}
	
	static int pop_front()
	{
		if(backsize-frontsize!=1)
		{
			frontsize++;
			return(stack[frontsize]);	
		}
		else
			return (-1);
	}
	
	static int pop_back()
	{
		if(backsize-frontsize!=1)
		{
			backsize--;
			return(stack[backsize]);	
		}
		else
			return (-1);
	}
	
	
	static int empty()
	{
		if(backsize-frontsize==1)
			return(1);
		else
			return(0);
	}
	
	static int front()
	{
		if(backsize-frontsize!=1)
		{
			return(stack[frontsize+1]);	
		}
		else
			return (-1);
	}
	
	static int back()
	{
		if(backsize-frontsize!=1)
		{
			return(stack[backsize-1]);	
		}
		else
			return (-1);
	}
}

