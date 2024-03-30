package bitManipulation;

import java.util.Arrays;

public class BagsXOR {
    static int solve(int A[]){
        int n = A.length;
        int sum = 0;
        int half = n/2;
        int last = n-1;
        int red[] = new int[half];
        int blue[] = new int[half];

       int left = 0, right = n-1;
       while (left < right) {
        int temp1 = A[left];
        int temp2 = A[right];
        int max = Math.max(temp1, temp2);
        int min = Math.min(temp1, temp2);
        red[left] = max;
        blue[left] = min;
        left++;
        right--;
       }
        last = n/2-1;
        System.out.println( Arrays.toString(red));
        System.out.println( Arrays.toString(blue));
        for(int i=0; i<half; i++){
            int temp = red[i]^blue[last];
            last--;
            System.out.println(temp);
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        int A[] = {23,35,6,25,10,34,29,13,35,1,6,7};
        System.out.println(solve(A));
    }
}
