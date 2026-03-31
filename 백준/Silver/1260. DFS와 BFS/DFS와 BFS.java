import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


public class Main {
	static int[][] status;
	static boolean[] mark;
	static int node;
	static int edge;
	static int start;
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		node=in.nextInt();
		edge=in.nextInt();
		start=in.nextInt();
		
		status = new int[1001][1001];
		mark = new boolean[1001];
		
		for(int i= 0;i<edge;i++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			status[x][y]=status[y][x]=1;
		}
		dfs1(start);
		System.out.println();
		mark=new boolean[1001];
		
		bfs();
		System.out.println();
		
		
	}
	
	public static void dfs1(int now)//재귀함수
	{
		mark[now]=true;
		System.out.print(now + " ");
		for(int i=1;i<=node;i++)
		{
			if(status[now][i]==1&&mark[i]==false)
			{
				dfs1(i);
			}
		}
	}
	
	public static void bfs()
	{
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.offer(start);
		mark[start]=true;
		System.out.print(start + " ");
		
		while(!queue.isEmpty())
		{
			int temp=queue.poll();
			
			for(int i=1;i<=node;i++)
			{
				if(status[temp][i]==1&&mark[i]==false)
				{
					queue.offer(i);
					mark[i]=true;
					System.out.print(i+" ");
				}
			}
		}
		
	}

}
