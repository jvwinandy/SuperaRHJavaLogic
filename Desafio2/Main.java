package Desafio2;

public class Main {
    public static void main(String[] args) {
        BankNotesCalculator bankNotesCalculator = new BankNotesCalculator();
        bankNotesCalculator.readNewInputAndCalculate();
        bankNotesCalculator.printNotes();
        bankNotesCalculator.printCoins();
    }
}
