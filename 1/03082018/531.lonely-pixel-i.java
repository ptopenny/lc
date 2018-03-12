/*
 * [531] Lonely Pixel I
 *
 * https://leetcode.com/problems/lonely-pixel-i/description/
 *
 * algorithms
 * Medium (56.23%)
 * Total Accepted:    9.8K
 * Total Submissions: 17.4K
 * Testcase Example:  '[["W","W","B"],["W","B","W"],["B","W","W"]]'
 *
 * Given a picture consisting of black and white pixels, find the number of
 * black lonely pixels.
 * 
 * The picture is represented by a 2D char array consisting of 'B' and 'W',
 * which means black and white pixels respectively. 
 * 
 * A black lonely pixel is character 'B' that located at a specific position
 * where the same row and same column don't have any other black pixels.
 * 
 * Example:
 * 
 * Input: 
 * [['W', 'W', 'B'],
 * ⁠['W', 'B', 'W'],
 * ⁠['B', 'W', 'W']]
 * 
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 * 
 * 
 * 
 * Note:
 * 
 * The range of width and height of the input 2D array is [1,500].
 * 
 * 
 */
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        if (m == 0) return 0;
        int n = picture[0].length;
        if (n == 0) return 0;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    ++row[i];
                    ++col[j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) res++;
            }
        }
        return res;
    }
}
