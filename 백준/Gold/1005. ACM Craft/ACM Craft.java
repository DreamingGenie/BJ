import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int K;
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer>[] orderlist;
	static int goal;
	static int[] buildtime;
	static int[] progress;
	static int[] inDegree;
	public static void main(String[] args) throws IOException{

		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			input();
			solve();
			System.out.println(progress[goal]);
		}
		
	}
	static void solve() {
		Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            progress[i] = buildtime[i];
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
        	int temp=q.poll();
        	for(int next : orderlist[temp]) {
        		progress[next]=Math.max(progress[next], progress[temp]+buildtime[next]);
        		
        		inDegree[next]--;
        		if(inDegree[next]==0)
        			q.add(next);
        		
        	}
        }
        
	}
	static void input() throws IOException{
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		orderlist=new ArrayList[N+1];
		buildtime=new int[N+1];
		progress=new int[N+1];
		inDegree=new int[N+1];
		
		for(int i=0;i<N+1;i++){
			orderlist[i]=new ArrayList<Integer>();
		}
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++){
			buildtime[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			orderlist[first].add(second);
			inDegree[second]++;
		}
		goal=Integer.parseInt(br.readLine());
	}

}
