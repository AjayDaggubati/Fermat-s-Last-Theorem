/*
 * Fermats Last Theorem - Near Miss
 * File Holding the Program: FermatsTheorem
 * 
 * Programmers Names: 
 * 1. Ajay Kumar Daggubati(AjayKumarDaggubati@lewisu.edu)
 * 2. Mahesh Kayithi (Maheshkayithi@lewisu.edu)
 * 
 * Course: FA22-CPSC-60500-004
 * 
 * November 20, 2022
 * 
 * Explanation: The x and y values are generated from the k value in accordance with the limit range that was established in the first place. A random number between 2 and n times 12 will be chosen. Next, we followed the technique for finding the near miss by solving the equation and determining the value of the near miss, and then we obtained the nearest miss's value.
 * 
 */
import java.util.Scanner;
import java.lang.Math;

public class FermatsTheorem {
	public static void main(String[] args) 
	{ 
		int x = 0;
	    int y = 0;
	    int z = 0;
	    int lowerlimit;
	    int upperlimit;
	    int n;
	    
	    Scanner input = new Scanner(System.in);
	    
	    System.out.print("Lower limit for K > ");
	    lowerlimit = input.nextInt();
	    while(lowerlimit < 10)
	    {
	    	System.out.print("Lower limit for K; must be greater than 10 > ");
		    lowerlimit = input.nextInt();
	    }
	    System.out.print("Upper limit for K > ");
	    upperlimit = input.nextInt();
	    while(upperlimit <= lowerlimit)
	    {
	    	System.out.print("Upper limit must be greater than Lower limit: Enter Upper Limit again > ");
		    upperlimit = input.nextInt();
	    }
	    System.out.print("Value for n; must be greater than 2 > ");
	    n = input.nextInt();
	    while(n < 2)
	    {
	    	System.out.print("Enter value for n; must be greater than 2 > ");
	    	n = input.nextInt();
	    }
	    System.out.print("\nEnter the value of num for num times iteration > ");
	    int num = input.nextInt();
	    double smallestmiss = 99999999.99; 
	    
	    //Following loop will execute num times
	    for (int i =0; i<num; i++) 
	    {
	        	
	        	x =  (int) ((Math.random() * (upperlimit - lowerlimit)) + lowerlimit);
	        	y =  (int) ((Math.random() * (upperlimit - lowerlimit)) + lowerlimit);
	        	n =  (int) ((Math.random() * (11 - 3)) + 3);
	        	
	        	System.out.print("\nx's value > " + x);
	        	System.out.print("\ny's value > " + y);
	        	System.out.print("\nn's value > " + n + "\n");
	     	        	
	        //first we take power of both x and y and then we add them
	        int xpown = (int)(Math.pow (x, n));
	        int ypown = (int)(Math.pow (y, n));
	        int xpown_sum_ypown = (int)(xpown + ypown);
	        
	        //To get the fermat's equation, nth root of the sum we get above will be taken.
	        z = (int) Math.pow (xpown_sum_ypown, 1.0/n);
	        
	        //To get the near miss value we subtract the z from the sum of xpown ypown.
	        int nearmiss = (int)(xpown_sum_ypown - Math.pow (z, n));
	        
	        
	        //calculates the relative miss value
	        double relativemiss = 100. * nearmiss / xpown_sum_ypown;
	        System.out.println("\n\nVAlue of Near Miss >  "+nearmiss+" \nValue of Relative Miss > "+relativemiss);
	        
	        
	        //To get the smallest value we compare the relative miss and smallest miss values
	        if(relativemiss<smallestmiss)
	        {
	        	smallestmiss=relativemiss;
	        }
	        System.out.println("Value of Smallest Possible Miss > "+smallestmiss);
	           
	    }
	}
}



