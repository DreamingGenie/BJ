import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dist=new int[n+1];
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE/10);
        
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<edge.length;i++){
            int first=edge[i][0];
            int second=edge[i][1];
            graph[first].add(second);
            graph[second].add(first);
        }
        
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        dist[1]=0;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int next:graph[temp]){
                if((dist[temp]+1)<dist[next]){
                    q.add(next);
                    dist[next]=dist[temp]+1;
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(max<dist[i])
            {
                max=dist[i];
                answer=1;
            }
            else if(max==dist[i]){
                answer++;
            }
            
        }
        return answer;
    }
}