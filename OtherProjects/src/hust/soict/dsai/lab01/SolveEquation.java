package hust.soict.dsai.lab01;

import java.util.Scanner;
public class SolveEquation{
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		//Linear equation
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		if (a==0){
			if (b==0) System.out.println("Infinite solutions");
			else System.out.println("No solution");
		}
		else System.out.println("One solution: "+ (-b/a));
		
		//System
		double a11 = sc.nextDouble();
		double a12 = sc.nextDouble();
		double b1 = sc.nextDouble();
		double a21 = sc.nextDouble();
		double a22 = sc.nextDouble();
		double b2 = sc.nextDouble();
		
		double d = a11*a22 -a21*a12, d1 = b1*a22 - b2*a12, d2 = a11*b2 - b1*a21; 
		if (d==0) {
			if (d1==0 && d2==0) System.out.println("Infinite solutions");
			else System.out.println("No solution");
		}
		else {
			System.out.println("x1 = " + (d1/d) + "\n" + "x2 = " + (d2/d));
		}
		
		//Quadratic equation
		double a3 = sc.nextDouble();
		double b3 = sc.nextDouble();
		double c3 = sc.nextDouble();
		
		if (a3==0) {
			if (b3==0) {
				if (c3==0)System.out.println("Infinite solutions");
				else System.out.println ("No solution");
			}
			else {
				System.out.println ("One solution: " + (-c3/b3));
			}
		}
		else {
			double delta = b3*b3-4*a3*c3;
			if (delta==0) System.out.println("One solution: " + (-b3/(2*a3)));
			else if (delta<0) System.out.println("No solution");
			else {
				double x1 = (-b3 - Math.sqrt(delta))/(2*a3);
				double x2 = (-b3 + Math.sqrt(delta))/(2*a3);
				System.out.println ("x1 = " + x1 + "\n" + "x2 = " + x2);
			}
		}
		
	}
}