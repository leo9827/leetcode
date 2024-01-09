package grind75

func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i, x := range nums {
		need := target - x
		if n, ok := m[need]; ok {
			return []int{i, n}
		}
		m[x] = i
	}
	return nil
}
