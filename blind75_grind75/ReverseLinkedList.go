package main

func reverseList(head *ListNode) *ListNode {
	/*
		Input: head = [1,2,3,4,5]
		Output: [5,4,3,2,1]
		1->2->3->4->5->nil
		5->4->3->2->1->nil
		方法1：使用栈存储，然后再反转
		方法2：使用递归，从尾巴向后反转指针 // 这里需要注意传入的应该是node, 通过node.next.next == nil 来判断才对
		方法3：使用循环，从尾巴向后反转
	*/
}
