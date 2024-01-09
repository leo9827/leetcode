package grind75

func lengthOfLongestSubstring(s string) int {
	if len(s) < 2 {
		return len(s)
	}
	maxlen := 0
	table := map[byte]int{}
	for i, j := 0, 0; j < len(s); j++ {
		c := s[j]

		if table[c] != 0 && table[c] >= i {
			i = table[c] + 1
		}
		maxlen = max(maxlen, j-i+1)
		table[c] = j
	}
	return maxlen
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
