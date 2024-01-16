package neetcode150.binarysearch;
/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">search-a-2d-matrix</a>
 * You are given an m x n integer matrix, matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // binary search first level
        int start = 0, rows = matrix.length, cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            System.out.println(mid);
            System.out.println(mid/cols);
            System.out.println(mid%cols);
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        // binary search array
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        int target = 3;
        int target = 13;
        boolean ret = new SearchA2DMatrix().searchMatrix(matrix, target);
        System.out.println(ret);
    }
}
