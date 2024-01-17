/*
 *question 1:- Given an array from 1 to n find the missing number in the array, there is only one missing number
 *          example :- A[1,2,4,5,6];
 *          in the above array 3 is missing.

 * my approach
 * step 1 :- first make the sum of all elements present inside the array then;
 * step 2 :- then take the last element and calculate the series sum by the formula n(n+1)/2; it gives us the sum between 1 to n
 *           for example sum of  [1,2,3,4] is 10; if we take last element and put it into the formula then we get
 *           4*(4+1)/2 = 10;
 * step 3 :- now take the value of the sum series and subtract it with the sum of elements present in the array;
*/

/*
 * question 2:- Given an array having +ve and -ve integers find the first missing number, 
 *              there could be more than one missing number.
 *              example :- A[3, -2, 1, 2, 7];
 *              the first missing number in the above array is 4.
 * 
 * solution :- 1 Time O(n) space O(n);
 step 1 :- first approach is to create the hash set and set all the values in hashset.
 step 2 :- then start a loop from 1 to n; check in the loop weather the index is equal to the hashset elements.
           if the index is not mathcing with the elements of hashset then return the index.
           
           after for loop at the end return n+1 because if the missing element is not mathed then return the n+1 ;

 * solution :- 2 Time O(n) space O(1);
 * step 1 :- start a while loop where i<n;
 * step 2 :- check weather the current element in the array is A[i] <= 0 or A[i] > n or A[i] == i+1 then skip;
 * step 3 :- else create a correct index variable assign it with A[i] - 1;
 *           then check if A[i] == A[correctIndex] is true then skip;
 * step 4 :- else swap the current element with the correct index element;
 *          i.e temp = A[i];
 *              A[i] = A[correctIndex];
 *              A[correctIndex] A[i];
 *          end while loop;
 * 
 * step 5 :- then start a new loop from j=0 to n;
 *           check weather A[i] != j+1 then return j+1;
 * 
 * at the end return n+1;
 * 
 * 
 * i edited this while learning git please ignore this line
 * 
 */

package arrayProblems;

import java.util.HashSet;

class FindMissingNumber {
    static int findMissingEfficient(int A[]) {
        int n = A.length, i = 0;
        while (i < n) {
            if (A[i] > n || A[i] <= 0 || A[i] == i + 1) {
                i++;
            } else {
                int correctIndex = A[i] - 1;
                if (A[i] == A[correctIndex]) {
                    i++;
                } else {
                    int temp = A[i];
                    A[i] = A[correctIndex];
                    A[correctIndex] = temp;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }

    static int findNumTwo(int A[]) {
        int n = A.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(A[i]);
        }

        for (int i = 1; i < n; i++) {
            if (hs.contains(i) == false) {
                return i;
            }
        }
        return n + 1;
    }

    static int findNumOne(int A[]) {
        int n = A.length;
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int m = n + 1;
        ans = (m * (m + 1) / 2) - sum;

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5 };
        System.out.println(findNumOne(arr));
    }
}
