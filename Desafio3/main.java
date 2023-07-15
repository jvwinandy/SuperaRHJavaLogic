package Desafio3;

import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int firstPointer = 0;
        int secondPointer = 1;
        int counter = 0;
        while (secondPointer < length && firstPointer < length) {
            // Walk through the array using two pointers, moving in a sliding window fashion
            // The firstPointer may be bigger than the secondPointer if our target is a negative number.
            if (arr[secondPointer] - arr[firstPointer] == target) {
                // if the difference between the values in those positions are exactly what we want, increase the
                // counter, and move the second pointer to a number equal or bigger than the current.
                counter++;
                secondPointer++;
            }
            else if (arr[secondPointer] - arr[firstPointer] > target) {
                // if the difference between the values in those positions are higher than we want, increase the first
                // pointer, to a number bigger or equal than the current, making the difference smaller.
                firstPointer++;
            }
            else {
                // if the difference between the values in those positions are smaller than we want, increase the second
                // pointer, to a number bigger or equal than the current, making the difference bigger.
                secondPointer++;
            }
        }

        System.out.println(counter);
    }
}
