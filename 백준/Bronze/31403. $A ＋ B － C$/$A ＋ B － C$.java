import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();

        int sumint=A+B-C;
        String sumstr=Integer.toString(A)+Integer.toString(B);
        int sumstrint=Integer.parseInt(sumstr)-C;
        System.out.println(sumint);
        System.out.println(sumstrint);
    }
}
