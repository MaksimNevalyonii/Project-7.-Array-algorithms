package part1_bubble_sort;

import java.util.Random;
import java.util.Scanner;

/**
 * Part 1. Bubble sort algorithm (basic, not optimised).
 */
public class Part1BubbleSort {

    // Part 1.1.1 Array output
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    // Part 1.1.2 Creation of an array of given length with random values
    public static int[] createRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100); // values from 0 to 99
        }
        return array;
    }

    // Part 1.1.3 Creation of an array of given length with values from user input
    public static int[] createArrayFromInput(Scanner scanner, int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = readInt(scanner);
        }
        return array;
    }

    // Part 1.1.4 Bubble sort method
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Outer loop: n - 1 passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compare neighbouring elements
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Helper: reads an integer, repeats until the input is valid
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Not a number, try again: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Part 1.2 Main flow
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;
        do {
            // Part 1.2.1 Ask user to input number of elements
            System.out.print("Enter number of elements: ");
            int length = readInt(scanner);
            while (length <= 0) {
                System.out.print("Number must be positive, try again: ");
                length = readInt(scanner);
            }

            // Part 1.2.2 Ask if user wants to generate values or input them
            System.out.print("Generate values randomly? (y - generate, n - input manually): ");
            String choice = scanner.next();

            // Part 1.2.3 Create an array in a chosen way
            int[] array;
            if (choice.equalsIgnoreCase("y")) {
                array = createRandomArray(length);
            } else {
                array = createArrayFromInput(scanner, length);
            }

            // Part 1.2.4 Output given array
            System.out.println("Given array:");
            printArray(array);

            // Part 1.2.5 Sort the array
            bubbleSort(array);

            // Part 1.2.6 Output sorted array
            System.out.println("Sorted array:");
            printArray(array);

            // Part 1.2.7 Ask if user wants to repeat
            System.out.print("Repeat? (y/n): ");
            repeat = scanner.next();
        } while (repeat.equalsIgnoreCase("y"));
        scanner.close();
    }
}