package grind75

func majorityElement(nums []int) int {
	vote, majority := 0, 0

	for _, num := range nums {
		if vote == 0 {
			majority = num
		}
		if majority == num {
			vote++
		} else {
			vote--
		}
	}
	return majority
}
