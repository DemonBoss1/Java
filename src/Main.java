import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        //ex1();
        //ex2();
        //ex3();
        //ex4();
        ex5();
    }
    public static void ex1() {

    }
    public static void ex2(){
        Ex2 ThisLab = new Ex2();
        try {
            ThisLab.Run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ex3(){
        Ex3 ThisLab = new Ex3();
        try {
            ThisLab.Run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ex4(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> digits = new ArrayList<Double>();
        LinkedList<Double> flags = new LinkedList<Double>();

        digits.add(4.5);
        digits.add(6.5);
        digits.add(8.5);
        digits.add(10.5);

        flags.add(4.5);
        flags.add(6.5);
        flags.add(8.5);
        flags.add(10.5);

        System.out.print("\nArrayList: ");
        for (int i = 0; i < digits.size(); i++) {
            System.out.print(digits.get(i) + " ");
        }

        System.out.print("\nArrayList: ");
        for (int i = 0; i < flags.size(); i++) {
            System.out.print(flags.get(i) + " ");
        }

        digits.addAll(0,flags);

        System.out.print("\nArrayList: ");
        for (int i = 0; i < digits.size(); i++) {
            System.out.print(digits.get(i) + " ");
        }
    }
    public static void ex5() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Double> digits = new LinkedList<Double>();
        LinkedList<Double> values = new LinkedList<Double>();
        LinkedList<String> ThirdCollection = new LinkedList<String>();
        Random number = new Random();

        for (int i = 0; i < 10; i++ ) {
            digits.add(10 + number.nextDouble());
        }
        System.out.print("\nПервая коллекция: ");
        for (Double digit : digits) {
            System.out.print(digit + " ");
        }

        System.out.println();

        System.out.println("\n");
        for (int i = 0; i < 10; i++ ) {
            values.add(digits.get(i));
        }
        for (Double value : values) {
            System.out.print(value + " ");
        }

        System.out.println();

        values.remove(values.size()-1);
        for (Double value : values) {
            System.out.print(value + " ");
        }

        System.out.println();

        values.add(1, 5.2);

        for (Double value : values) {
            System.out.print(value + " ");
        }

        System.out.println();

    }
}
