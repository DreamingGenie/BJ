
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int map[][] = new int[100][100];
	static boolean visited[][] = new boolean[100][100];
	static int answer = 0;
	static int x;
	static int y;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		input();
		circle();
		System.out.println(answer);
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			x = Integer.parseInt(input[0]);
			y = Integer.parseInt(input[1]);
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[y + j][x + k] = 1;
				}
			}
		}
	}

	public static void circle() {
		Queue<Integer> dfs = new LinkedList<>();
		dfs.add(y * 100 + x);
		visited[y][x] = true;
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (map[j][k] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = k + dx[d];
						int ny = j + dy[d];
						if (!isValid(nx, ny) || (map[ny][nx] == 0))
							answer++;

					}

				}
			}
		}
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && x < 100 && y >= 0 && y < 100;
	}
}
