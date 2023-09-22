public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalSurplus = 0;
        for (int i =0; i < n; i++) {
            totalSurplus += gas[i] -cost[i];
        }
        if (totalSurplus < 0) return -1;

        int start = 0;
        int surplus = 0;
        for (int i =0; i < n; i++) {
            surplus += gas[i]-cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i+1;
            }
        }
        return start;
    }

    //gas = [7,1,0,11,4]
    //cost= [5,9,1,2,5]
}
