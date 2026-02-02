import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] area = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for (int y = 0; y <= N - M; y++) {
                for (int x = 0; x <= N - M; x++) {
                    int sum = 0;

                    for (int b = 0; b < M; b++) {
                        for (int a = 0; a < M; a++) {
                            sum += area[y + b][x + a];
                        }
                    }

                    if (sum > max) {
                        max = sum;
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
