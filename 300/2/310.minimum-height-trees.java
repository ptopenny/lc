/*
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 *
 * algorithms
 * Medium (29.00%)
 * Total Accepted:    44K
 * Total Submissions: 151.7K
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * 
 * ⁠   For a undirected graph with tree characteristics, we can choose any node
 * as the root. The result graph is then a rooted tree. Among all possible
 * rooted trees, those with minimum height are called minimum height trees
 * (MHTs).
 * ⁠   Given such a graph, write a function to find all the MHTs and return a
 * list of their root labels.
 * 
 * 
 * 
 * ⁠   Format
 * ⁠   The graph contains n nodes which are labeled from 0 to n - 1.
 * ⁠   You will be given the number n and a list of undirected edges (each edge
 * is a pair of labels).
 * 
 * ⁠
 * You can assume that no duplicate edges will appear in edges. Since all edges
 * are
 * ⁠   undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in
 * ⁠   edges.
 * 
 * 
 * ⁠   Example 1:
 * 
 * 
 * ⁠   Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 * 
 * 
 * ⁠       0
 * ⁠       |
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * 
 * 
 * ⁠   return  [1]
 * 
 * 
 * 
 * ⁠   Example 2:
 * 
 * 
 * ⁠   Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 * 
 * ⁠    0  1  2
 * ⁠     \ | /
 * ⁠       3
 * ⁠       |
 * ⁠       4
 * ⁠       |
 * ⁠       5
 * 
 * 
 * ⁠   return  [3, 4]
 * 
 * 
 * 
 * ⁠   Note:
 * 
 * 
 * ⁠   (1) According to the definition
 * ⁠   of tree on Wikipedia: “a tree is an undirected graph in which any two
 * vertices are connected by
 * ⁠   exactly one path. In other words, any connected graph without simple
 * cycles is a tree.”
 * 
 * 
 * ⁠   (2) The height of a rooted tree is the number of edges on the longest
 * downward path between the root and a
 * ⁠   leaf.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            if (!map.containsKey(e[0])) map.put(e[0], new HashSet<>());
            if (!map.containsKey(e[1])) map.put(e[1], new HashSet<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key).size() == 1) q.offer(key);
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                Integer node = q.poll();
                for (Integer d : map.get(node)) {
                    map.get(d).remove(node);
                    if (map.get(d).size() == 1) q.offer(d);
                }
            }
        }
        while (!q.isEmpty()) res.add(q.poll());
        return res;
    }
}
