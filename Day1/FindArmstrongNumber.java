package hello;

import java.util.Scanner;

public class FindArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      Scanner sc= new Scanner(System.in);
	      System.out.println("Enter a number :");
	      int n = sc.nextInt();
	      
	      int m=n;
	      int sum=0;;
	      int digit=0;
	      int length= String.valueOf(n).length();
	      while(m>0) {
	    	  digit=m%10;
	    	  sum +=  Math.pow(digit,length);
	    	  m /=10;
	    	  
	    	  
	      }
	      
	      if(sum == n)
	            System.out.println(n + " is an Armstrong number.");
	      else
	            System.out.println(n + " is not an Armstrong number.");
	}

}
