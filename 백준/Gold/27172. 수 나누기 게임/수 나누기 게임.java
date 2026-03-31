import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int max=0;
		int[] cards=new int[N+1];
		int[] scores=new int[N+1];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			cards[i]=Integer.parseInt(st.nextToken());
			max=Math.max(max, cards[i]);
		}
		
		int[] indexs=new int[max+1];
		for(int i=1;i<=N;i++) {
			indexs[cards[i]]=i;
		}
		for(int i=1;i<=N;i++) {
			int now=cards[i];
			for(int j=now*2;j<=max;j+=now) {
				if(indexs[j]!=0)
				{	
					scores[i]++;
					scores[indexs[j]]--;
				}
				
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(scores[i]).append(" ");
		}
		System.out.println(sb);
	}
}
