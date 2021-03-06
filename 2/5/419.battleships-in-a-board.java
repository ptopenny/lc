/*
 * [419] Battleships in a Board
 *
 * https://leetcode.com/problems/battleships-in-a-board/description/
 *
 * algorithms
 * Medium (62.94%)
 * Total Accepted:    40.6K
 * Total Submissions: 64.5K
 * Testcase Example:  '[["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]'
 *
 * Given an 2D board, count how many battleships are in it. The battleships are
 * represented with 'X's, empty slots are represented with '.'s. You may assume
 * the following rules:
 * 
 * 
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words,
 * they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1
 * column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships -
 * there are no adjacent battleships.
 * 
 * 
 * Example:
 * X..X
 * ...X
 * ...X
 * 
 * In the above board there are 2 battleships.
 * 
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * 
 * This is an invalid board that you will not receive - as battleships will
 * always have a cell separating between them.
 * 
 * Follow up:Could you do it in one-pass, using only O(1) extra memory and
 * without modifying the value of the board?
 */
class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') res += check(board, i, j);
            }
        }
        return res;
    }

    public int check(char[][] board, int i, int j) {
        int x = i + 1;
        int y = j + 1;
        if (x >= board.length && y >= board[0].length) return 1;
        if (x < board.length && y < board[0].length) {
            return (board[i][y] != 'X' && board[x][j] != 'X') ? 1 : 0;
        }
        if (x < board.length) return (board[x][j] != 'X') ? 1 : 0;
        if (y < board[0].length) return (board[i][y] != 'X') ? 1 : 0;
        return 0;
    }
}
