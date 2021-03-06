/*
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (43.24%)
 * Total Accepted:    19.8K
 * Total Submissions: 45.9K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1:
 * 
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * 
 * 
 * 
 * Note:
 * 
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * 
 * 
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return a.length() == b.length() ? a.compareTo(b) : b.length() - a.length();
            }
        });

        for (int i = 0; i < d.size(); i++) {
            String dictS = d.get(i);
            int idx = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == dictS.charAt(idx)) idx++;
                if (idx == dictS.length()) return dictS;
            }
        }
        return "";
    }
}
