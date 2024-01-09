package main

func middleNode(head *ListNode) *ListNode {
	walker, runner := head, head
	for runner != nil && runner.Next != nil {
		walker = walker.Next
		runner = runner.Next.Next
	}
	return walker
}
