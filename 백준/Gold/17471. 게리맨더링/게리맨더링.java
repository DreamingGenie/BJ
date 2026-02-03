

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static int total=0;
    //static ArrayList<Integer> comA =new ArrayList<>();
    //static ArrayList<Integer> comB=new ArrayList<>();
    static boolean[] isA;

    static int answer=Integer.MAX_VALUE;
    static ArrayList<Integer>[] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people=new int[N];
        map=new ArrayList[N];
        isA=new boolean[N];
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
        int aCnt = 0;
        int bCnt = 0;

        for(int i=0;i<N;i++){
            if(isA[i]) aCnt++;
            else bCnt++;
        }

        if(aCnt == 0 || bCnt == 0) return false;

        return bfs(true, aCnt) && bfs(false, bCnt);
    }
    public static boolean bfs(boolean target, int size){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            if(isA[i] == target){
                q.add(i);
                visited[i] = true;
                break;
            }
        }

        int count = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : map[cur]){
                next--;
                if(!visited[next] && isA[next] == target){
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        return count == size;
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
        if(index == 0){
            isA[0]=true;
            makecombi(index + 1);
            return;
        }
        isA[index] = true;
        makecombi(index + 1);

        isA[index] = false;
        makecombi(index + 1);

    }
    public static void todo(){
        //인구수 차이 계산
        int sum=0;
        for(int i=0;i< N;i++){
            if(isA[i]) sum += people[i];
        }
        int other=total-sum;
        if(answer>Math.abs(sum-other))
            answer=Math.abs(sum-other);
    }

}
