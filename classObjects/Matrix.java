/* Q2. Class Matrix

Construct a class called Matrix which stores a 2D Array. It should store

The number of rows

The number of columns

The 2D Array itself

Implement the following functionalities inside this class :-

input() -> Reads the input from the user. This method should read the input from the user and populate the entire array. Each row will be in a new line and all the elements in a row will be space-separated.

add(Matrix) -> Returns the sum of two matrices. Assume the matrices provided have the same dimensions.

subtract(Matrix) -> Returns the sum of two matrices. Assume the matrices provided have the same dimensions.

transpose() -> Returns a new matrix containing the transpose of the given original matrix.

print() -> prints the entire matrix row by row. Each row will be in a new line and values in each row should be separated by a single space.

You may define any properties in the class as you see appropriate.
 */

package classObjects;
import java.util.Scanner;
public class Matrix {
    // Define properties here
		int row, col;
        int arr[][];;
		
	// Define constructor here
	Matrix(int row, int col){
        this.row = row;
        this.col = col;
        this.arr = new int[row][col];
    }
	
	void input(Scanner sc){
	    // Use the Scanner object passed as argument for taking input and not a new Scanner object
		// Complete the function
        for(int i=0; i<this.row; i++){
            for(int j=0; j<this.col; j++){
                this.arr[i][j] = sc.nextInt();
            }
        }
		
	}
	
	Matrix add(Matrix x){
		// Complete the function
		Matrix result = new Matrix(x.row, x.col);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
               result.arr[i][j] = this.arr[i][j] + x.arr[i][j];
            }
        }
        return result;
	}
	
	Matrix subtract(Matrix x){
		// Complete the function
		Matrix result = new Matrix(x.row, x.col);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                result.arr[i][j] = this.arr[i][j] - x.arr[i][j];
            }
        }
        return result;
	}
		
	Matrix transpose(){
		// Complete the function
		Matrix result = new Matrix(this.col,this.row);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
               result.arr[j][i] = this.arr[i][j];
            }
        }
        return result;
	}
	
	void print(){
		// Complete the function
		for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
	}
   
}


/*
    Matrix a = new Matrix(10, 5)  // 10 rows, 5 columns
	a.input() 
	Matrix b = new Matrix(10, 5)  // 10 rows, 5 columns
	b.input()
    Matrix c1 = a.add(b)
    Matrix c2 = a.subtract(b)
    Matrix c3 = a.transpose()
    a.print()
*/