import java.util.Scanner;
public class Main {
	public static int g, p;
    public static int[] parent;
    
    public static void main(String[] argc){
       
    	Scanner in=new Scanner(System.in);
        g = in.nextInt();
        p = in.nextInt();
        parent = new int[g + 1];

        // 초기값 설정
        for (int i = 0; i <= g ; i++) {
            parent[i] = i;
        }
        
        int count = 0;
        
        for (int i = 0; i < p ; i++) {
            int now = in.nextInt();
            
            int p = find(now);
            if(p != 0){
                union(p, p - 1);
                count++;
            }
            else
                break;
        }
        
        System.out.println(count);
    }
    
    
    public static int find(int now) {
        if(now == parent[now])
            return now;
        return parent[now] = find(parent[now]);
    }
    
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[x] = y;  	
        }
    }

}
