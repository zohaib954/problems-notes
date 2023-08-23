/* Class Fraction

 * Construct a class called ComplexNumber which stores two properties

real - The real part
imaginary - The imaginary part

The name of the properties should be strictly real and imaginary


Implement the following functionalities inside this class :-

add(ComplexNumber) -> Returns an object of ComplexNumber having sum of the two complex numbers.

subtract(ComplexNumber) -> Returns an object of ComplexNumber having difference of the two complex numbers.

multiply(ComplexNumber) -> Returns an object of ComplexNumber having multiplication of the two complex numbers.

divide(ComplexNumber) -> Returns an object of ComplexNumber having division of the two complex numbers.
 */
package classObjects;

public class ComplexNumber {
    float real, imaginary;
       
    // Define constructor here
        ComplexNumber(float real, float imaginary)
        {
            this.real=real;
            this.imaginary=imaginary;
        }
       
    ComplexNumber add(ComplexNumber x){

        ComplexNumber ans=new ComplexNumber(0,0);
        ans.real=this.real+x.real;
        ans.imaginary=this.imaginary+x.imaginary;
        return ans;
        // Complete the function
       
    }
   
    ComplexNumber subtract(ComplexNumber x){
        // Complete the function

        ComplexNumber ans=new ComplexNumber(0,0);
        ans.real=this.real-x.real;
        ans.imaginary=this.imaginary-x.imaginary;
        return ans;
       
    }
       
    ComplexNumber multiply(ComplexNumber x){
        // Complete the function
        ComplexNumber ans=new ComplexNumber(0,0);
        ans.real=this.real*x.real-this.imaginary*x.imaginary;
        ans.imaginary=this.imaginary*x.real+this.real*x.imaginary;
        return ans;
       
    }
   
    ComplexNumber divide(ComplexNumber x){
        // Complete the function
       
ComplexNumber ans=new ComplexNumber(0,0);

float denominator=x.real*x.real+x.imaginary*x.imaginary;

ComplexNumber conjugate=new ComplexNumber(x.real,-x.imaginary);

ComplexNumber numerator=this.multiply(conjugate);

        ans.real=numerator.real/denominator;
        ans.imaginary=numerator.imaginary/denominator;
       
        return ans;
       
    }
}
