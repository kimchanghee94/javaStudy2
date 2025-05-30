package InsertDeleteGetRandom;

import java.util.*;

public class Solution {
    List<Integer> arr = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public Solution() {

    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            arr.add(val);
            map.put(val, arr.size()-1);

            return true;
        }else{
            return false;
        }
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int dIdx = map.get(val);
            int lVal = arr.get(arr.size()-1);

            arr.set(dIdx, lVal);
            map.put(lVal, dIdx);

            arr.remove(arr.size()-1);
            map.remove(val);

            return true;
        }
    }

    public int getRandom() {
        int ran = (int)(Math.random()*arr.size());
        return arr.get(ran);
    }
}
