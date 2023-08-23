package slidingWindow;



//Creating Spiral 2D Array
class SpiralMatrix{

    //method to create Spiral Matrix
    static int[][] createSpiralMatrix(int A){
        int arr[][] = new int[A][A];
        if(A==1){
            arr[0][0] = 1;
            return arr;
        }
        int n = A;
        int i=0, j=0, x=1;

        while(n>1){
            for(int k=0; k<n-1; k++){
                arr[i][j] = x;
                x++;
                j++;
            }
            for(int k=0; k<n-1; k++){
                arr[i][j] = x;
                x++;
                i++;
            }
            for(int k=0; k<n-1; k++){
                arr[i][j] = x;
                x++;
                j--;
            }
            for(int k=0; k<n-1; k++){
                arr[i][j] = x;
                x++;
                i--;
            }
            i++;
            j++;
            n = n-2;
            if(n==1){
                arr[i][j] = x;
            }
        }
        return arr;
    }

    static void print2DArray(int A[][]){
        int n = A.length, m = A[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int A = 5;
        print2DArray(createSpiralMatrix(A));
    }
}