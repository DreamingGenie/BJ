

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int answer=0;
	//static int move=0;
	static int sharksize=2;
	static int eatcount=0;
	static int[] start=new int[2];
	static int[] dx= {0,-1,1,0};
	static int[] dy= {-1,0,0,1};
	public static void main(String[] args) throws IOException{
		input();
		find();
		System.out.println(answer);
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int y=0;y<N;y++) {
			String[] input=br.readLine().split(" ");
			for(int x=0;x<N;x++) {
				map[y][x]=Integer.parseInt(input[x]);
				if(map[y][x]==9) {
					map[y][x]=0;
					start[0]=x;
					start[1]=y;
				}
			}
		}
	}
	public static boolean find() {
		boolean isfind=false;
		visited=new boolean[N][N];
		PriorityQueue<Dot> pq=new PriorityQueue<>();
		//Queue<Dot> queue=new LinkedList<>();
		//System.out.println("1");
		visited[start[1]][start[0]]=true;
		pq.offer(new Dot(start[0],start[1],0));
		while(!pq.isEmpty()) {
			Dot temp=pq.poll();

			for(int d=0;d<4;d++) {
				//System.out.println("4");
				int nx=temp.x+dx[d];
				int ny=temp.y+dy[d];
				if(isValid(nx,ny)&&map[ny][nx]<=sharksize&&!visited[ny][nx]) {
					visited[ny][nx]=true;
					pq.offer(new Dot(nx,ny,temp.distance+1));
				}			
			}
			if(pq.isEmpty())
				break;
			temp=pq.poll();
			if(map[temp.y][temp.x]<sharksize&&map[temp.y][temp.x]!=0) {
				//System.out.println(temp.y+" "+temp.x+" "+map[temp.y][temp.x]);
				map[temp.y][temp.x]=0;
				//printmap();
				eatcount++;
				answer+=temp.distance;
				if(eatcount>=sharksize) {
					sharksize++;
					eatcount=0;
				}
				pq.clear();
				visited=new boolean[N][N];
				pq.offer(new Dot(temp.x,temp.y,0));
				visited[temp.y][temp.x]=true;	
				continue;
			}
			else {
				pq.offer(temp);
			}
		}
		
		//System.out.println("2");
		
		return isfind;	
	}

	public static void printmap() {
		System.out.println("============");
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isValid(int x,int y) {
		return (x>=0&&x<N&&y>=0&&y<N);
	}
	
	public static class Dot implements Comparable<Dot>{
		int x;
		int y;
		int distance;
		public Dot(int x,int y,int distance) {
			this.x=x;
			this.y=y;
			this.distance=distance;
		}
		
		@Override
		public int compareTo(Dot other) {
	        if (this.distance != other.distance) {
	            return Integer.compare(this.distance, other.distance);
	        }
	        if (this.y != other.y) {
	            return Integer.compare(this.y, other.y);
	        }
	        return Integer.compare(this.x, other.x);
	    }
		
	}

}