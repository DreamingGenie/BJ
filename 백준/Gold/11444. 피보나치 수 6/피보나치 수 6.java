import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(br.readLine());
		
        long[][] ans = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};
        while(n>0) {
			if(n%2==1) {
				ans=multiply(ans,base);
			}
			base=multiply(base,base);
			n/=2;
		}
        System.out.println(ans[1][0]);
	}
	static long[][] multiply(long[][] a, long[][] b){
		long[][] result=new long[2][2];
		for(int x=0;x<2;x++) {
			for(int y=0;y<2;y++) {
				for(int z=0;z<2;z++) {
					result[x][y]+=a[x][z]*b[z][y];
					result[x][y]%=1000000007;
				}
			}
		}
		
		return result;
	}

}
