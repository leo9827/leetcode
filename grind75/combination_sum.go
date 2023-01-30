package grind75

import "sort"

/*
Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/

func combinationSum(candidates []int, target int) [][]int {
	// using backtracking
	result := make([][]int, 0)
	ret := make([]int, 0)
	sort.Ints(candidates)
	backtrack(candidates, ret, &result, 0, 0, target)
	return result
}

func backtrack(candidates, ret []int, result *[][]int, index, sum, target int) {
	if sum == target {
		*result = append(*result, append([]int{}, ret...))
		return
	}
	if sum > target || index > len(candidates)-1 {
		return
	}
	ret = append(ret, candidates[index])
	backtrack(candidates, ret, result, index, sum+candidates[index], target)
	ret = ret[:len(ret)-1]
	backtrack(candidates, ret, result, index+1, sum, target)
}
