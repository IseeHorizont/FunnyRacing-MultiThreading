package Racing;


import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        if(!cyclicBarrier.isBroken()) {
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
        }
    }
}




