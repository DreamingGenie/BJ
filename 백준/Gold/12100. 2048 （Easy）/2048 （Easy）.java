import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int maxBlock = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, grid);

        StringBuilder sb = new StringBuilder();
        sb.append(maxBlock);
        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int[][] currentGrid) {
        if (depth == 5) {
            maxBlock = Math.max(maxBlock, findMax(currentGrid));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] nextGrid = copyGrid(currentGrid);

            for (int r = 0; r < i; r++) {
                nextGrid = rotate90(nextGrid);
            }

            slideDown(nextGrid);

            dfs(depth + 1, nextGrid);
        }
    }

    public static void slideDown(int[][] grid) {
        for (int i = 0; i < n; i++) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                if (grid[j][i] != 0) {
                    stack.addLast(grid[j][i]);
                }
            }

            int index = n - 1;
            while (!stack.isEmpty()) {
                int temp = stack.pollLast();
                if (!stack.isEmpty() && temp == stack.peekLast()) {
                    temp += stack.pollLast();
                }
                grid[index--][i] = temp;
            }

            while (index >= 0) {
                grid[index--][i] = 0;
            }
        }
    }

    public static int[][] rotate90(int[][] m) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = m[i][j];
            }
        }
        return temp;
    }

    public static int findMax(int[][] grid) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }

    public static int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }
}
