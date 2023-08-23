/*
 * Shaggy and distances
 * 
 * Problem Description
    Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special
    if elements at those indices in the array are equal.
    Shaggy wants you to find a special pair such that the distance between that pair is minimum.
    Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.



Problem Constraints
1 <= |A| <= 105

Input Format
    The first and only argument is an integer array A.



Output Format
    Return one integer corresponding to the minimum possible distance between a special pair.



Example Input
Input 1:
    A = [7, 1, 3, 4, 1, 7]

Input 2:
    A = [1, 1]


Example Output
    Output 1:
    3

    Output 2:
    1


Example Explanation
Explanation 1:
    Here we have 2 options:
    1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
    2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
    Therefore the minimum possible distance is 3. 

Explanation 2:
    Only possibility is choosing A[1] and A[2].

Solution Approach :-
    step 1 :- create a hashmap of Integer key and Integer value pair;
    step 2 :- start a for loop from 0 to n where n is the number of elements in the array;
    step 3 :- check weather the element of the array is present as the key inside hashmap;
                if true then get the value of the key and store inside a variable;
                then subtract i with the value, assign it to dist variable;
                then check the minimum of ans and dist variables.
    step 4 :- else put the key A[i] and value i inside hashmap (hm.put(A[i],i));
    step 5 :- after for loop, check weather ans == Integer.MAX_VALUE;
                if true then return -1;
    step 6 :- return ans;
 */

 package hashing;

import java.util.HashMap;


 class ShortestDist{
    static int shortestDist(int A[]){
        int n = A.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(hm.containsKey(A[i])){
                int x = hm.get(A[i]);
                int dist = i-x;
                ans = Math.min(ans, dist);
            }
            else{
                hm.put(A[i], i);
            }
        }

        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
       int A[] = {2,8,4,9,2,8,9,3,5,7};
       System.out.println(shortestDist(A));
    }
 }