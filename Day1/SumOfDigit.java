package hello;

import java.util.Scanner;

public class SumOfDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int digit,number=0,sum=0;
		Scanner sc= new Scanner(System.in);
        System.out.println("Enter a number :");
        number = sc.nextInt();
        
        while(number>0) {
        	digit= number%10;
        	sum=sum+digit;
        	number=number/10;
        	
        }
        System.out.print("sum of the digit is " + sum);
        
	}

}
