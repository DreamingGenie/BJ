import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N을 6으로 나눈 나머지 값에 따라 공식이 달라짐
        int remainder = N % 6;

        if (remainder != 2 && remainder != 3) {
            for (int i = 1; i <= N / 2; i++) sb.append(2 * i).append("\n");
            for (int i = 1; i <= (N + 1) / 2; i++) sb.append(2 * i - 1).append("\n");
        } 
        else if (remainder == 2) {
            for (int i = 1; i <= N / 2; i++) sb.append(2 * i).append("\n");
            
            sb.append(3).append("\n");
            sb.append(1).append("\n");
            for (int i = 3; i <= (N / 2) - 1; i++) sb.append(2 * i + 1).append("\n");
            sb.append(5).append("\n");
        } 
        else if (remainder == 3) {
            for (int i = 2; i <= N / 2; i++) sb.append(2 * i).append("\n");
            sb.append(2).append("\n");
            
            for (int i = 2; i <= N / 2; i++) sb.append(2 * i + 1).append("\n");
            sb.append(1).append("\n");
            sb.append(3).append("\n");
        }

        System.out.print(sb);
    }
}