

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] sollist; 
	static int[] solve;
	

	public static void main(String[] args) throws IOException {
		input();
	}
	public static void input() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		N=Integer.parseInt(br.readLine());
		sollist=new ArrayList[N*2+1];
		solve=new int[N*2+1];
		for(int i=0;i<N*2+1;i++) {
			sollist[i]=new ArrayList<>();
		}
		HashMap<String,Integer> itemmap=new HashMap<>();
		String[] keyarr=new String[N*2+1];
		int keyindex=1;
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			String A=(st.nextToken());
			String B=(st.nextToken());
			int keyA=0;
			int keyB=0;
			if(itemmap.containsKey(A))
				keyA=itemmap.get(A);
			else {
				keyA=keyindex;
				keyarr[keyindex]=A;
				itemmap.put(A,keyindex++);
				
			}
			if(itemmap.containsKey(B))
				keyB=itemmap.get(B);
			else {
				keyB=keyindex;
				keyarr[keyindex]=B;
				itemmap.put(B,keyindex++);
			}
			//System.out.println(keyA+" "+keyB);
			sollist[keyA].add(keyB);
			solve[keyB]++;
		}
		
		int count=0;
		StringBuilder sb=new StringBuilder();
		Queue<String> currentLevel = new PriorityQueue<>();
		for(int i=1;i<keyindex;i++) {
			if(solve[i]==0)
				currentLevel.add(keyarr[i]);
		}
		while(!currentLevel.isEmpty()) {
			ArrayList<String> nextLevelCandidates = new ArrayList<>();
			while(!currentLevel.isEmpty()){
				count++;
				String currStr = currentLevel.poll();
				sb.append(currStr).append("\n");       
				int currIdx = itemmap.get(currStr);
				for (int nextIdx : sollist[currIdx]) {
					solve[nextIdx]--;
					if (solve[nextIdx] == 0) {
						nextLevelCandidates.add(keyarr[nextIdx]);
					}
				}
			}
			currentLevel.addAll(nextLevelCandidates);
		}
		System.out.println((keyindex>count+1)?"-1":sb);
	}
}
