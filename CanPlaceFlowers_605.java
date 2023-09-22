public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0;

        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i ==flowerbed.length-1 ||flowerbed[i+1] == 0)  && (i < 1|| flowerbed[i-1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
            i++;
        }

        return n<=0;

    }
}
