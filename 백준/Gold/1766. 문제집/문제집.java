

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] sollist; 
	static int[] solve;
	static boolean[] solved;
	public static void main(String[] args) throws IOException {
		input();
	}
	public static void input() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] input=br.readLine().split(" ");
		N=Integer.parseInt(input[0]);
		M=Integer.parseInt(input[1]);
		sollist=new ArrayList[N+1];
		solve=new int[N+1];
		solved=new boolean[N+1];
		
		for(int i=0;i<N+1;i++) {
			sollist[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			sollist[A].add(B);
			solve[B]++;
		}
		int count=0;
		
		while(count<N) {
			for(int i=1;i<=N;i++) {
				if(solved[i])
					continue;
				if(solve[i]==0) {
					for(int j=0;j<sollist[i].size();j++) {
						solve[sollist[i].get(j)]--;
						
					}
					System.out.print(i+" ");
					solved[i]=true;
					count++;
					break;
				}
				
			}
			
		}
	}

}
