import java.util.Scanner;

public class GM_OA_binarySum {
    /*
    write a java program that, given two binary numbers represented as strings, prints their sum in binary.
    The binary strings are comma separated, two per line. The final answer should not have any leading zeros.
    In case the answer is zero, just print one zero i.e. 0
    Input: Your program should read lines from standard input. Each line contains two binary strings, separated by a comma and no spaces.
    Output: For each pair of binary numbers print to standard output their binary sum, one per line.
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numbers = line.split(",");

            if (numbers.length != 2) {
                System.err.println("Invalid input format");
                continue;
            }

            String binary1 = numbers[0];
            String binary2 = numbers[1];

            String sumBinary = addBinaryStrings(binary1, binary2);
            System.out.println(sumBinary);
        }
    }

    public static String addBinaryStrings(String a, String b) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        return result.toString();
    }
}


