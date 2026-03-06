import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            //int answer=0;
            input();
            for(int i=1;i<students.length;i++){
                if(visited[i])
                    continue;
                dfs(i);

            }
            System.out.println(n-count);
        }

    }
    public static void input() throws IOException {
        n=Integer.parseInt(br.readLine());
        students=new int[n+1];
        visited=new boolean[n+1];
        finished=new boolean[n+1];
        visited[0]=true;
        count=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            students[i]=Integer.parseInt(st.nextToken());
        }
    }
    public static void dfs(int now) {
        visited[now] = true;
        int next = students[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;
                for (int temp = next; temp != now; temp = students[temp]) {
                    count++;
                }
            }
        }

        finished[now] = true;
    }
}
