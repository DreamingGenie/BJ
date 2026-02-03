import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static int total=0;
    static ArrayList<Integer> comA =new ArrayList<>();
    static ArrayList<Integer> comB=new ArrayList<>();
    static int answer=Integer.MAX_VALUE;
    static ArrayList<Integer>[] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people=new int[N];
        map=new ArrayList[N];
        String[] input=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            people[i]=Integer.parseInt(input[i]);
            total+=people[i];
            map[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            int cnt = Integer.parseInt(input[0]);
            for(int j = 1; j <=cnt; j++){
                map[i].add(Integer.parseInt(input[j]));
            }
        }
        makecombi(0);
        System.out.println((answer==Integer.MAX_VALUE)?-1:answer);
    }
    public static boolean isPossible(){
        //지역구가 적절한지 판별하기
        if(comA.isEmpty()|| comA.size()==N)
            return false;
        makecomB();
        if(!bfs(comA))
            return false;
        if(!bfs(comB))
            return false;
        return true;
    }
    public static boolean bfs(ArrayList<Integer> com){
        int count=0;
        Queue<Integer> bfs=new LinkedList<>();
        boolean[] visited =new boolean[N];
        bfs.add(com.get(0));
        visited[com.get(0)-1]=true;
        while(!bfs.isEmpty()){
            int temp=bfs.poll();
            count++;
            for(int i=0;i<map[temp-1].size();i++){
                if(com.contains(map[temp - 1].get(i))&&!visited[map[temp - 1].get(i) - 1]){
                    visited[map[temp - 1].get(i) - 1]=true;
                    bfs.add(map[temp-1].get(i));
                }
            }
        }
        if(count!= com.size())
            return false;
        return true;
    }
    public static void makecombi(int index){
        //지역구 조합하기
        if(index==N)
        {
            if(isPossible()){
                todo();
            }
            return;
        }
        comA.add(index+1);
        makecombi(index+1);
        comA.remove(Integer.valueOf(index+1));

        makecombi(index+1);

    }
    public static void todo(){
        //인구수 차이 계산
        int sum=0;
        for(int i=0;i< comA.size();i++){
            sum+=people[comA.get(i)-1];
        }
        int other=total-sum;
        if(answer>Math.abs(sum-other))
            answer=Math.abs(sum-other);
    }
    public static void makecomB(){
        comB.clear();
        for(int i=1;i<=N;i++){
            if(!comA.contains(i)){
                comB.add(i);
            }
        }
    }
}
