package grind75

func productExceptSelf(nums []int) []int {
	result := make([]int, len(nums))
	product := 1
	zeroCount := 0
	for _, n := range nums {
		if n == 0 {
			zeroCount++
			continue
		}
		product = product * n
	}
	if zeroCount == 0 {
		for i, n := range nums {
			result[i] = product / n
		}
		return result
	} else if zeroCount == 1 {
		for i, n := range nums {
			if n == 0 {
				result[i] = product
			} else {
				result[i] = 0
			}
		}
		return result

	} else {
		return result
	}
}
