public class SatisfiabilityofEqualityEquations_990 {
    int[] parent = new int[26];
    private void uinon(int a, int b) {
        parent[find(a)] = find(b);
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) parent[i] = i;
        for (String string: equations) {
            if (string.charAt(1) == '=') uinon(string.charAt(0)-'a',string.charAt(3)-'a');
        }

        for(String string: equations) {
            if (string.charAt(1) == '!' && find(string.charAt(0)-'a') == find(string.charAt(3)-'a') ) return false;
        }

        return true;

    }
}
