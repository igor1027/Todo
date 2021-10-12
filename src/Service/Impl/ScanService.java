package Service.Impl;

import java.util.Scanner;

public class ScanService {
    Scanner scanner = new Scanner(System.in);

    public int checkInt(){
        while (!scanner.hasNextInt()){
            System.out.println("Введены значения не того типа");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String checkString(){
        while (!scanner.hasNext()){
            System.out.println("Введены значения не того типа");
            scanner.next();
        }
        return scanner.nextLine();
    }


}
