package RobloxOA;

import java.util.*;

public class coloring {
    public static int[] paintNumberLine(int right, int[][] queries) {
        int size = queries.length;
        int[] res = new int[size];

        Set<Integer> uniqeColor = new HashSet<>();
        Map<Integer, Integer> coordToColor = new HashMap<>();

        for (int i =0; i < size; i++) {
            int[] query = queries[i];
            int coord = query[0];
            int color = query[1];

            if (coordToColor.containsKey(coord)) {
                int currColor = coordToColor.get(coord);
                uniqeColor.remove(currColor);
                uniqeColor.add(color);
                coordToColor.put(coord, color);
                res[i] = uniqeColor.size();

            }else {
                coordToColor.put(coord, color);
                if (!uniqeColor.contains(color)) {
                    uniqeColor.add(color);
                    res[i] = uniqeColor.size();

                }else{
                    res[i] = uniqeColor.size();

                }


            }


        }

        return res;


    }

    public static void main(String[] args) {
        int[][] quries = {
                {1,2},
                {3,5},
                {3,1},
                {3,2},
                {4,5},
                {6,1},
        };
        int[] res = paintNumberLine(8, quries);
        for (int i : res){
            System.out.println(i);
        }


    }

}
