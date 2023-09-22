import java.util.Arrays;

public class HIndex_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;

        Arrays.sort(citations);

        int res = 0;
        for (int i = n-1; i >=0; i--) {
            if (citations[i] > res) {
                res++;
            }else{
                break;
            }
        }
        return res;

    }
}
