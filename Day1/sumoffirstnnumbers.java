package hello;
//import java.util.Scanner;
import java.util.*;


public class sumoffirstnnumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
      Scanner sc= new Scanner(System.in);
      System.out.println("Enter a number :");
      int n = sc.nextInt();
      int sum=0;
      for(int i=0;i<=n;i++)
      {
        sum=sum+i;  
      }
      System.out.println(sum);

	}

}
