public class ClimbingStairs_70 {
    public int climbStairs(int n) {


        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 1; i<=n; i++){
            sum = a+b;
            a = b; 
            b= sum;
            
        }
        return sum;
    }
        
}
