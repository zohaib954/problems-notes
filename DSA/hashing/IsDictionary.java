/*  Q6. Is Dictionary? (Day 32, 16 Feb)
    Problem Description
Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order.
 The order of the alphabet is some permutation of lowercase letters.
Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of
size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

Problem Constraints
1 <= N, length of each word <= 105
Sum of the length of all words <= 2 * 106

Input Format
The first argument is a string array A of size N.
The second argument is a string B of size 26, denoting the order.

Output Format
Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

Example Input
Input 1:
 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"

Input 2:
 A = ["fine", "none", "bush"]
 B = "qwertyuiopasdfghjklzxcvbnm"

Example Output
Output 1:
 1

Output 2:
 0

Example Explanation
Explanation 1:
 The order shown in string B is: h < s < i (adhbcfegskjlponmirqtxwuvzy) for the given words. 
 So, Return 1.

Explanation 2:
 "none" should be present after "bush", Since b < n (qwertyuiopasdfghjklzxcvbnm). 
 So, Return 0.
 * 
 */

 package hashing;

import java.util.HashMap;

class IsDictionary{
    static int solve(String[] A, String B){

        return 0;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer > hm = new HashMap<>();

        String[] s = {"fine", "none", "bush"};
        String q = "qwertyuiopasdfghjklzxcvbnm";

        int n = q.length();
        int n1 = s.length;

        for(int i=0; i<n; i++){
            if(hm.containsKey(q.charAt(i))){
                continue;
            }
            else{
                hm.put( q.charAt(i), i+1);
            }
        }

        
        int i=0;
        while(i<n1-1){
            Character temp1 =  s[i].charAt(i);
            Character temp2 = s[i+1].charAt(i+1);
            if(hm.get(temp1)> hm.get(temp2)){
                System.out.println(0);
            }else System.out.println(1);
            i++;
        }
        
    }
 }