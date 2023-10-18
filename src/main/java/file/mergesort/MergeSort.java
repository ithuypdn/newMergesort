/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package file.mergesort;

/**
 *
 * @author huypd
 */
public class MergeSort {
    //merge sort đệ quy
    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    //merge sort ko đệ quy
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int currSize = 2;
        while (currSize < n*2) {
           int left = 0;
            while (left < n - 1) {
                int distance = currSize - 1;
                int mid = Math.min(left + currSize/2 + 1, n - 1);
                int right = Math.min(left + distance, n - 1);
                //int mid = (left + right - 1)/2;
                merge(arr, left, mid, right);
                left = left + currSize;
            }
           currSize = 2*currSize;
        }
//        for (int currSize = 2; currSize < n*2; currSize = 2 * currSize)
//            for (int left = 0; left < n - 1; left += currSize) {
//                int distance = currSize - 1;
//                int mid = Math.min(left + currSize/2 - 1, n - 1);
//                int right = Math.min(left + distance, n - 1);
//                //int mid = (left + right-1)/2;
//                merge(arr, left, mid, right);
//            }
    }
    
    private static void merge(int[] arr, int l, int middle, int r) {
        //xác định kích thước 2 mảng con cần trộn
        int size1 = middle - l + 1; //kích thước mảng con trái
        int size2 = r - middle; //kích thước mảng con phải
        //tạo mảng con để lưu các phần tử để merge
        int[] leftArr = new int[size1];
        int[] rightArr = new int[size2];
        //cho dữ liệu vào mảng con trái
        for (int i = 0; i < size1; i++) 
            leftArr[i] = arr[l+i];
        //cho dữ liệu vào mảng con phải
        for (int j = 0; j < size2; j++) 
            rightArr[j] = arr[middle + 1 + j];
        //tiến hành merge
        int i = 0, j = 0, k = l;
        while (i < size1 && j < size2)
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        while (i < size1)
            arr[k++] = leftArr[i++];
        while (j < size2)
            arr[k++] = rightArr[j++];
        
    }
    
    private static void showArrayElement(int[] arr) {
        for (int e : arr) 
           System.out.print(e + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 26, 30, 27, 11, 54, 3, 4, 0, 9, 8, 79, 6, 5};
        showArrayElement(arr);
        mergeSort(arr);
        showArrayElement(arr);
    }

}
