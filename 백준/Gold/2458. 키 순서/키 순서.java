import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static boolean[][] students;
	static final int INF=Integer.MAX_VALUE/100;
	public static void main(String[] args) throws IOException{
		input();
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(students[i][k]&&students[k][j])
						students[i][j]=true;
				}
			}
		}
		
		int count=0;
		for(int i=1;i<=N;i++) {
			int know=0;
			for(int j=1;j<=N;j++) {
				if(i==j)
					continue;
				if(students[j][i]||students[i][j])
					know++;
			}
			if(know==N-1)
				count++;
			
		}
		System.out.println(count);
	}
	public static void input() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		students=new boolean[N+1][N+1];
		for(int i=0;i<N+1;i++) {
			students[i][i]=true;
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			students[from][to]=true;
			//students[to][from]=-1;
		}
	}

}
