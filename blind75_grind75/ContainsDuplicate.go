package main

func containsDuplicate(nums []int) bool {
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
