import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solce();
    }
    public static void solce(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int num=0;
        for (int i = 0; i < n; i++) {
            num = input.nextInt();
            if (num<x){
                System.out.print(num);
                System.out.print(" ");
            }

        }
    }
}
