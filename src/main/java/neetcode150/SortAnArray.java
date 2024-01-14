package neetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * 912. Sort an Array
 * <a href="https://leetcode.com/problems/sort-an-array/description/">...</a>
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 * Constraints:
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortAnArray {

    class QuickSortSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            quickSort(nums, 0, nums.length - 1);
            for (int i : nums) res.add(i);
            return res;
        }

        private void quickSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int mid = partition(nums, l, r);
            quickSort(nums, l, mid);
            quickSort(nums, mid + 1, r);
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[l];
            while (l < r) {
                while (l < r && nums[r] >= pivot) r--;
                nums[l] = nums[r];
                while (l < r && nums[l] <= pivot) l++;
                nums[r] = nums[l];
            }
            nums[l] = pivot;
            return l;
        }
    }

    class TopDownMergeSortSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            mergeSort(nums, 0, nums.length - 1);
            for (int i : nums) res.add(i);
            return res;
        }

        private void mergeSort(int[] nums, int l, int r) {
            if (l >= r) return;
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, r);
        }

        private void merge(int[] nums, int l, int r) {
            int mid = l + (r - l) / 2;
            int[] tmp = new int[r - l + 1];
            int i = l, j = mid + 1, k = 0;
            while (i <= mid || j <= r) {
                if (i > mid || j <= r && nums[i] > nums[j]) {
                    tmp[k++] = nums[j++];
                } else {
                    tmp[k++] = nums[i++];
                }
            }
            System.arraycopy(tmp, 0, nums, l, r - l + 1);
        }
    }

    class BottomUpMergeSortSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            mergeSort2(nums);
            for (int i : nums) res.add(i);
            return res;
        }

        private void mergeSort2(int[] nums) {
            for (int size = 1; size < nums.length; size *= 2) {
                for (int i = 0; i < nums.length - size; i += 2 * size) {
                    int mid = i + size - 1;
                    int end = Math.min(i + 2 * size - 1, nums.length - 1);
                    merge2(nums, i, mid, end);
                }
            }
        }

        private void merge2(int[] nums, int l, int mid, int r) {
            int[] tmp = new int[r - l + 1];
            int i = l, j = mid + 1, k = 0;
            while (i <= mid || j <= r) {
                if (i > mid || j <= r && nums[i] > nums[j]) {
                    tmp[k++] = nums[j++];
                } else {
                    tmp[k++] = nums[i++];
                }
            }
            System.arraycopy(tmp, 0, nums, l, r - l + 1);
        }
    }

    class HeapSortSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            heapSort(nums);
            for (int i : nums) res.add(i);
            return res;
        }

        private void heapSort(int[] nums) {
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                heapify(nums, i, nums.length - 1);
            }
            for (int i = nums.length - 1; i >= 1; i--) {
                swap(nums, 0, i);
                heapify(nums, 0, i - 1);
            }
        }

        private void heapify(int[] nums, int i, int end) {
            while (i <= end) {
                int l = 2 * i + 1, r = 2 * i + 2;
                int maxIndex = i;
                if (l <= end && nums[l] > nums[maxIndex]) maxIndex = l;
                if (r <= end && nums[r] > nums[maxIndex]) maxIndex = r;
                if (maxIndex == i) break;
                swap(nums, i, maxIndex);
                i = maxIndex;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    class SelectSortSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            selectionSort(nums);
            for (int i : nums) res.add(i);
            return res;
        }

        private void selectionSort(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int minIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < nums[minIndex]) minIndex = j;
                }
                if (minIndex != i) swap(nums, i, minIndex);
            }
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    class InsertionSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            insertionSort(nums);
            for (int i : nums) res.add(i);
            return res;
        }

        private void insertionSort(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                for (int j = i; j >= 1; j--) {
                    if (nums[j] >= nums[j - 1]) break;
                    swap(nums, j, j - 1);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    class BubbleSortSolution {
        public List<Integer> sortArray(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            bubbleSort(nums);
            for (int i : nums) res.add(i);
            return res;
        }

        private void bubbleSort(int[] nums) {
            for (int k = nums.length - 1; k >= 1; k--) {
                for (int i = 0; i < k; i++) {
                    if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
