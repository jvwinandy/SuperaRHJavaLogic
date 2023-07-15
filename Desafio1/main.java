import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (numbers[i] % 2 == 1) {
                System.out.println(numbers[i]);
            }
        }
    }
}
