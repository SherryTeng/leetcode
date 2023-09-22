import java.util.*;
public class WordSearchII_212 {

    class TrieNode {
        TrieNode[] children  =  new TrieNode[26];
        boolean isWord;

        public TrieNode(){}

    }

    TrieNode root = new TrieNode();
    Set<String> res = new HashSet<>();


    public List<String> findWords(char[][] board, String[] words) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        //1. build trie
        buildTrie(words);

        //2.

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (root.children[board[i][j]-'a'] != null) {
                    dfs(board, i, j, root, "", visited);
                }
            }
        }

        return new LinkedList<>(res);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, String word,  boolean[][] visited){
        if (i < 0 || i >= board.length|| j<0|| j >= board[0].length || visited[i][j] || node.children[board[i][j]-'a'] == null) return;
        visited[i][j] = true;
        node = node.children[board[i][j]-'a'];

        if (node.isWord) {
            res.add(word+board[i][j]);
        }

        dfs(board, i-1, j, node, word+board[i][j], visited);
        dfs(board, i+1, j, node, word+board[i][j], visited);
        dfs(board, i, j-1, node, word+board[i][j], visited);
        dfs(board, i, j+1, node, word+board[i][j], visited);


        visited[i][j] = false;



    }

    private void buildTrie(String[] words) {
        for (String word: words) {
            TrieNode node = root;
            for (int i = 0; i < word.length();i++){
                char c = word.charAt(i);
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new TrieNode();
                }

                node  = node.children[c-'a'];
            }

            node.isWord = true;
        }
    }


}
