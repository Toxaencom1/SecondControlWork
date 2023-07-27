package program;

import java.util.Scanner;

public class ScannerS {
    private static Scanner scanner;

    public static Scanner getScanner() {
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
