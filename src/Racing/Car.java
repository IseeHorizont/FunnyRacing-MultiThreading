package Racing;

import java.util.concurrent.BrokenBarrierException;
import java.util.logging.Level;

import static Racing.MainClass.logger;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            logger.log(Level.SEVERE, this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            logger.log(Level.SEVERE, this.name + " готов");
            race.startSignal().await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            race.defineWinner(this);
            race.finishSignal().await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
