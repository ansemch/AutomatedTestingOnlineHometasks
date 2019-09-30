package JavaFundamentals;

import java.util.Random;
import java.util.Scanner;

public class JavaFundamentalsOptional {

    public static void main (String[] args) {

        // выполнение пункта 3 второго дополнительного задания раздела "Java.Fundamentals"

        Random random = new Random();
        System.out.println("Введите размерность матрицы:");
        Scanner in = new Scanner(System.in);
        int dim_of_matrix = in.nextInt();

        // матрица matrix заполняется случайными числами; в матрицу for_sum заносятся позиции первых и вторых
        // положительных элементов строк, в массиве sum вычисляются суммы элементов матрицы между первыми и вторыми
        // положительными элементами строк

        int [][] matrix = new int [dim_of_matrix][dim_of_matrix], for_sum = new int [dim_of_matrix][2];
        for (int i=0; i<dim_of_matrix; i++) {
            for (int j=0; j<2; j++) {
                for_sum[i][j]=-1;
            }
        }
        int [] sum = new int [dim_of_matrix];
        for (int i=0; i<dim_of_matrix; i++) sum [i]=0;
        for (int i=0; i<dim_of_matrix; i++) {
            for (int j = 0; j < dim_of_matrix; j++) {
                matrix[i][j] = random.nextInt();

                // вывод элементов матрицы

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println("");

        }
        System.out.println("");

        for (int i=0; i<dim_of_matrix; i++) {
            for (int j = 0; j < dim_of_matrix; j++) {
                if (matrix[i][j] > 0 && for_sum[i][0] == -1) for_sum[i][0] = j;
                else if (matrix[i][j] > 0 && for_sum[i][1] == -1) for_sum[i][1] = j;
            }
        }
        for (int i=0; i<dim_of_matrix; i++) {
            if (for_sum[i][0]>-1 && for_sum[i][1]>-1)
                for (int j=for_sum[i][0]+1;j<for_sum[i][1]; j++) sum[i]+=matrix[i][j];
        }

        // вывод позиций первых и вторых положительных элементов строк матрицы. Если элементы не найдены, то выводится -1

        for (int i=0; i<dim_of_matrix; i++) {
            for (int j=0; j<2; j++) {
                System.out.print (for_sum[i][j]+ " ");
            }
            System.out.println ("");
        }

        // вывод сумм элементов матрицы между первыми и вторыми положительными элементами строк матрицы

        System.out.println ("");
        for (int i=0; i<dim_of_matrix; i++) System.out.println(sum[i]);

    }

}