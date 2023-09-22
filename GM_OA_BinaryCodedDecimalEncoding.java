import java.util.*;
public class GM_OA_BinaryCodedDecimalEncoding {
    /*
    Imagine that you are prototyping an electric device based on the Arduino platform and you are using a seven-segment display to show numeric values.
    To reduce the number of used digital outputs of the microcontroller, the display board is connected to the main board through the integrated circuit of the decoder, which converts
    binary coded decimal(BCD) values to signals for the seven-segment display.

    So, to show any number on the display you need to set the required BCD code on the microcontroller's output.

    Write a Java algorithm to convert an integer number represented as a string to a BCD code required for the display.

    In the BCD code, every decimal digit is encoded with its four-bit binary value.Encoding all digits of the decimal number and concatenating the resulting codes int one string you will get a resulting BCD code.
    A space is used to separated digits in the BCD code and make it more readable.

    For example, a number 173 will be encoded to BCD as 0001 0111 0011.

    Input: Each line has a string representing a non-negative integer number. For example:
    5
    17
    Output:
    Each line contains a BCD code of the number at the corresponding line of the input.
    Codes of decimal digits are separated from each other with a space. For example:
    0101
    0001 0111
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String bcdCode = convertToBCD(input);
            System.out.println(bcdCode);
        }
    }

    public static String convertToBCD(String input) {
        StringBuilder bcdCode = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            int intValue = Character.getNumericValue(digit);

            String binaryCode = Integer.toBinaryString(intValue);
            while (binaryCode.length() < 4) {
                binaryCode = "0" + binaryCode;
            }

            bcdCode.append(binaryCode).append(" ");
        }

        return bcdCode.toString().trim();
    }
}
