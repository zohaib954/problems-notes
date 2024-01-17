package recursion;

public class RecursionSimpleProblems {
//Find factorial of a given number
static int fact(int n){
    if(n==0){
        return 1;
    }
    return n*fact(n-1);
}

//Find Fibonacci series
static int findFibonacci(int n){
    if(n==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    return findFibonacci(n-1) + findFibonacci(n-2);
}
 
//check palindrome using recursion, return 1 if string is palindrome else 0;
static int palindrome(String A){
    if(A.length() == 1 || A.length() == 0) return 1 ;
    char s = A.charAt(0), e = A.charAt(A.length()-1);
    A = A.substring(1, A.length()-1);
    if((s == e) && (palindrome(A) == 1)) return 1;
    return 0;
}

//sum of Digits
static int sumDigits(int A){
    if(A==0){
        return 0;
    }
    int ans = A%10;
    return ans+ A/10;
}
//reverse Strng
static void reverse(String str, int e){
    if(e==0){
        return;
    }
    System.out.print(str.charAt(e-1));
    reverse(str, e-1);
}

//print numbers from 1 to n
static void printFrom1toN(int A){
    if(A==0){
        return;
    }
    printFrom1toN(A-1);
    System.out.print(A+" ");
}

//print numbers from n to 1
static void printFromNto1(int A){
    if(A==0){
        return;
    }
    System.out.print(A+" ");
    printFromNto1(A-1);
}


    public static void main(String[] args) {

    }

}
