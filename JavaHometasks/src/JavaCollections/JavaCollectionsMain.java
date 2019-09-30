package JavaCollections;

import CleanCode.Models.ClassificationLevel;
import CleanCode.Models.ExperimentalTypes;
import CleanCode.Models.MilitaryType;

import java.util.*;

abstract class Plane {
    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;
    private int fuelConsumption;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int fuelConsumption) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }
    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }
    public int getFuelConsumption() {
        return fuelConsumption;
    }
}

class experimentalPlane extends Plane {
    private ExperimentalTypes experimentalType;
    private ClassificationLevel classificationLevel;

    public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int fuelConsumption, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity, fuelConsumption);
        this.experimentalType = type;
        this.classificationLevel = classificationLevel;
    }
}

class MilitaryPlane extends Plane {
    private MilitaryType militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type, int fuelConsumption) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity, fuelConsumption);
        this.militaryType = type;
    }
}

class PassengerPlane extends Plane {
    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity, int fuelConsumption) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity, fuelConsumption);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }
}

public class JavaCollectionsMain {
    public static void main (String[] args) {
        List <Plane> planes = Arrays.asList(
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164, 1250),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192, 1275),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242, 1300),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188, 1265),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222, 1475),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64, 1265),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140, 1565),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196,1250),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER,1567),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER,1575),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER,1474),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER,1375),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER, 1276),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT, 1300),
                new experimentalPlane("Bell X-14", 277, 482, 500, 41, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new experimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, 75, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
        );
        Iterator <Plane> planesIterator=planes.iterator();
        int totalPassengerCapacity=0;
        int totalMaxLoadCapacity=0;
        Plane plane;
        while (planesIterator.hasNext()) {
            plane=planesIterator.next();
            totalMaxLoadCapacity+=plane.getMaxLoadCapacity();
            if (plane instanceof PassengerPlane) { totalPassengerCapacity+=((PassengerPlane)plane).getPassengersCapacity();}
        }
        System.out.println("Общая грузоподъёмность: "+totalMaxLoadCapacity);
        System.out.println("Общая вместимость: "+totalPassengerCapacity);
        System.out.println("Неотсортированный список:");
        System.out.println(planes);
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane plane1, Plane plane2) {
                return plane1.getMaxFlightDistance () - plane2.getMaxFlightDistance();
            }
        });
        System.out.println("Список, отсортированный по максимальной дальности полёта:");
        System.out.println(planes);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите нижний предел потребления горючего:");
        int lowerLimitFuelConsumption = in.nextInt();
        System.out.println("Введите верхний предел потребления горючего:");
        int higherLimitFuelConsumption = in.nextInt();
        planesIterator=planes.iterator();
        while (planesIterator.hasNext()) {
            plane=planesIterator.next();
            if (plane.getFuelConsumption()>=lowerLimitFuelConsumption && plane.getFuelConsumption()<=higherLimitFuelConsumption) { System.out.println(plane); }
        }
    }
}