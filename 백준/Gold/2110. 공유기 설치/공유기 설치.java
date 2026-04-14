
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int[] houses=new int[N];
		for(int i=0;i<N;i++) {
			houses[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		int start=0;
		int end=houses[N-1]-houses[0];
		int result=0;
		while(start<=end) {
			int mid=(start+end)/2;
			int count=1;
			int curr=houses[0];

			for(int i=1;i<N;i++) {
				if((houses[i]-curr)<mid)
					continue;
				count++;
				curr=houses[i];
			}
			if(count>=C)
			{
				result=mid;
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		System.out.println(result);
	}

}
