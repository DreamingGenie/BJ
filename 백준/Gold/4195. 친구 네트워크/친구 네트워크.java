
import java.util.*;
import java.io.*;
public class Main {
	static int[] parents;
	static int[] size;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int F=Integer.parseInt(br.readLine());
			parents=new int[F*2];
			size=new int[F*2];
			
			for(int i=0;i<F*2;i++) {
				parents[i]=i;
				size[i]=1;
			}
			
			HashMap<String,Integer> map=new HashMap<>();
			int idx=0;
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<F;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				String A=st.nextToken();
				String B=st.nextToken();
				
				int Aindex=0;
				int Bindex=0;
				if(map.containsKey(A)) {
					Aindex=map.get(A);
				}
				else {
					map.put(A, idx);
					Aindex=idx;
					idx++;
				}
				if(map.containsKey(B)) {
					Bindex=map.get(B);
				}
				else {
					map.put(B, idx);
					Bindex=idx;
					idx++;
				}
				
				int result=union(Aindex,Bindex);
				sb.append(result).append("\n");
			}
			System.out.print(sb);
			
		}
	}
	static int find(int x) {
		if(parents[x]==x)
			return x;
		else
			return find(parents[x]);
	}
	static int union(int A, int B) {
		A=find(A);
		B=find(B);
		
		if(A!=B) {
			parents[B]=A;
			size[A]+=size[B];
		}
		return size[A];
	}

}
