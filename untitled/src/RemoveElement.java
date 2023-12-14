public class RemoveElement {
    public static void removeElement(int[] nums, int val) {
        int k = 0;
        int numsOfVal=0;
        while (numsOfVal+k!=nums.length){
            if (nums[k] == val) {
                for (int j = k; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = val;
                numsOfVal++;

            } else {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 0, 3, 4, 2, 4};
        removeElement(nums, 4);
    }
}
