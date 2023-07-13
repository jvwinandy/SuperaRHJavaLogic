package Desafio2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BankNotesCalculator {
    private int integerValue;
    private int decimalValue;

    private Map<Integer, Integer> bankNotes;
    private Map<Integer, Integer> coins;

    public void readNewInputAndCalculate() {
        this.resetBankNotes();
        this.resetCoins();

        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();

        // Parse from string to avoid floating point errors.
        // Since all numbers have only 2 decimals, we can take until the last 3 (".") characters to get the integer part.
        int dotIndex = value.length() - 3;
        this.integerValue = Integer.parseInt(value.substring(0, dotIndex));
        this.decimalValue = Integer.parseInt(value.substring(dotIndex + 1));

        this.calculate();
    }

    public void printNotes() {
        System.out.println("NOTAS:");
        this.bankNotes.forEach((noteValue, qnt) -> {
            System.out.println(this.formatText(qnt, noteValue, false));
        });
    }

    public void printCoins() {
        System.out.println("MOEDAS:");
        this.coins.forEach((coin, qnt) -> {
            System.out.println(this.formatText(qnt, coin, true));
        });
    }

    private void calculate() {
        calculateQuantity(false);
        calculateQuantity(true);
    }

    private void resetBankNotes() {
        this.bankNotes = new LinkedHashMap<Integer, Integer>() {{
            put(100, 0);
            put(50, 0);
            put(20, 0);
            put(10, 0);
            put(5, 0);
            put(2, 0);
        }};
    }

    private void resetCoins() {
        this.coins = new LinkedHashMap<Integer, Integer>() {{
            put(100, 0);
            put(50, 0);
            put(25, 0);
            put(10, 0);
            put(5, 0);
            put(1, 0);
        }};
    }

    private void calculateQuantity(boolean isCoin) {
        int currentValue = (isCoin) ? this.decimalValue : this.integerValue;
        Map<Integer, Integer> map = (isCoin) ? this.coins : this.bankNotes;

        for (Integer value : map.keySet()) {
            int qnt = currentValue / value;
            currentValue -= qnt * value;

            map.replace(value, qnt);
        }

        if (!isCoin && currentValue > 0) {
            // Special case when we need to use the R$1,00 coin.
            this.decimalValue += 100;
        }
    }

    private static String formatText(int qnt, int value, boolean isCoin) {
        if (!isCoin) {
            return qnt + "\t" + "nota (s)\tde\tR$\t" + value + ".00";
        }
        else {
            String noteValue;
            switch (value) {
                case 100:
                    noteValue = "1.00";
                    break;
                // Intentional fall-through
                case 5:
                case 1:
                    noteValue = "0.0" + value;
                    break;
                default:
                    noteValue = "0." + value;
            }
            return qnt + "\t" + "moeda (s)\tde\tR$\t" + noteValue;
        }
    }
}
