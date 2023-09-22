import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {
    public static class Trie {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd;
        }

        //field
        TrieNode root;

        //constructor
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.children[ch-'a'] == null) {
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }

            curr.isEnd = true;
        }


        public List<String> startsWith(String prefix) {
            List<String> words = new ArrayList<>();
            TrieNode curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (curr.children[ch-'a'] == null) return words;
                curr=curr.children[ch-'a'];
            }
            dfs(curr, prefix, words);
            return words;
        }

        private void dfs(TrieNode curr, String prefix, List<String> words) {
            if (words.size() == 3) return;
            if (curr.isEnd) words.add(prefix);
            for (char ch = 'a'; ch <='z'; ch++) {
                if (curr.children[ch-'a'] != null) {
                    dfs(curr.children[ch-'a'], prefix+ch, words);
                }
            }
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        //construct trie
        Trie productsTrie = new Trie();
        for (String product : products) {
            productsTrie.insert(product);
        }

        //search
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String subString = searchWord.substring(0, i);
            List<String> atMostThree = productsTrie.startsWith(subString);
            res.add(atMostThree);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};

        List<List<String>> res = SearchSuggestionSystem.suggestedProducts(products, "mouse");
        for (List<String> string : res) {
            System.out.println(string);
        }
    }

}
