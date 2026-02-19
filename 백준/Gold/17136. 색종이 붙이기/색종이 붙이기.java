import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R = 10;
    static int C = 10;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[] paper = new int[]{5, 5, 5, 5, 5};
    static int total = 0;

    public static void main(String[] args) throws Exception {
        input();
        if (total == 0) {
            System.out.println(0);
            return;
        }
        dfs(0, 0); 
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(int index, int level) {
        // 현재 사용량이 이미 최솟값 이상이면 중단
        if (level >= answer) return;

        // 1을 모두 덮었을 때
        if (total == 0) {
            answer = Math.min(answer, level);
            return;
        }

        // 범위를 벗어났을 때
        if (index == 100) return;

        int j = index / 10;
        int i = index % 10;

        if (map[j][i] == 1) {
            for (int p = 4; p >= 0; p--) { // 큰 종이부터
                if (paper[p] > 0 && canpatch(i, j, p)) {
                    patch(i, j, p);
                    paper[p]--;
                    total -= (p + 1) * (p + 1);
                    
                    dfs(index + 1, level + 1);
                    
                    dispatch(i, j, p);
                    paper[p]++;
                    total += (p + 1) * (p + 1);
                }
            }
        } else {
            dfs(index + 1, level);
        }
    }

    public static boolean canpatch(int i, int j, int p) {
        if (j + p >= 10 || i + p >= 10) return false;
        for (int y = 0; y < p + 1; y++) {
            for (int x = 0; x < p + 1; x++) {
                if (map[y + j][x + i] != 1) return false;
            }
        }
        return true;
    }

    public static void patch(int i, int j, int p) {
        for (int y = 0; y < p + 1; y++) {
            for (int x = 0; x < p + 1; x++) {
                map[y + j][x + i] = 0;
            }
        }
    }

    public static void dispatch(int i, int j, int p) {
        for (int y = 0; y < p + 1; y++) {
            for (int x = 0; x < p + 1; x++) {
                map[y + j][x + i] = 1;
            }
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) total++;
            }
        }
    }
}