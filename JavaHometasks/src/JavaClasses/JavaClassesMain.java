package JavaClasses;

import java.util.Scanner;
import java.time.LocalDate;

public class JavaClassesMain {

    private static void outputToConsole (Car car) {
        System.out.println("id: "+car.id);
        System.out.println("Марка: "+car.make);
        System.out.println("Модель: "+car.model);
        System.out.println("Год выпуска: "+car.year_manufacture);
        System.out.println("Цвет: "+car.color);
        System.out.println("Цена(EUR): "+car.price);
        System.out.println("Регистрационный номер: "+car.reg_number);
    }

    private static void searchByMake ( Car [] cars, String make ) {
        for (int i = 0; i < cars.length; i ++) {
            if (cars[i].make.equals(make)) {
                outputToConsole (cars[i]);
                if (i != cars.length-1) System.out.print("\n");
            }
        }

    }

    private static void searchByModelAndExploitationTerm ( Car [] cars, String model, int years_exploitation ) {
        for (int i=0; i<cars.length; i++) {
            if (cars[i].model.equals(model) && LocalDate.now().getYear()-cars[i].year_manufacture > years_exploitation) {
                outputToConsole (cars[i]);
                if (i!=cars.length-1) System.out.print("\n");
            }
        }
    }

    private static void searchByYearManufactureAndPrice ( Car [] cars, int year_manufacture, int price ) {
        for (int i=0; i<cars.length; i++) {
            if (cars[i].price > price && cars[i].year_manufacture == year_manufacture) {
                outputToConsole (cars[i]);
                if (i!=cars.length-1) System.out.print("\n");
            }
        }
    }

    public static void main (String [] args) {
        Car [] cars = new Car[7];
        cars[0] = new Car(1,"Жигули","1", 1978, "зелёный", 2000, "а 1121 ГК");
        cars[1] = new Car(2,"Mercedes-Benz","A 200 Sedan", 2019, "белый", 31739, "AI-1021-3");
        cars[2] = new Car(3,"Mercedes-Benz","A 200 Sedan", 2017, "чёрный", 27500, "KL-5972-3");
        cars[3] = new Car(4,"Mercedes-Benz","B 180 Style", 2019, "тёмно-серый", 34399, "AK-5778-4");
        cars[4] = new Car(5,"Mercedes-Benz","CLA 200 Coupe", 2019, "тёмно-серый", 31057, "AK-5878-4");
        cars[5] = new Car(6,"Mercedes-Benz","CLS 400 d 4MATIC", 2019);
        cars[5].setCar("тёмно-серый", 99427, "AM-5878-4");
        cars[6] = new Car(7,"Mercedes-Benz","E 200 4MATIC", 2019);
        cars[6].setCar("тёмно-серый", 50908, "AI-5878-4");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите марку автомобиля");
        String make=in.nextLine();
        System.out.println();
        searchByMake( cars, make );
        System.out.println("\nВведите модель автомобиля");
        String model=in.nextLine();
        System.out.println("\nВведите число лет эксплуатации");
        Scanner in2 = new Scanner(System.in);
        int years_exploitation = in2.nextInt();
        System.out.println();
        searchByModelAndExploitationTerm ( cars, model, years_exploitation );
        System.out.println("\nВведите год выпуска");
        int year_manufacture = in2.nextInt();
        System.out.println("\nВведите цену");
        int price = in2.nextInt();
        System.out.println();
        searchByYearManufactureAndPrice ( cars, year_manufacture, price );
    }
}