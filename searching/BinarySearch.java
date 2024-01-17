// given a sorted Array find the greatest number that is less then or equal to key;

package searching;

public class BinarySearch {
    static int searchKey(int A[], int key) {
        int n = A.length;
        int left = 0, right = n - 1;
        int mid = 0;
        int ans = Integer.MIN_VALUE;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (A[mid] <= key) {
                ans = A[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A[] = { 2, 2, 3, 6, 7, 8, 9, 20, 21 };
        int key = searchKey(A, 10);
        System.out.println(key);
    }
}
