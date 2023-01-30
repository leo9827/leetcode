package grind75

func insert(intervals [][]int, newInterval []int) [][]int {
	result := make([][]int, 0)
	i := 0
	for ; i < len(intervals); i++ {
		itv := intervals[i]
		if itv[1] < newInterval[0] {
			result = append(result, itv)
		} else {
			break
		}
	}

	for ; i < len(intervals); i++ {
		itv := intervals[i]
		if itv[0] <= newInterval[0] || itv[0] <= newInterval[1] {
			newInterval[0] = min(itv[0], newInterval[0])
			newInterval[1] = max(itv[1], newInterval[1])
		} else {
			break
		}
	}
	result = append(result, newInterval)

	for ; i < len(intervals); i++ {
		itv := intervals[i]
		result = append(result, itv)
	}
	return result

}

func min(i, j int) int {
	if i > j {
		return j
	}
	return i
}
func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}
