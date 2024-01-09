package grind75

func sortColors(nums []int) {
	i, left, right := 0, 0, len(nums)-1
	for i <= right {
		if nums[i] == 0 {
			swap(nums, i, left)
			i++
			left++
		} else if nums[i] == 2 {
			swap(nums, i, right)
			right--
		} else {
			i++
		}
	}
}
func swap(nums []int, a, b int) {
	tmp := nums[a]
	nums[a] = nums[b]
	nums[b] = tmp
}
