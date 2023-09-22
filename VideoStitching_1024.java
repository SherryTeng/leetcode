import java.util.Arrays;

public class VideoStitching_1024 {
    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips, (a,b)-> {
            if (a[0]==b[0]) {
                return Integer.compare(b[1], a[1]);
            }
        return Integer.compare(a[0],b[0]);
        });

        if (clips[0][0] != 0) return -1;



        int currEnd = 0;
        int nextEnd = 0;
        int res = 0;
        int n = clips.length;
        int i =0;
        while (i < n && clips[i][0] <= currEnd) {
            while (i < n && clips[i][0] <= currEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            currEnd = nextEnd;
            res++;
            if (currEnd>=time) return res;
        }


        return -1;

    }
}
