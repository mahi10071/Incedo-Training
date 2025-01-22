package hello;

//import java.util.Scanner;

public class Armstrong1To1000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		int sum=0;;
	     int digit=0;
		while( i<1000) {
			
		int n=1;
	      
	      
//	      String x=Integer.toString(n);
//	      int length=x.length();
	      int length= String.valueOf(n).length();
	      int m=n;
	      
	      
	      while(m!=0) {
	    	  digit=m%10;
	    	  sum +=  Math.pow(digit,length);
	    	  m /=10;
	      }
//	    	  a=sum;
	      
	     
	    	  
	    	  if(sum==i) 
	    	  System.out.println(i);
	    	  i++;
	    	  
	    	  
	      
	      
	
	}

}
}
