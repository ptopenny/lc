/*
 * [354] Russian Doll Envelopes
 *
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (32.47%)
 * Total Accepted:    27.8K
 * Total Submissions: 85.7K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * You have a number of envelopes with widths and heights given as a pair of
 * integers (w, h). One envelope can fit into another if and only if both the
 * width and height of one envelope is greater than the width and height of the
 * other envelope.
 * 
 * 
 * What is the maximum number of envelopes can you Russian doll? (put one
 * inside other)
 * 
 * 
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes
 * you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            }
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        
        int res = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
