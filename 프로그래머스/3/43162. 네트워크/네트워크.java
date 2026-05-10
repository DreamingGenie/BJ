import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n+1];
        graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(computers[i][j]==0)
                    continue;
                graph[i+1].add(j+1);
            }
        }
        
        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            Queue<Integer> q=new ArrayDeque<>();
            q.add(i);
            visited[i]=true;
            answer++;
            while(!q.isEmpty()){
                int temp=q.poll();
                for(int j=0;j<graph[temp].size();j++){
                    int next=graph[temp].get(j);
                    if(!visited[next]){
                        q.add(next);
                        visited[next]=true;
                    }
                }
            }
        }
        return answer;
    }
}