public class Quicks { // QuickSort function
    /**
     * QuickSort:
     * Time Complexity:
     * - Best Case: O(n log n) (when the pivot divides the array into two equal halves)
     * - Average Case: O(n log n)
     * - Worst Case: O(n^2) (when the pivot is the smallest or largest element, leading to unbalanced partitions)
     * 
     * Space Complexity:
     * - O(log n) (due to recursive stack calls)
     * 
     * Comparison with Merge Sort:
     * - QuickSort is generally faster in practice due to better cache performance.
     * - MergeSort has a guaranteed O(n log n) time complexity for all cases, while QuickSort can degrade to O(n^2) in the worst case.
     * - MergeSort requires O(n) additional space for merging, while QuickSort is in-place and requires less space.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}