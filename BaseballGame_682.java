import java.util.*;
public class BaseballGame_682 {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String s: operations) {
            if (s.equals("+") ){

                int first = stack.pop();
                int second = stack.peek();

                int sum = first + second;

                stack.add(first);
                stack.add(sum);

            }else if (s.equals("D")){

                int num = stack.peek();

                int d = 2* num;

                stack.add(d);
            }else if (s.equals("C")) {
                stack.pop();
            }else{

                try{
                    stack.add(Integer.parseInt(s));

                }catch(NumberFormatException e){
                    System.out.println("Invalid integer input");

                }


            }
        }

        if (stack.isEmpty()) return 0;

        int res = 0;


        while (!stack.isEmpty()){
            res+= stack.pop();

        }

        return res;


    }


}
