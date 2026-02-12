

import java.io.*;
import java.util.*;

public class Main{
	static int n;
	static int m;
	static int answer=Integer.MAX_VALUE;
	static int map[][];
//	static int cctv[];
	static ArrayList<CCTV> cctvList = new ArrayList<>();
	static int cctvIndex;
	static int direct[];
	static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][][] cctvModes = {
            {{0}}, // 0번
            {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}}, // 1번
            {{1,0,1,0}, {0,1,0,1}}, // 2번
            {{1,0,0,1}, {1,1,0,0}, {0,1,1,0}, {0,0,1,1}}, // 3번
            {{1,1,1,0}, {0,1,1,1}, {1,0,1,1}, {1,1,0,1}}, // 4번
            {{1,1,1,1}} // 5번
        };
	public static void main(String[] args) throws Exception{
		input();
		setCCTV(0,map);
		System.out.println(answer);
	}
	public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
    }
	public static void setCCTV(int depth,int[][] currentMap) {
		if (depth == cctvList.size()) {
            answer = Math.min(answer, getBlindSpot(currentMap));
            return;
        }
		CCTV cctv = cctvList.get(depth);
        int type = cctv.type;
		for (int i = 0; i < cctvModes[type].length; i++) {
 
            int[][] nextMap = copyMap(currentMap);

            for (int d = 0; d < 4; d++) {
                if (cctvModes[type][i][d] == 1) {
                    watch(nextMap, cctv.y, cctv.x, d);
                }
            }

            setCCTV(depth + 1, nextMap);
        }
	}
	
	public static void watch(int[][] mArr, int y, int x, int d) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        while (ny >= 0 && ny < n && nx >= 0 && nx < m && mArr[ny][nx] != 6) {
            if (mArr[ny][nx] == 0) mArr[ny][nx] = -1; 
            ny += dy[d];
            nx += dx[d];
        }
    }
	
	public static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) copy[i] = origin[i].clone();
        return copy;
    }
	
	public static int getBlindSpot(int[][] mArr) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mArr[i][j] == 0) count++;
            }
        }
        return count;
    }
	
	static class CCTV {
        int y, x, type;
        CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}


