package sorting;

public class MergeSort {
    static void divide(int A[], int s, int e){
        if(s>=e){
            return;
        }

        int m = s + (e-s)/2;
       
        
        divide(A, s, m);
       
        divide(A, m+1, e);
        merge(A,s,m,e);
    }

    static void merge(int A[], int s, int m, int e){
        int n1 = m-s+1, n2 = e-m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0; i<n1; i++){
            L[i] = A[s+i];
        }
        for(int j=0; j<n2; j++){
            R[j] = A[m+1+j];
        }

        
        int i=0, j=0, k=s;

        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                A[k] = L[i];
                i++;
            }
            else{
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            A[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            A[k] = R[j];
            j++;
            k++;
        }
        
    }

    public static void main(String[] args) {
        int arr[] = {10,3,6,2,8,12,15,18};
       int s = 0, n = arr.length;
        divide(arr,s, n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
       
    }
}
