package main

import (
	"sort"
)

func combinationSum(candidates []int, target int) [][]int {
	var ans [][]int

	if len(candidates) == 0 {
		return ans
	}
	sort.Ints(candidates)
	backtracking(0, []int{}, 0, target, candidates, &ans)
	return ans
}

func backtracking(i int, cur []int, total, target int, candidates []int, ans *[][]int) {
	if total == target {
		*ans = append(*ans, append([]int{}, cur...))
		return
	}
	if i >= len(candidates) || total > target {
		return
	}
	cur = append(cur, candidates[i])
	// 决策1 使用当前位置i的数据
	backtracking(i, cur, total+candidates[i], target, candidates, ans)
	cur = cur[:len(cur)-1] // 移除掉刚才添加到末尾的元素 // backtrack前是先添加再校验的，不通过的话需要把上一步append的的元素移除掉，通过的话解会在上面的if判断中保存起来
	// 决策2 不再使用当前位置i的数据
	backtracking(i+1, cur, total, target, candidates, ans)
}

func main() {
	combinationSum([]int{2, 3, 6, 7}, 7)
}
