package JavaThreads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class SemaphoreExample
{
    private static final int COUNT_PARKING_PLACES = 5;
    private static final int COUNT_CARS = 7;
    private static boolean[] PARKING_PLACES = null;
    private static Semaphore SEMAPHORE = null;
    public static class Car implements Runnable
    {
        private int carNum;

        public Car (int carNum)  {
            this.carNum = carNum;
        }

        @Override
        public void run() {
            System.out.printf("Автомобиль %d подъехал к парковке\n", carNum);
            try {
                SEMAPHORE.tryAcquire(45, TimeUnit.MILLISECONDS);
                System.out.printf("\tавтомобиль %d проверяет наличие свободного места\n", carNum);
                int controlNum = -1;
                synchronized (PARKING_PLACES){
                    for (int i = 0;
                        i < COUNT_PARKING_PLACES; i++)
                        if (PARKING_PLACES[i]) {
                            PARKING_PLACES[i] = false;
                            controlNum = i;
                            System.out.printf("\t\tавтомобиль %d занял место %d.\n", carNum, i);
                            break;
                        }
                    }
                if (controlNum>=0) Thread.sleep(101);
                synchronized (PARKING_PLACES) {
                    if (controlNum>=0) PARKING_PLACES[controlNum] = true;
                }
                SEMAPHORE.release();
                if (controlNum>=0) System.out.printf("Автомобиль %d покинул парковку\n", carNum);
                    else System.out.printf("Автомобиль %d прекратил ожидание\n", carNum);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PARKING_PLACES = new boolean[COUNT_PARKING_PLACES];
        for (int i = 0; i < COUNT_PARKING_PLACES; i++) PARKING_PLACES[i] = true;
        SEMAPHORE = new Semaphore(PARKING_PLACES.length, true);
        for (int i = 1; i <= COUNT_CARS; i++) new Thread(new Car(i)).start();
    }
}