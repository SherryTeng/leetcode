public class FindtheHighestAltitude_1732 {
    public int largestAltitude(int[] gain) {

        int[] altitude = new int[gain.length];
        altitude[0] = gain[0];

        for (int i = 1; i < gain.length;i++) {
            altitude[i] = altitude[i-1]+ gain[i];
        }

        int res = 0;
        for (int num: altitude) {
            res = Math.max(num, res);
        }

        return res;

    }
}
