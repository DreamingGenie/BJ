import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner input = new Scanner(System.in);
        Set<Integer> rest=new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int N=input.nextInt();
            rest.add(N%42);
        }
        System.out.println(rest.size());
    }
}
