
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static ArrayList[] orderlist;
	static boolean[] completed;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		orderlist=new ArrayList[N+1];
		completed=new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			orderlist[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int times = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = 0;
			for(int j=1;j<times;j++) {
				end=Integer.parseInt(st.nextToken());
				orderlist[end].add(start);
				start=end;
			}
		}
		boolean checker=true;
		StringBuilder sb=new StringBuilder();
		int count=0;
		while(checker) {
			checker=false;
			for(int i=1;i<=N;i++) {
				//System.out.println("try : "+i);
				if(completed[i])
					continue;
				boolean canAppear=true;
				for(int j=0;j<orderlist[i].size();j++) {
					if(!completed[(int) orderlist[i].get(j)])
					{
						canAppear=false;
						break;
					}
				}
				if(canAppear) {
					completed[i]=true;
					sb.append(i).append("\n");
					checker=true;
					count++;
					
				}
			}
			//System.out.println(count);
		}
		if(count==N)
			System.out.print(sb);
		else {
			System.out.println(0);
		}
	}
}
