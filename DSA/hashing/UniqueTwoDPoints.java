/*
 *  Unique 2D points
 * 
 * Problem Description
    Given a 2D array A of integer points on a 2D plane. Find and return the number of unique points in the array.
    The ith point in the array is (A[i][0], A[i][1])

Problem Constraints
    1 <= len(A) <= 105
    -109 <= A[i][0], A[i][1] <= 109

Input Format
    The first argument is a 2D integer array A.


Output Format
    Return an integer that is the number of unique points.

Example Input
Input 1:
    A = [[1, 1],
        [2, 2],
        [2, 2],
        [1, 1],
        [1, 1]]
Input 2:
    A = [[5, 6],
        [2, 8],
        [-1, -1],
        [2, -3],
        [2, 8],
        [7, 7],
        [2, -3]]

Example Output
Output 1:
    2
Output 2:
    5


Example Explanation
Explanation 1:
    There are 2 unique points in the given array. They are [1, 1] and [2, 2].
Explanation 2:
    There are 5 unique points in the given array. They are [5, 6], [2, 8], [-1, -1], [2, -3] and [7, 7].
 */


package hashing;

import java.util.HashMap;

class Pair{
    int x, y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int hashCode(){
        return (x+y)%100000;
    }

    public boolean equals(Object o){
        Pair obj = (Pair)o;
        if(x==obj.x && y==obj.y){
            return true;
        }
        return false;
    }
}


public class UniqueTwoDPoints {
    static int unique2Dpoints(int A[][]){
        int n = A.length;
        HashMap<Pair, Boolean> hs = new HashMap<>();

        for(int i=0; i<n; i++){
            Pair p = new Pair(A[i][0], A[i][1]);
            hs.put(p, true);
        }

        return hs.size();
    }
    public static void main(String[] args) {
        int A[][] = {{5, 6},
                    {2, 8},
                    {-1, -1},
                    {2, -3},
                    {2, 8},
                    {7, 7},
                    {2, -3}};

                    System.out.println(unique2Dpoints(A));
    }
}
