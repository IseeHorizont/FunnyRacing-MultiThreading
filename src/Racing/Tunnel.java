package Racing;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final Semaphore SEMAPHORE = new Semaphore(2);
    private static final boolean[] TUNNEL_CAPACITY = new boolean[2];

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                SEMAPHORE.acquire();
                int numbPlace = 0;
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                synchronized (TUNNEL_CAPACITY) {
                    for (int i = 0; i < TUNNEL_CAPACITY.length; i++) {
                        if (!TUNNEL_CAPACITY[i]) {
                            TUNNEL_CAPACITY[i] = true;
                            numbPlace = i;
                            System.out.println(c.getName() + " начал этап: " + description);
                            break;
                        }
                    }
                }
                    Thread.sleep(length / c.getSpeed() * 1000);
                synchronized (TUNNEL_CAPACITY){
                    TUNNEL_CAPACITY[numbPlace] = false;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                SEMAPHORE.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
