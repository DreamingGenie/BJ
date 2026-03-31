
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(cost, value);
        }
        
        Arrays.sort(jewels, (a, b) -> a.cost - b.cost);
        
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long answer = 0;
        int jewelIdx = 0;
        
        for (int i = 0; i < K; i++) {
            while (jewelIdx < N && jewels[jewelIdx].cost <= bags[i]) {
                pq.add(jewels[jewelIdx].value);
                jewelIdx++;
            }
            
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        
        System.out.println(answer);
    }

    static class Jewel {
        int cost;
        int value;

        public Jewel(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }
}