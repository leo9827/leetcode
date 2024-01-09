package grind75

func isSameTree(left *TreeNode, right *TreeNode) bool {
	if left == nil || right == nil {
		return left == right
	}
	if left.Val == right.Val {
		return isSameTree(left.Left, right.Left) && isSameTree(left.Right, right.Right)
	}
	return false
}
