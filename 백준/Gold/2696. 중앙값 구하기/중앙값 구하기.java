import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N=Integer.parseInt(br.readLine());
//			ArrayList<Integer> middlelist=new ArrayList<>();
			PriorityQueue<Integer> minheap=new PriorityQueue<>();
			PriorityQueue<Integer> maxheap=new PriorityQueue<>(Comparator.reverseOrder());
			System.out.println(N/2+1);
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				if(i%10==1&&i!=1)
					st=new StringTokenizer(br.readLine());
				int input=Integer.parseInt(st.nextToken());
				add(input,maxheap,minheap);
				if(i%2==1)
					System.out.print(maxheap.peek()+" ");
			}
			System.out.println();
			
		}
	}
	public static void add(int input, PriorityQueue<Integer> maxheap, PriorityQueue<Integer> minheap) {
		maxheap.add(input);
		if(!minheap.isEmpty()&&minheap.peek()<maxheap.peek()) {
			int tempA=minheap.poll();
			int tempB=maxheap.poll();
			minheap.add(tempB);
			maxheap.add(tempA);
		}
		if(minheap.size()+1>maxheap.size())
			maxheap.add(minheap.poll());
		else if(maxheap.size()>minheap.size()+1) {
			minheap.add(maxheap.poll());
		}
	}
	

}
