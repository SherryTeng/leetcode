public class MajorityElements_169 {
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                major = nums[i];
            }

            if (nums[i] != major) {
                count--;
            }else count++;
        }

        return major;

//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0;
//
//        for (int num: nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//
//            }else {
//                map.put(num, map.get(num)+1);
//            }
//            if (map.get(num)> nums.length/2) {
//                res = num;
//                break;
//
//            }
//
//        }
//        return res;

    }
}
