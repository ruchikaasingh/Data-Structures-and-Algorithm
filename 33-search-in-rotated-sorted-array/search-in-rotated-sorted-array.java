class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // always check the target first before moving pointers
            if (arr[mid] == target) {
                return mid;
            }

            //identify which half is normally sorted
            if (arr[low] <= arr[mid]) { // Left half is sorted

                //target exists within this sorted left half
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1; // Narrow down to the left
                } else {
                    low = mid + 1;  //it must be on the right
                }
            } 
            else { // Right half must be sorted

                //target exists within this sorted right half
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;  // Narrow down to the right
                } else {
                    high = mid - 1; // Otherwise, it must be on the left
                }
            }
        }
        return -1;
    }
}