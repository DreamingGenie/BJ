

import java.util.*;
import java.io.*;
public class Main {
	static int answer=0;
	static int[] location=new int[4];
	static boolean[] isExist = new boolean[33];
	static int[] scoreMap = {
	        0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, // 0~20 (바깥쪽)
	        13, 16, 19, // 21~23 (10번에서 꺾임)
	        22, 24,     // 24~25 (20번에서 꺾임)
	        28, 27, 26, // 26~28 (30번에서 꺾임)
	        25, 30, 35, // 29~31 (중앙 합류 지점)
	        0           // 32 (도착 지점)
	    };
	static int[] progress=new int[10];
	static int[] nextMap = new int[33];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<10;i++) {
			progress[i]=Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= 19; i++) nextMap[i] = i + 1;
        nextMap[20] = 32; // 40 다음은 도착
        nextMap[21] = 22; nextMap[22] = 23; nextMap[23] = 29; // 13-16-19-25
        nextMap[24] = 25; nextMap[25] = 29; // 22-24-25
        nextMap[26] = 27; nextMap[27] = 28; nextMap[28] = 29; // 28-27-26-25
        nextMap[29] = 30; nextMap[30] = 31; nextMap[31] = 20; // 25-30-35-40
        nextMap[32] = 32; // 도착 지점 고정
        
		bt(0,0);
		System.out.println(answer);
	}
	public static void bt(int turn,int score) {
		//System.out.println(turn+" "+score);
		if(turn>=10)
		{
			answer=Math.max(answer, score);
			return;
		}
		
		for(int j=0;j<4;j++) {
			int prevNode = location[j];
            if (prevNode == 32) continue;
            int nextNode = getNextWithBlue(prevNode);

            for (int d = 1; d < progress[turn]; d++) {
                nextNode = nextMap[nextNode];
            }
            
            if (nextNode != 32 && isExist[nextNode]) continue;

            // 백트래킹
            isExist[prevNode] = false;
            isExist[nextNode] = true;
            location[j] = nextNode;

            bt(turn + 1, score + scoreMap[nextNode]);

            // 원복
            location[j] = prevNode;
            isExist[nextNode] = false;
            isExist[prevNode] = true;
	
		}
	}
	static int getNextWithBlue(int node) {
        if (node == 5) return 21;  // 10번 칸
        if (node == 10) return 24; // 20번 칸
        if (node == 15) return 26; // 30번 칸
        return nextMap[node];
    }
	

}
