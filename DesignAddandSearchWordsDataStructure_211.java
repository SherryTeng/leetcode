public class DesignAddandSearchWordsDataStructure_211 {

    private DesignAddandSearchWordsDataStructure_211[] children;
    boolean isEnd;

    public DesignAddandSearchWordsDataStructure_211() {
        children = new DesignAddandSearchWordsDataStructure_211[26];
        isEnd = false;

    }

    public void addWord(String word) {
        DesignAddandSearchWordsDataStructure_211 curr = this;

        for (char c: word.toCharArray()) {
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new DesignAddandSearchWordsDataStructure_211();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd =true;

    }

    public boolean search(String word) {
        DesignAddandSearchWordsDataStructure_211 curr = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (DesignAddandSearchWordsDataStructure_211 child: curr.children) {
                    if (child!=null && search(word.substring(i+1))) {
                        return true;
                    }
                    return false;
                }

            }

            if (curr.children[c-'a'] == null) return false;
            curr =curr.children[c-'a'];
        }

        return curr != null && curr.isEnd;

    }
}
