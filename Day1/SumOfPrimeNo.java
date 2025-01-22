package hello;

public class SumOfPrimeNo  
{  
public static void main(String args[])   
{  
int count, sum = 0;  
for(int number = 1; number <= 200; number++)  
{  
count = 0;  
for (int i = 2; i <= number/2; i++)  
{  
if(number % i == 0)  
{  
  
count++;  
break;  
}    
}  
if(count == 0 && number != 1 )  
{  
sum = sum + number;  
}     
}  
System.out.println("The Sum of Prime Numbers from 1 to 200 is: " + sum);  
}  
} 
