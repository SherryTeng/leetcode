import java.util.ArrayList;
import java.util.*;

public class WordBreak {
//
//    static class TrieNode {
//        TrieNode[] children = new TrieNode[26];
//        boolean isEnd;
//    }
//
//    private static TrieNode trie(List<String> words) {
//        TrieNode root = new TrieNode();
//        for (String word : words) {
//            TrieNode curr = root;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                if (curr.children[ch-'a'] == null) {
//                    curr.children[ch-'a'] = new TrieNode();
//                }
//                curr = curr.children[ch-'a'];
//            }
//
//            curr.isEnd = true;
//        }
//        return root;
//    }
//
//
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        TrieNode root = trie(wordDict);
//        boolean[] f = new boolean[s.length()+1];
//        f[s.length()] = true;
//
//        for (int i = s.length()-1; i >=0; i--) {
//            TrieNode curr = root;
//            for (int j = i ; curr != null && j < s.length(); j++) {
//                curr = curr.children[s.charAt(j)-'a'];
//                if (curr != null && curr.isEnd && f[j+1]) {
//                    f[i] = true;
//                    break;
//                }
//            }
//        }
//        return f[0];

        public boolean wordBreak(String s, Set<String> dict) {
            if (s == null || s.length() == 0) return false;

            int n = s.length();

            // dp[i] represents whether s[0...i] can be formed by dict
            boolean[] dp = new boolean[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    String sub = s.substring(j, i + 1);

                    if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                        dp[i] = true;
                        break;
                    }
                }
            }



            return dp[n - 1];
        }

//        class Solution {
//            int[] memo;
//
//            public boolean wordBreak(String s, List<String> wordDict){
//                memo = new int[s.length()];
//                Arrays.fill(memo, -1);
//                return dp(s, 0, wordDict);
//            }
//
//            public boolean dp(String s, int i, List<String> wordDict){
//                // base case 整段s都被拼出来
//                if(i == s.length()){
//                    return true;
//                }
//
//                if(memo[i] != -1){
//                    return memo[i] == 1 ? true: false;
//                }
//
//                // 挨个试wordDict里的word
//                for (String word: wordDict){
//                    int len = word.length();
//                    if (i + len > s.length()){
//                        continue;
//                    }
//
//                    // 如果有word可以拼出来 就继续check剩下的部分
//                    String subStr = s.substring(i, i + len);
//                    if(! subStr.equals(word)){
//                        continue;
//                    }
//
//                    if(dp(s, i + len, wordDict)){
//                        memo[i] = 1;
//                        return true;
//                    }
//                }
//                memo[i] = 0;
//                return false;
//            }
//        }
    }


