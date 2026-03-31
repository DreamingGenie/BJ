import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int count = 0;
        String ABC=Integer.toString(A*B*C);
        for(int i=0;i<10;i++){
            count=0;
            for (int j=0;j<ABC.length();j++){
                if(ABC.charAt(j)==('0'+i)){
                    count++;
                }
            }
            System.out.println(count);

        }
    }
    /*
150
266
427
     */
}
