package grind75

func longest_palindrome(s string) int {
	count := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		ch := s[i]
		if _, ok := count[ch]; !ok {
			count[ch] = 1
		} else {
			count[ch] += 1
		}
	}

	ans := 0
	for _, val := range count {
		ans += val / 2 * 2
		if ans%2 == 0 && val%2 == 1 {
			ans += 1
		}
	}

	return ans
}
