package main

import (
	"fmt"

	"github.com/ujjwalkirti/leetcode/graph"
)

func main() {
	times := [][]int{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}
	n := 4
	k := 2
	ans := graph.NetworkDelayTime(times, n, k)
	fmt.Println(ans)
}
