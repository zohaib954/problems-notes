/*
 * Given an array and an integer k, find and print the distinct elements within each window
of length k.
 */
package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DistinctElem {
    
    static void solve(int A[], int k){
        int n = A.length;
        if(k >= n){
            HashSet<Integer> hs = new HashSet<>();
            
            for(Integer elem: A){
                hs.add(elem);
            }
           
            for(Integer elem: hs){
                System.out.print(elem+" ");
            }
            System.out.println();
            return;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<k; i++){
            hm.put(A[i], hm.getOrDefault(A[i], 0)+1);
        }

        System.out.print("Window 1: ");
        for(int i=0; i<k; i++){
            if(hm.get(A[i]) == 1){
                System.out.print(A[i] +",");
            }
        }
        System.out.println();
        for(int i=k; i<n; i++){
            hm.put(A[i-k], hm.get(A[i-k])-1);

            hm.put(A[i], hm.getOrDefault(A[i], 0)+1);
            System.out.print("Window "+(i-k+2)+": ");
            for(int j=i-k; j<=i; j++){
                
                    System.out.print(A[j]+",");
                
            }
            System.out.println();

        }
    }
    static void solve2(int A[], int k){
        int n = A.length;
        if(n == 0){
            return;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        if(k >= n){
          
            HashSet<Integer> hs = new HashSet<>();
            for(Integer elem: A){
                hs.add(elem);
            }

            for(Integer elem: hs){
                System.out.print(elem+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<k; i++){
           hm.put(A[i], hm.getOrDefault(A[i], 0)+1);
        }
        for(int i = 0; i<k; i++){
            if(hm.get(A[i]) == 0 || hm.get(A[i]) == 1)
            System.out.print("Window 1: "+A[i]+" ");
        }
        System.out.println();

        for(int i=k; i<n; i++){
            hm.remove(A[i-k]);
            hm.put(A[i], hm.getOrDefault(A[i], 0)+1);
            System.out.print("Window "+(i-k+2)+": ");
            for(int j=i-k; j<=i; j++){
                if(hm.containsKey(A[j]))
                System.out.print( A[j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] A = {1,1,1,2, 2,3, 3,4, 4,1,2, 1, 2, 5, 3, 7, 8};
        System.out.println(A.length);
        int k = 3;
        System.out.println(Arrays.toString(A)+" k: "+k);
        solve2(A, k);
    }
}
