package codewars

import (
	"sort"
)

// TwoStringsToOne takes two strings and produces one
// of uniq characters and in sorted order
func TwoStringsToOne(s1 string, s2 string) string {
	uniqMap := make(map[byte]bool)
	s := s1 + s2

	for i := 0; i < len(s); i++ {
		uniqMap[s[i]] = true
	}

	keys := make([]int, len(uniqMap))
	i := 0
	for k := range uniqMap {
		keys[i] = int(k)
		i++
	}
	sort.Ints(keys)

	bytes := make([]byte, len(keys))
	i = 0
	for _, v := range keys {
		bytes[i] = byte(v)
		i++
	}

	return string(bytes)
}
