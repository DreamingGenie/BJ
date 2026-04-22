import java.util.*;
class Solution {
    public int solution(String[] board) {
        int h=board.length;
        int w=board[0].length();
        int goalX=0;
        int goalY=0;
        char[][] map=new char[h][w];
        boolean[][] visited=new boolean[h][w];
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        Queue<State> q=new ArrayDeque<>();
        for(int i=0;i<h;i++){
            char[] temp=board[i].toCharArray();
            for(int j=0;j<w;j++){
                map[i][j]=temp[j];
                if(map[i][j]=='R')
                {
                    q.add(new State(j,i,0));
                    visited[i][j]=true;
                }
                else if(map[i][j]=='G'){
                    goalX=j;
                    goalY=i;
                }
            }
        }
        
        int answer = -1;
        while(!q.isEmpty()){
            State temp=q.poll();
            int tx=temp.x;
            int ty=temp.y;
            if(tx==goalX&&ty==goalY)
            {
                
                return temp.time;
            }
            for(int d=0;d<4;d++){
                int dist=1;
                int nx=tx+dx[d];
                int ny=ty+dy[d];
                if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                if(map[ny][nx] == 'D') continue;
                while(true){
                    if((nx+dx[d])>=w||(ny+dy[d])>=h||(nx+dx[d])<0||(ny+dy[d])<0||map[ny+dy[d]][nx+dx[d]]=='D')
                        break;
                    nx+=dx[d];
                    ny+=dy[d];
                }
                if(!visited[ny][nx]){
                    visited[ny][nx]=true;
                    q.add(new State(nx,ny,temp.time+1));
                }
                
            }
        }
        return answer;
    }
    public class State{
        int x;
        int y;
        int time;
        public State(int x, int y, int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
}