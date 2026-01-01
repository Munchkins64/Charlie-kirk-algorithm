import java.lang.reflect.Array;
import java.util.Scanner;

import javax.swing.*;

public class Main {

    // public static void main(String[] args) {

    //     int[] arrayNigger = new int[10];

    //     Scanner scanner = new Scanner(System.in);

    //     System.out.println("Enter 10 numbers");

    //     for (int y = 0; y < 10; y++) {
    //         System.out.println("Enter number");
    //         arrayNigger[y] = Integer.parseInt(scanner.nextLine());
    //     }
    //     BubbleSortAlgorithm(arrayNigger);

    // }

    public static int[] BubbleSortAlgorithm(int array[]) {

        int lengthOFArray = array.length;
        int temp = 0;

        for (int x = 0; x < lengthOFArray - 1; x++) {
            for (int index = 0; index < lengthOFArray - 1; index++) {
                if (array[index] > array[index + 1]) {
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }

        return array;
    }
}