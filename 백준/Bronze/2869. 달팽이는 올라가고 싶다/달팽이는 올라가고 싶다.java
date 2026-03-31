import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve() {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int V = input.nextInt();

        int time=1;
        V=V-A;
        time+=V/(A-B);
        if((double)V/(A-B)>(int)V/(A-B))
            time+=1;

        System.out.println(time);
    }
}
