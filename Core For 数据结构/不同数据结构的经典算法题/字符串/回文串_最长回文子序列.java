

/**
 * @author Super-Zhang
 * @date 2021-06-29 17:01
 *
 * LeetCode:
 * 最⻓回⽂⼦序列
 * 给定⼀个字符串s，找到其中最⻓的回⽂⼦序列。 返回序列长度。可以假设s的最⼤⻓度为1000。
 * 最⻓回⽂⼦序列和上⼀题最⻓回⽂⼦串的区别是，⼦串是字符串中连续的⼀个序列，⽽⼦序
 * 列是字符串中保持相对位置的字符序列，例如，"bbbb"可以是字符串"bbbab"的⼦序列但不是⼦串。
 *
 * 本题较难，需要用到动态规划！
 */
public class 回文串_最长回文子序列 {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i]=1;

            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }

        return dp[0][len - 1];
    }
}
