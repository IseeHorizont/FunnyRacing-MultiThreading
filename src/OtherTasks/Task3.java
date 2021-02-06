package OtherTasks;

import java.util.stream.IntStream;

public class Task3 {
    /**
     Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
     то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */

    public static boolean checkArrayFor1or4(int[] array){
        if(array == null){
            throw new RuntimeException("Пустой массив!");
        }
        return (IntStream.of(array).anyMatch(x -> x == 1)) && (IntStream.of(array).anyMatch(x -> x == 4));
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 1, 4, 1, 4};
        System.out.println(checkArrayFor1or4(arr1));

        int[] arr2 = new int[]{1, 3, 5, 77, 13};
        System.out.println(checkArrayFor1or4(arr2));

        int[] arr3 = new int[]{4, 8, 3, 5};
        System.out.println(checkArrayFor1or4(arr3));
    }
}
