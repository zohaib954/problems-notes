/*Problem Description
Construct a class Fraction which stores a fraction. It should contain the

-Numerator
-Denominator

Assume denominator will never be 0.

The class should support the following functionalities

add(Fraction) -> Returns the sum of two fractions

subtract(Fraction) -> Returns the difference of two fractions

multiply(Fraction) -> Returns the product of two fractions

The fraction returned needs to be in the simplest form. If the fraction is p/q then p and q must be co-prime.

You may define any properties in the class as you see appropriate.

given code
class Fraction {
    int numerator, denominator;
		
	// Define constructor here
		
		
	Fraction add(Fraction a){
		// Complete the function
			
	}
		
	Fraction subtract(Fraction a){
		// Complete the function
			
	}
		
	Fraction multiply(Fraction a){
		// Complete the function
			
	}
}


    Fraction x = new Fraction(2, 3)  // 2/3
	Fraction y = new Fraction(4, 5) // 4/5
    Fraction z = x.add(y) // 22/15
    Fraction z = x.subtract(y) // -2/15
    Fraction z = x.multiply(y) // 8/15

*/
package classObjects;

public class ClassFraction {
    class Fraction {
        int numerator, denominator;
            
        // Define constructor here
            Fraction(int numerator, int denominator){
                this.numerator = numerator;
                this.denominator = denominator;
            }
            
         Fraction add(Fraction a){
            // Complete the function
            int lcm=findLCM(denominator,a.denominator);
            int num=numerator*(lcm/denominator)+a.numerator*(lcm/a.denominator);
            int gcd=findGCD(Math.abs(num),Math.abs(lcm));
            return new Fraction(num/gcd,lcm/gcd);
        }
        Fraction subtract(Fraction a){
            // Complete the function
            int lcm=findLCM(denominator,a.denominator);
            int num=numerator*(lcm/denominator)-a.numerator*(lcm/a.denominator);
            int gcd=findGCD(Math.abs(num),Math.abs(lcm));
            return new Fraction(num/gcd,lcm/gcd);      
        }
        Fraction multiply(Fraction a){
            // Complete the function
            int num=numerator*a.numerator;
            int den=denominator*a.denominator;
            int gcd=findGCD(Math.abs(num),Math.abs(den));
            return new Fraction(num/gcd,den/gcd);      
        }
         public int findGCD(int a,int b){
            if(b==0){
                return a;
            }
            return findGCD(b,a%b);
        }
    
        public int findLCM(int a,int b){
            return (a*b)/findGCD(a,b);
        }
    }
    
    /*
        Fraction x = new Fraction(2, 3)  // 2/3
        Fraction y = new Fraction(4, 5) // 4/5
        Fraction z = x.add(y) // 22/15
        Fraction z = x.subtract(y) // -2/15
        Fraction z = x.multiply(y) // 8/15
    */
}
