public class ReverseString_344 {
    public void reverseString(char[] s) {

//        //iteration
//        for (int i =0; i < s.length/2; i++) {
//            char temp = s[i];
//            s[i] = s[s.length-1-i];
//            s[s.length-1-i] = temp;
//        }

        //recursion
        solve(s,0,s.length-1);
    }

    public void solve(char[]s, int i, int j) {
        if (i >= j) return;
        swap(s,i,j);
        i++;
        j--;
        solve(s, i, j);
    }

    public void swap(char[]s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


}
