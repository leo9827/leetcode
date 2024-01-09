package neetcode150

// https://leetcode.com/problems/contains-duplicate/
func containsDuplicate(nums []int) bool {
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] == nums[i+1] {
			return true
		}
	}
	table := make(map[int]int)
	for _, num := range nums {
		if table[num] != 0 {
			return true
		} else {
			table[num] = 1
		}
	}
	return false
}
