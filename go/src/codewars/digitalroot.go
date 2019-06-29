package codewars

import (
	"strconv"
	"strings"
)

func DigitalRoot(num int) int {
	strings := strings.Split(strconv.Itoa(num), "")
	nums := make([]int, len(strings))
	for i := 0; i < len(strings); i++ {
		nums[i], _ = strconv.Atoi(strings[i])
	}

	sum := 0
	if len(nums) > 1 {
		for _, num := range nums {
			sum += num
		}
		return DigitalRoot(sum)
	}

	return nums[0]
}
