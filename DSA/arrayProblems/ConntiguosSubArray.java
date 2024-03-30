package arrayProblems;

import java.util.Arrays;

public class ConntiguosSubArray {
    static int[] solve(int A){
        int ans[] = new int[A];
        ans[0] = A;
        ans[A-1] = A;
        if(A == 1){
            return ans;
        }
        int left = 1, right = A-2;
        while(left <= right){
            int temp = ans[left-1] + (A-(left+1));
            System.out.println("left :"+ left+" right :"+right+"temp :"+temp);
            ans[left] = temp;
            ans[right] = temp;
            left++;
            right--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int A = 5;
        System.out.println(Arrays.toString(solve(A)));
    }
}
