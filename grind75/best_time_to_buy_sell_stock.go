package grind75

// case1 [7,1,5,3,6,4]
// case2 [7,6,4,3,1]

func maxProfit(prices []int) int {
	minPrice := prices[0]
	maxProfit := 0
	for _, p := range prices {
		if minPrice > p {
			minPrice = p
		}
		if maxProfit < p-minPrice {
			maxProfit = p - minPrice
		}
	}
	return maxProfit
}
