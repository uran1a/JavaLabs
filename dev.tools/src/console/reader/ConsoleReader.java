package console.reader;

import java.util.Scanner;
public class ConsoleReader {
    private final Scanner sc = new Scanner(System.in);
    public int readInt(String lineForPrinting){
        if(lineForPrinting != null)
            System.out.print(lineForPrinting);
        return sc.nextInt();
    }
    public double readDouble(String lineForPrinting){
        System.out.print(lineForPrinting);
        return sc.nextDouble();
    }
}