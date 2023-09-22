public class SqrtX_69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1, right = x;
        while (left < right) {
            long mid  = left + (right-left)/2;
            if (mid * mid <=x && (mid+1)*(mid+1) > x) {
                return (int) mid;
            }else if (mid*mid > x) {
                right = mid;

            }else {
                left = mid+1;
            }

        }
        return (int)left;

    }
}
