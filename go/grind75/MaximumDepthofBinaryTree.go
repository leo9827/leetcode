package grind75

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	depth := 1
	maxSub := max(maxDepth(root.Left), maxDepth(root.Right))
	return depth + maxSub
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
