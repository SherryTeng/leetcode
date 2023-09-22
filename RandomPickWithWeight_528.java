import java.util.Random;

public class RandomPickWithWeight_528 {
    Random random;
    int[] wSums;

    public RandomPickWithWeight_528(int[] w) {
        this.random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i-1];
        }
        this.wSums = w;

    }

    public int pickIndex() {
        int len = wSums.length;
        int index = random.nextInt(wSums[len-1])+1;

        int l = 0, r = len-1;

        while (l < r) {
            int mid =  l+(r-l)/2;
            if (wSums[mid] == index){
                return mid;
            }else if (wSums[mid] < index) {
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;

    }
}
