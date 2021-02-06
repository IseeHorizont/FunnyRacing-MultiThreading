package OtherTasks;

import java.util.stream.IntStream;

public class Task2 {

    /**
     2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
     (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */
    public static int[] getArraysNumberAfterLast4(int[] someArray){

        if(!(checkArrayFor4(someArray))){
            throw new RuntimeException("В массиве нет ни одной цифры 4!");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = someArray.length - 1; i >= 0; i--) {
            if(someArray[i] != 4){
                sb.append(" " + someArray[i]);
            }
            if(someArray[i] == 4){
                break;
            }
        }
        sb.reverse();
        String str = sb.toString();
        String[] tmp = str.split(" ");

        int[] result = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            result[i] = (int)Integer.parseInt(tmp[i]);
        }
        return result;
    }

    public static boolean checkArrayFor4(int[] arr){
        return IntStream.of(arr).anyMatch(x -> x == 4);
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};

        printArray(arr1);

        System.out.println();
        printArray(getArraysNumberAfterLast4(arr1));

    }
}
