

class Practice{

    

    public static void main(String[] args) {
       int A[] = {1,2,3,4,5};
       int n = A.length;
       int B = 5;
       int size = 0, i=0, j =0, start=0;

       for(  i=0; i<n; i++){
        for(  j=i; j<n; j++){
            int sum = 0;
            for(int k=i; k<=j; k++){
                sum += A[k];
            }
            if(sum == B){
                size = j-i+1;
                start = i-1;
                i = n;
            }
        }
       }
       
       int ans[] = new int[size];
       for(int q=0; q<size; q++){
        ans[q] = A[start];
        start++;
       }
       for(int q=0; q<size; q++){
        System.out.print(ans[q]+" ");
       }
}
}