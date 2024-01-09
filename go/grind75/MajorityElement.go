package grind75

func majorityElement(nums []int) int {
	vote := 0
	majority := 0
	for _, num := range nums {
		if vote == 0 {
			majority = num
		}
		// vote
		if majority == num {
			vote++
		} else {
			vote--
		}
	}
	return majority
}
