public class FibonacciNumber_509 {
    //recursively
//    public int fib(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        
//        return fib(n-1)+fib(n-2);
//    }

    //iteration
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i =2; i <= n; i++){
            sum = a+b;
            a = b;
            b= sum;
        }
        return sum;
    }


}


