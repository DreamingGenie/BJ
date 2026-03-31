import java.util.*;
import java.io.*;

public class Main {
    static int LED;
    static int[] state; // boolean보다 int가 문제 상황(0,1) 출력에 더 직관적입니다.
    static int students;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LED = Integer.parseInt(br.readLine());
        state = new int[LED + 1]; // 1번부터 사용하기 위해 LED+1 크기로 설정
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= LED; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }
        
        students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if (sex == 1) { // 남학생
                for (int j = num; j <= LED; j += num) {
                    state[j] = state[j] == 0 ? 1 : 0;
                }
            } else { // 여학생
                state[num] = state[num] == 0 ? 1 : 0; // 중심은 무조건 변경
                int left = num - 1;
                int right = num + 1;
                while (left >= 1 && right <= LED && state[left] == state[right]) {
                    state[left] = state[left] == 0 ? 1 : 0;
                    state[right] = state[right] == 0 ? 1 : 0;
                    left--;
                    right++;
                }
            }
        }
    }

    public static void solve() {
        // 입력부에서 학생 처리를 동시에 하도록 통합했습니다.
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= LED; i++) {
            sb.append(state[i]).append(" ");
            if (i % 20 == 0) { // 20개마다 줄바꿈
                sb.append("\n");
            }
        }
        System.out.print(sb.toString().trim()); // 마지막 불필요한 공백 제거
        System.out.println();
    }
}