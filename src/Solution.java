import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Solution {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            service.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new StringBuilder().append("Thread ").append(finalI).toString() + " is here!");
                    System.out.println("- - - - - - - - - - - - - - - - -");
                }
            }, 0, 3, TimeUnit.SECONDS);
        }

    }
}
