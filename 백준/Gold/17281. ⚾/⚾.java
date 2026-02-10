
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] order = new int[9];
	static int inning;
	static int[][] result;
	static int answer=0;
	public static void main(String[] args) throws Exception{
		input();
		makeperm(0);
		System.out.println(answer);
	}
	
	public static void input() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		inning=Integer.parseInt(br.readLine());
		result=new int[inning][9];
		for(int i=0;i<inning;i++) {
			String[] input=br.readLine().split(" ");
			for(int j=0;j<9;j++) {
				result[i][j]=Integer.parseInt(input[j]);
			}
		}
	}

	static boolean[] visited=new boolean[10];
	public static void makeperm(int index) {
		if(index==9) {
			//answer++;
			calculate();
			return;
			
		}
		if(index==3) {
			order[index]=1;
			makeperm(index+1);
			return;
		}
		for(int i=2;i<10;i++) {
			//System.out.println(index+" "+i);
			if(!visited[i]) {
				visited[i]=true;
				order[index]=i;
				makeperm(index+1);
				visited[i]=false;
			}
		}
	}
	public static void calculate() {
		int score=0;
		int curHitterIdx=0;
		for (int i = 0; i < inning; i++) {
	        int outcount = 0;
	        // 주자 상황을 3개의 boolean으로 관리 (매 이닝 초기화)
	        boolean b1 = false, b2 = false, b3 = false;

	        while (outcount < 3) {
	            int playerNum = order[curHitterIdx]; // 현재 타순의 선수 번호
	            int hit = result[i][playerNum - 1]; // 그 선수의 이닝 결과

	            if (hit == 0) {
	                outcount++;
	            } else if (hit == 1) { // 안타
	                if (b3) score++;
	                b3 = b2; b2 = b1; b1 = true;
	            } else if (hit == 2) { // 2루타
	                if (b3) score++;
	                if (b2) score++;
	                b3 = b1; b2 = true; b1 = false;
	            } else if (hit == 3) { // 3루타
	                if (b3) score++;
	                if (b2) score++;
	                if (b1) score++;
	                b3 = true; b2 = false; b1 = false;
	            } else if (hit == 4) { // 홈런
	                if (b3) score++;
	                if (b2) score++;
	                if (b1) score++;
	                score++;
	                b1 = b2 = b3 = false;
	            }
	            curHitterIdx = (curHitterIdx + 1) % 9;
	        }
	    }
		answer=Math.max(score, answer);
		
		
	}

}
