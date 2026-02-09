

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static char[][] map=new char[12][6];
	static int answer=0;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		input();
		while(true) {
			ArrayList<Puyo> list=find();
			//System.out.println(list.size());
			if(list.size()==0)
				break;
			
			delete(list);
			//printmap();
			answer++;
		}
		System.out.println(answer);
		
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int y=0;y<12;y++) {
			String input=br.readLine();
			for(int x=0;x<6;x++) {
				map[y][x]=input.charAt(x);
			}
		}
	}
	public static ArrayList<Puyo> find() {
		ArrayList<Puyo> list=new ArrayList<>();
		Queue<Puyo> bfs=new LinkedList<>();
		Queue<Puyo> save=new LinkedList<>();
		boolean[][] visited=new boolean[12][6];
		for(int y=0;y<12;y++) {
			for(int x=0;x<6;x++) {
				//System.out.println(answer+" "+y+" "+x);
				char flag=map[y][x];
				if(flag=='.')
					continue;
				bfs.clear();
				save.clear();
				visited[y][x]=true;
				bfs.offer(new Puyo(x,y));
				save.offer(new Puyo(x,y));
				//System.out.println(save.size());
				while(!bfs.isEmpty()) {
					
					Puyo temp=bfs.poll();
					for(int d=0;d<4;d++) {
						int nx=temp.x+dx[d];
						int ny=temp.y+dy[d];
						//System.out.println(isValid(nx,ny)+"  "+!visited[y][x]);
						if(isValid(nx,ny)&&map[ny][nx]==flag&&!visited[ny][nx]) {
							visited[ny][nx]=true;
							bfs.offer(new Puyo(nx,ny));
							save.offer(new Puyo(nx,ny));						
							//System.out.println(save.size());
						}
					}
				}
				if(save.size()>=4) {
					while(!save.isEmpty()) {
						list.add(save.poll());
						
					}
				}
				
			}
		}
		//System.out.println("11");
		
		return list;
		
	}
	public static void printmap() {
		for(int y=0;y<12;y++) {
			for(int x=0;x<6;x++) {
				//System.out.println(answer+" "+y+" "+x);
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isValid(int x,int y) {
		return (x>=0&&x<6&&y>=0&&y<12);
	}
	public static void delete(ArrayList<Puyo> list) {
		for(int i=0;i<list.size();i++) {
			Puyo temp=list.get(i);
			map[temp.y][temp.x]='.';
		}
//		printmap();
//		System.out.println("+=======");
		for(int x=0;x<6;x++) {
			for (int y=11;y>=0;y--) {
				if(map[y][x]=='.') {
					boolean early=true;
					for(int ny=y-1;ny>=0;ny--) {
						if(map[ny][x]!='.') {
							early=false;
							map[y][x]=map[ny][x];
							map[ny][x]='.';
							break;
						}
//						printmap();
//						System.out.println("+=======");
					}
					if(early)
						break;
				}
			}
		}
	}
	public static class Puyo{
		int x;
		int y;
		public Puyo(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}
