import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);

		int Arrlen = 8;
		int testarr[] = new int[Arrlen];

		for (int j = 0; j < Arrlen; j++) {
			testarr[j] = scan1.nextInt();
		}
		test(Arrlen, testarr);

	}

	static void test(int Arrlen, int[] testarr) {

		boolean IsPlus = true;
		boolean IsMinus = true;
		// boolean IsArray = true;

		for (int i = 0; i < Arrlen - 1; i++) {
			if (testarr[i] < testarr[i + 1])
				IsMinus = false;
			if (testarr[i] > testarr[i + 1])
				IsPlus = false;
		}
		if (IsMinus == false && IsPlus == true)
			System.out.println("ascending");
		else if(IsMinus == true && IsPlus == false)
			System.out.println("descending");
		else
			System.out.println("mixed");

	}
}