//public class PalindromeNumber_9 {
//    public boolean isPalindrome(int x) {
//        if (x < 0 || (x != 0 && x%10 == 0)) return false;
//
//        int reverse = 0;
//
//        while (x > reverse) {
//            reverse = reverse*10 +x%10;
//            x= x/10;
//        }
//
//        return x == reverse || x == reverse/10;
//
//
//
//        }
//
////        Method 2: o(n) space
//
////        String s = Integer.toString(x);
////
////        int i = 0;
////        int j = s.length()-1;
////
////        while (i <=j) {
////            if (s.charAt(i) != s.charAt(j)) {
////                return false;
////            }
////            i++;
////            j--;
////        }
////
////        return true;
//
//    }
//}
