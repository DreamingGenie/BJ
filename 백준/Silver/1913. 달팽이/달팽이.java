

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int find=Integer.parseInt(br.readLine());
		one(N,find);
	}
	public static void one(int N,int find) {
		int x=N/2;
		int y=N/2;
		int now=0;
		int distance=1;
		int origin=distance;
		int[] dx= {-1,0,1,0};
		int[] dy= {0,-1,0,1};
		int[][] arr=new int[N][N];
		for(int i=1;i<=N*N;i++) {
			//System.out.println(i+" "+x+" "+y+(Math.sqrt(i)%1==0));
			arr[y][x]=i;
			if(i!=1&&Math.sqrt(i)%1==0)
			{
				origin+=1;
			}
			else {
				distance--;
				if(distance==0) {
					now=(now+1)%4;
					distance=origin;
				}
			}
			x=x+dx[now];
			y=y+dy[now];
			/*
			for(int ny=0;ny<5;ny++) {
				for(int nx=0;nx<5;nx++) {
					System.out.print(arr[ny][nx]+" ");
				}
				System.out.println();
			}
			*/

		}
		StringBuilder sb= new StringBuilder();
		int findx=0;
		int findy=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				if(arr[i][j]<10)
//					System.out.print(" ");
				sb.append(arr[i][j]+" ");
				if(arr[i][j]==find) {
					findx=j+1;
					findy=i+1;
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.println(findy+" "+findx);
	}

}
