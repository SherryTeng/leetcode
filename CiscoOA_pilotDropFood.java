import java.util.*;

public class CiscoOA_pilotDropFood {

    /*
    A pilot was asked to drop food packets in a terrain. He must fly over the entire terrain only once but cover a maximum number of drop points. The points are given as inputs in the form of integer co-ordinates in a two dimensional field. The flight path can be horizontal or vertical, but not a mix of the two or diagonal. write a Java algorithm to find the maximum number of drop points that can be covered by flying over the terrain once.
Input: The first line of input consists of an integer- xCoordinate_size, representing the number of x coordinates(N). The next line consists of N space-separated integers representing the x coordinates. The third line consists of an integer-yCoordinate_size, representing the number of y coordinates(M). The next line consists of M space-separated integers representing the y coordinates.
 Output: Print an integer representing the number of coordinates in the best path which covers the maximum number of drop points by flying over the terrain once.
Note: A path is valid path, if, more than one drop points are connected (Single coordinate don't create any path, so pilot cannot fly over it). Constraints: 1< N, M <=700 (where N is always equal to M)
Example:
Input:
5
2 3 2 4 2
5
2 2 6 5 8
output:
3

Explanation: There are 5 coordinates (2,2), (3,2), (2,6), (4,5), (2,8). The best path is the horizontal one covering (2,2), (2,6) and (2,8). So the output is 3.
     */

    public static int findMaximumDropPoints(int[] xCoordinates, int[] yCoordinates){

        Map<Integer, Integer> frequencyMapX = new HashMap<>();

        for (int num : xCoordinates) {
            frequencyMapX.put(num, frequencyMapX.getOrDefault(num, 0) + 1);
        }

        int maxFrequencyX = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMapX.entrySet()) {
            if (entry.getValue() > maxFrequencyX) {
                maxFrequencyX = entry.getValue();
            }
        }

        Map<Integer, Integer> frequencyMapY = new HashMap<>();

        for (int num : yCoordinates) {
            frequencyMapY.put(num, frequencyMapY.getOrDefault(num, 0) + 1);
        }

        int maxFrequencyY = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMapY.entrySet()) {
            if (entry.getValue() > maxFrequencyY) {
                maxFrequencyY = entry.getValue();
            }
        }

        if (maxFrequencyX > maxFrequencyY) return maxFrequencyX;
        return maxFrequencyY;
    }

    public static void main(String[] args) {
        int[] xCoordinates = {2, 3, 2, 4, 2, 5,6};
        int[] yCoordinates = {2, 2, 6, 5, 8,2,2};
        int maxDropPoints = findMaximumDropPoints(xCoordinates, yCoordinates);
        System.out.println(maxDropPoints);
    }
}
