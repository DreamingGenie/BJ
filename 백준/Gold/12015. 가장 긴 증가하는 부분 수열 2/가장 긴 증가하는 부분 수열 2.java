
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] array=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> part=new ArrayList<>();
		part.add(array[0]);
		
		for(int i=1;i<N;i++) {
			int lastVal = part.get(part.size() - 1);
			if(lastVal<array[i]) {
				part.add(array[i]);
			}
			else {
				int index=findindex(array[i],part);
				part.set(index,array[i]);
				
			}
		}
		System.out.println(part.size());
	}
	public static int findindex(int value, ArrayList<Integer> part) {
		int start=0;
		int end=part.size()-1;
		while(start<end) {
			int middle=(start+end)/2;
			if(value>part.get(middle)) {
				start=middle+1;
			}
			else
				end=middle;
			
			
		}
		return end;
	}

}
