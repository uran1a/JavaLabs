package labs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task1 task = new Task1();
        System.out.print("Введите высоту: ");
        System.out.print(task.calculateFigure1(new Scanner(System.in).nextInt()));
        System.out.println();
        System.out.println();
        System.out.print("Введите высоту: ");
        System.out.print(task.calculateFigure2(new Scanner(System.in).nextInt()));
    }
}
