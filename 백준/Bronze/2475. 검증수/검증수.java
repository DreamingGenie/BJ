import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve()
    {
        Scanner input = new Scanner(System.in);
        int n = 0;
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            n = input.nextInt();
            sum+=n*n;

        }
        System.out.println(sum%10);
    }
}
