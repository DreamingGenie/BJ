import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution
{
    static int N;
    static int[][] map;
    static boolean[][] visited;


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int bfs(int sx, int sy, int ex, int ey) {
        Queue<Node> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new Node(sx, sy, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == ex && cur.y == ey) {
                return cur.time;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 1) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.time + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            String[] start = br.readLine().split(" ");
            int A = Integer.parseInt(start[0]);
            int B = Integer.parseInt(start[1]);

            String[] end = br.readLine().split(" ");
            int C = Integer.parseInt(end[0]);
            int D = Integer.parseInt(end[1]);

            int result = bfs(A, B, C, D);
            System.out.println("#" + tc + " " + result);
        }
    }
}