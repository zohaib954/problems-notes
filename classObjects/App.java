package classObjects;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Matrix a = new Matrix(2, 2);
        a.input(scan);
        System.out.println();
        Matrix b = new Matrix(2, 2);
        b.input(scan);
        Matrix c1 = a.add(b);
        Matrix c2 = a.subtract(b);
        Matrix c3 = a.transpose();
        a.print();
        c1.print();
        c2.print();
        c3.print();
    }
}
