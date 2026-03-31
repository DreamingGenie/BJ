import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long start=Long.parseLong(st.nextToken());
		long end=Long.parseLong(st.nextToken());
		
		
		System.out.println(count(end)-count(start-1));
	}
	static long count(long end) {
		if (end <= 0) return 0;
		
		long value=0;
		for(long i=1;i<=end;i*=2) {
			long cycle=i*2;
			value+=(end+1)/cycle*i;
			
			long remain=(end+1)%cycle;
			if(remain>i)
				value+=remain-i;
		}
		return value;
	}

}
