public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int count = 0;
        while(n>0) {
            count += n/5;
            n = n/5;
        }
        return count;

    }
}
