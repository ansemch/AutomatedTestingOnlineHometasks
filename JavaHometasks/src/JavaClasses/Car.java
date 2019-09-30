package JavaClasses;

public class Car {

    final int id;
    final String make;
    final String model;
    final int year_manufacture;
    String color;
    int price;
    String reg_number;

    Car (int id, String make, String model, int year_manufacture, String color, int price, String reg_number) {
        this.id=id;
        this.make=make;
        this.model=model;
        this.year_manufacture=year_manufacture;
        this.color=color;
        this.price=price;
        this.reg_number=reg_number;
    }

    Car (int id, String make, String model, int year_manufacture) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year_manufacture = year_manufacture;
    }

    void setCar (String color, int price, String reg_number) {
        this.color=color;
        this.price=price;
        this.reg_number=reg_number;
    }

    Car getCar (int id, String make, String model, int year_manufacture, String color, int price, String reg_number) {
        if (this.id == id && this.make.equals(make) && this.model.equals(model) &&
                this.year_manufacture == year_manufacture && this.color.equals(color) && this.price == price &&
                this.reg_number.equals(reg_number))
            return this;
        else return null;
    }

    Car getCar (int id) { if (this.id == id ) return this; else return null; };


    public String toString () {
        return Integer.toString (id) + " " + make + " " + model + " " + Integer.toString (year_manufacture) + " "
                + color + " " + Integer.toString (price) + " " + reg_number;
    }
}
