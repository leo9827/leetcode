package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}
	one, two := head, head

	for two.Next != nil && two.Next.Next != nil {
		one = one.Next
		two = two.Next.Next
		if two == one {
			return true
		}
	}
	return false
}

func hasCycle2(head *ListNode) bool {
	slow, fast := head, head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return true
		}
	}

	return false
}