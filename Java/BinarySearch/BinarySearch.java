public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchHelper(arr, target, mid + 1, right);
        } else {
            return binarySearchHelper(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};

        int target = 7;
        System.out.println("Index of target " + target + ": " + binarySearch(arr, target));

        target = 4;
        System.out.println("Index of target " + target + ": " + binarySearch(arr, target));

    }
}
