package grind75

import "sort"

func threeSum(nums []int) [][]int {
	result := make([][]int, 0)
	sort.Ints(nums) // important
	for i := 0; i < len(nums)-1; i++ {
		if i == 0 || nums[i] != nums[i-1] { // skip duplicate values
			j, k := i+1, len(nums)-1
			for j < k {
				if nums[i]+nums[j]+nums[k] == 0 {
					for ; j < k && nums[j] == nums[j+1]; j++ { // skip duplicate values
					}
					for ; j < k && nums[k] == nums[k-1]; k-- { // skip duplicate values
					}
					result = append(result, []int{nums[i], nums[j], nums[k]})
					j++ // remember to reduce
					k-- // remember to reduce
				}
				if j < k && nums[i]+nums[j]+nums[k] > 0 { // search need sort first
					k-- // search
				}
				if j < k && nums[i]+nums[j]+nums[k] < 0 { // search need sort first
					j++ // search
				}
			}
		}
	}
	return result
}
