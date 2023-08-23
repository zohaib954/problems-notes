package The2DArray;

public class SpiralMatrix {
    static int[][] spiralMatrix(int A){
        int n = A;
        int arr[][] = new int[n][n];
        int i = 0, j = 0, x=1;
        if(A==1){
            arr[0][0] = 1;
            return arr;
        }
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
            n= n-2;
            if(n==1){
                arr[i][j] = x;
            }
        }
        return arr;
    }

    static void print2DArray(int A[][]){
        int n = A.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(A[i][j]+ "   ");
            }
            System.out.println();
        }
    }

    //print spiral matrix
    static void printSpiralMatrix(int A[][]){
        int i=0, j=0, n=A.length;
        if(n==1){
            System.out.println(A[i][j]);
            return;
        }
        while(n>=0){
            for(int k=0; k<n; k++){
                System.out.print(A[i][j]+" ");
                j++;
            }
            j--;
            i++;
            System.out.println();
            for(int k=0; k<n-1; k++){
                System.out.print(A[i][j]+" ");
                i++;
            }
            i--;
          
            System.out.println();
            for(int k=0; k<n-1; k++){
                System.out.print(A[i][j]+" ");
                j--;
            }
            j++;
           
            System.out.println();
            for(int k=0; k<n-1; k++){
                System.out.print(A[i][j]+" ");
                i--;
            }
            System.out.println();
            i++;
            j++;
            n -= 1;
            if(n==1){
                System.out.print(A[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int A[][] = {{1,2,3,4}, {6,7,8,9}, {11,12,13,14}, {16, 17, 18, 19}, {21,22,23,24}};
        printSpiralMatrix(A);

    }
}
