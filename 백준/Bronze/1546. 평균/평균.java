import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] scorelist =new int[n];
        int max=0;
        for (int i = 0; i < n; i++) {
            scorelist[i]=sc.nextInt();
            if (scorelist[i]>max){
                max=scorelist[i];
            }
        }
        double sum=0;
        for (int i = 0; i < n; i++) {
            sum+= (double) scorelist[i]/max*100;
        }
        System.out.println(sum/n);
    }
}
