package Desafio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qntTests = scanner.nextInt();
        scanner.nextLine(); // skip first '\n'
        for (int i = 0; i < qntTests; i++) {
            String gibberish = scanner.nextLine();

            StringBuilder phrase = new StringBuilder();
            for (int firstPointer = gibberish.length()/2-1; firstPointer >= 0; firstPointer--) {
                phrase.append(gibberish.charAt(firstPointer));
            }
            for (int secondPointer = gibberish.length()-1; secondPointer >= gibberish.length()/2; secondPointer--) {
                phrase.append(gibberish.charAt(secondPointer));
            }
            System.out.println(phrase);
        }
    }
}
