//import java.util.*;
//public class TimeBasedKeyValueStore_981 {
//    Map<String, TreeMap<Integer, String>> map;
//    public TimeMap() {
//
//        map = new HashMap<>();
//    }
//
//    public void set(String key, String value, int timestamp) {
//        if (map.get(key) == null) {
//            TreeMap treemap = new TreeMap();
//            map.put(key, treemap);
//        }
//        map.get(key).put(timestamp, value);
//
//    }
//
//    public String get(String key, int timestamp) {
//        TreeMap<Integer, String> treeMap = map.get(key);
//        if (treeMap == null) return "";
//
//        Integer floor = treeMap.floorKey(timestamp);
//        if (floor == null) return "";
//
//        return treeMap.get(floor);
//
//    }
//}
