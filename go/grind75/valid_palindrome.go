package grind75

import "strings"

func isPalindrome(s string) bool {
	start, end := 0, len(s)-1

	for start < end {
		for start < end && !isAlphaNumeric(int(s[start])) {
			start++
		}

		for start < end && !isAlphaNumeric(int(s[end])) {
			end--
		}

		if strings.ToLower(string(s[start])) != strings.ToLower(string(s[end])) {
			return false
		}

		start++
		end--
	}

	return true
}

func isAlphaNumeric(asciCode int) bool {
	return (int('a') <= asciCode && asciCode <= int('z')) ||
		(int('A') <= asciCode && asciCode <= int('Z')) ||
		(int('0') <= asciCode && asciCode <= int('9'))
}
