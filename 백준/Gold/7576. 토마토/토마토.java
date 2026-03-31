import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int[][] status;
	static boolean[] mark;
	static int node;
	static int width;
	static int height;
	static boolean end;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		width = in.nextInt();
		height = in.nextInt();
		node = width * height;

		status = new int[height + 1][width + 1];
		mark = new boolean[node + 1];
		end = false;
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int h = 1; h <= height; h++) {
			for (int w = 1; w <= width; w++) {
				status[h][w] = in.nextInt();
				if (status[h][w] == 1)
				{
					queue.offer(h * width + w - width);
					mark[h * width + w - width]=true;
				}

			}
		}
		int a=0;
		while (!queue.isEmpty()) {

			int temp = queue.poll();
			//System.out.println("poll "+ temp);
			int x = temp % width;
			int y = temp / width+1;
			if(x==0)
			{
				x=width;
				y-=1;
			}

			//System.out.println(x+" "+y);
			//System.out.println(temp+" "+now);
			
			if (x-1>=1&&status[y][x - 1] == 0) {
				status[y][x - 1] = status[y][x]+1;
				//System.out.println(x-1+" "+y);
				queue.offer(temp - 1);
				//int a = temp-1;
				//System.out.println("offer1 "+ a);
			}
			if (x+1<=width&&status[y][x + 1] == 0) {
				status[y][x + 1] = status[y][x]+1;
				queue.offer(temp + 1);
				//int a = temp+1;
				//System.out.println("offer2 "+ a);
			}
			if (y-1>=1&&status[y - 1][x] == 0) {
				status[y - 1][x] = status[y][x]+1;
				queue.offer(temp - width);
				//int a = temp-width;
				//System.out.println("offer3 "+ a);
			}
			if (y+1<=height&&status[y + 1][x] == 0) {
				status[y + 1][x] = status[y][x]+1;
				queue.offer(temp + width);
				//int a = temp + width;
				//System.out.println("offer4 "+ a);
				//System.out.println(x+" "+y);
			}
			//System.out.println(a);
			//print1();
			//a++;
		}
		end();
		
	}
	

	public static void end() {
		
		int max = 0;
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if (status[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				if(max<status[i][j])
					max=status[i][j];
			}
		}

		System.out.println(max - 1);

	}
	
	public static void print1() {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j < width; j++) {
                System.out.print(status[i][j] + " ");
            }
            System.out.println(1);
        }
    }

}
