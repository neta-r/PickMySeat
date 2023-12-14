import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int maxNum = Integer.MAX_VALUE;
        int maxTimesAppeared = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxTimesAppeared) {
                maxNum = entry.getKey();
                maxTimesAppeared=entry.getValue();
            }
        }
        return maxNum;
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        majorityElement(nums);
    }
}