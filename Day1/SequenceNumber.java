package hello;
import java.io.*;
import java.util.*;

public class SequenceNumber {


    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        number = scanner.nextInt();
        System.out.println("Result:");
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }
    }
}

