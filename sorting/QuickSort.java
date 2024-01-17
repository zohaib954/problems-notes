package sorting;

public class QuickSort {
    static void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int partition(int A[], int s, int e) {
        int p = A[e];
        int i = s - 1;
        for (int j = s; j < e; j++) {
            if (A[j] < p) {
                i++;
                swap(A, i, j);
            }
        }
        i++;
        swap(A, i, e);
        return i;
    }

    static void quickSort(int A[], int s, int e) {
        if (s >= e) {
            return;
        }
        int p = partition(A, s, e);
        quickSort(A, s, p - 1);
        quickSort(A, p + 1, e);
    }

    public static void main(String[] args) {
        int A[] = { 8, 4, 9, 3, 2, 0, 1, 6, 10, 20, 15, 7 };
        for (int elem : A) {
            System.out.print(elem + " ");
        }
        System.out.println();
        quickSort(A, 0, A.length - 1);
        for (int elem : A) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
