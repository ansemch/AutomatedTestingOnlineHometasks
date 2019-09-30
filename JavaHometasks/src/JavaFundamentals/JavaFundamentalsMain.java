package JavaFundamentals;

import java.time.Month;
import java.util.Random;
import java.util.Scanner;

public class JavaFundamentalsMain {

    static void helloUser (String[] args) {
        System.out.print("Hello,");
        for (int i=0; i<args.length; i++) System.out.print(" " + args[i]);
        System.out.println("!\n");
    }

    static void reverseOrder (String[] args) {
        for (int i=args.length-1; i>=0; i--) System.out.println(args[i]);
        System.out.println("");
    }

    static void randomValues () {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите количество случайных чисел:");
        int num = in.nextInt();
        int a[] = new int[num];
        for (int i=0; i<num; i++) a[i]=random.nextInt();
        for (int i=0; i<num; i++) System.out.print (a[i]+" ");
        System.out.println("\n");
        for (int i=0; i<num; i++) System.out.println (a[i]);
        System.out.println("");
    }

    static void mulValues (String[] args) {
        int mul = 1;
        for (int i = 0; i < args.length; i++) { mul *= Integer.parseInt(args[i]); }
        System.out.println ("Произведение чисел: " + mul + "\n");
    }

    static void getMonth () {
        System.out.println ("Введите число от 1 до 12:");
        Scanner in = new Scanner(System.in);
        int month_num = in.nextInt();
        if (month_num >= 1 && month_num <= 12) System.out.println(Month.of(month_num));
    }


    public static void main (String[] args) {

        helloUser (args);
        reverseOrder (args);
        randomValues ();
        mulValues (args);
        getMonth ();

    }
}