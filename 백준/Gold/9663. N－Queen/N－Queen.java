
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static boolean[] c;
	static boolean[] bslash;
	static boolean[] slash;
	static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		c = new boolean[n];
		bslash = new boolean[2*(n-1)+1];
		slash = new boolean[2*(n-1)+1];
		
		
		dfs(0);
		System.out.println(cnt);
		
		
	}
	private static void dfs(int k) {
		if (k==n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!c[i] && !bslash[k+i] && !slash[(n-1+k-i)]) {
				c[i] = true;
				bslash[i+k] = true;
				slash[(n-1)+k-i] = true;
				dfs(k+1);
				slash[(n-1)+k-i] = false;
				bslash[i+k] = false;
				c[i] =false;
				
			}
		}
		
	}

}
