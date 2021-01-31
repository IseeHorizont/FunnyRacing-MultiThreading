/**
 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 Используйте wait/notify/notifyAll.
 */
public class Main {
    private static Object obj = new Object();

    public static void main(String[] args) {


        new Thread(() -> {
            synchronized (obj){
                for (int i = 0; i < 5; i++) {
                    System.out.print("A");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj){
                for (int i = 0; i < 5; i++) {
                    System.out.print("B");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    obj.notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 5; i++) {
                    System.out.print("C");
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
