/* Given a string consisting of words, write a function to calculate the number of words with
odd lengths and the number of words with even lengths. Question(follow-up): Was asked
to provide the solution using a for loop. */
package String;

import java.util.Arrays;

public class OddEvenWords {
    static int[] solve(String A){
        String[] s = A.split(" ");
        int n = s.length;
        int even = 0, odd = 0;

        for(int i=0; i<n; i++){
            if(s[i].length()%2 == 0){
                even++;
            }
            else{
                odd++;
            }
        }
        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        String A = "Hello my name is Zohaib AHmed";

        System.out.println(Arrays.toString(solve(A)));
    }
}
