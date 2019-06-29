package codewars

import (
	"strings"
)

func FindShort(s string) int {
	min := len(s)

	for _, str := range strings.Split(s, " ") {
		if len(str) < min {
			min = len(str)
		}
	}

	return min
}
