/*
 * Q:- Good Pair (Day 17 intermediate dsa easy)
 * Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.

Problem Constraints
1 <= A.size() <= 104
1 <= A[i] <= 109
1 <= B <= 109

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return 1 if good pair exist otherwise return 0.

Example Input
Input 1:
A = [1,2,3,4]
B = 7

Input 2:
A = [1,2,4]
B = 4

Input 3:
A = [1,2,2]
B = 4

Example Output
Output 1:
1

Output 2:
0

Output 3:
1

Example Explanation
Explanation 1:
 (i,j) = (3,4)

Explanation 2:
No pair has sum equal to 4.

Explanation 3:
 (i,j) = (2,3)
 */

 /*
  * Solution approach:-
  solution 1:- intuition 
                    create 2 nested loops i and j, i starts from 0 to n-2 and j starts from i+1 to n-1;
                    check wetather A[i]+A[j] == B then return 1; if booth loops end then there is no good pair finally return 0;
            Time complexity O(N^2) Space complexity O(1);

  solution 2:- -> create hashmap of both integer data type as key:value and add array element as key and index as value.
               -> start another loop from 0 to n-1 and calculate B-A[i].
               -> check if B-A[i] is present in the hashmap or not along with it check if value of B-A[i] in hashmap is not equal
                  to i. if true then return 1;
  */

  package arrayProblems;
  import java.util.HashMap;
  class GoodPair{
    static int solution(int A[], int B){
        int n = A.length;
        HashMap<Integer, Integer> hs = new HashMap<>();

        for(int i=0; i<n; i++){
            hs.put(A[i], i);
        }

        for(int i=0; i<n; i++){
            int c = B - A[i];
            if(hs.containsKey(c) && hs.get(c) != i){
                return 1;
            }
        }
        return 0;
    }

    //if we need an index of the pair
    static int[] indexSolution(int A[], int B){
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<n; i++){
            hm.put(A[i], i);
        }
        for(int i=0; i<n; i++){
            int c = B-A[i];
            if(hm.containsKey(c) && hm.get(c) > i){
                return new int[]{i,hm.get(c)};
            }
        }
        return new int[]{};
    }

    //you can solve it by using binary search, try.

    public static void main(String[] args) {
        int A[] = {1,2,3,7,20};

        int ans[] = indexSolution(A, 27);

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
  }