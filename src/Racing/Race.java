package Racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

import static Racing.MainClass.logger;

public class Race {

    private ArrayList<Stage> stages;
    private AtomicReference<Car> winner;

    private Signal startSignal = new Signal("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!", 4);
    private Signal finishSignal = new Signal("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!", 4);

    public ArrayList<Stage> getStages() {
        return stages;
    }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.winner = new AtomicReference<>();
    }
    public boolean defineWinner(Car winner){
        boolean res = this.winner.compareAndSet(null, winner);
        if(res){
            System.out.println(winner.getName() + " - WIN");
            logger.log(Level.SEVERE, "winner.getName() + \" - WIN\"");
        }
        return res;
    }

    private class Signal {
        private CyclicBarrier barrier;

        private Signal(String message, int size) {
            this.barrier = new CyclicBarrier(size, () -> System.out.println(message));
            logger.log(Level.SEVERE, message);
        }

        public CyclicBarrier getBarrier() {
            return barrier;
        }
    }

    public CyclicBarrier startSignal() {
        return startSignal.getBarrier();
    }

    public CyclicBarrier finishSignal() {
        return finishSignal.getBarrier();
    }

}
