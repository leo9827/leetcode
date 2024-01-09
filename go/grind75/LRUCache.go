package grind75

type LRUCache struct {
	Head *Node
	Tail *Node
	HT   map[int]*Node
	Cap  int
}

type Node struct {
	Key  int
	Val  int
	Prev *Node
	Next *Node
}

func Constructor(capacity int) LRUCache {
	return LRUCache{HT: make(map[int]*Node), Cap: capacity}
}

func (c *LRUCache) Get(key int) int {
	node, ok := c.HT[key]
	if ok {
		c.Remove(node)
		c.Add(node)
		return node.Val
	}
	return -1
}

func (c *LRUCache) Put(key int, value int) {
	node, ok := c.HT[key]
	if ok {
		node.Val = value
		c.Remove(node)
		c.Add(node)
		return
	} else {
		node = &Node{Key: key, Val: value}
		c.HT[key] = node
		c.Add(node)
	}
	if len(c.HT) > c.Cap {
		delete(c.HT, c.Tail.Key)
		c.Remove(c.Tail)
	}
}

func (c *LRUCache) Add(node *Node) {
	node.Prev = nil
	node.Next = c.Head
	if c.Head != nil {
		c.Head.Prev = node
	}
	c.Head = node
	if c.Tail == nil {
		c.Tail = node
	}
}

func (c *LRUCache) Remove(node *Node) {
	if node != c.Head {
		node.Prev.Next = node.Next
	} else {
		c.Head = node.Next
	}
	if node != c.Tail {
		node.Next.Prev = node.Prev
	} else {
		c.Tail = node.Prev
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
