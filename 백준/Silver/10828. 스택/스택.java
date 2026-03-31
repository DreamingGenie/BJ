import java.util.Scanner;

public class Main {
	public static int[] stack;
	public static int size=0;
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
				sb.append(size).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "top":
				sb.append(top()).append('\n');
				break;
			
			}
			
		}
		System.out.println(sb);
	}
	
	static void push(int num)
	{
		stack[size]=num;
		size++;
	}
	
	static int pop()
	{
		if(size!=0)
		{
			size--;
			return(stack[size]);	
		}
		else
			return (-1);
	}
	
	
	static int empty()
	{
		if(size==0)
			return(1);
		else
			return(0);
	}
	
	static int top()
	{
		if(size!=0)
			return stack[size-1];
		else
			return (-1);
	}
}

