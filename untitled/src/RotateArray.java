public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int j = 0; j < nums.length; j++) {
            nums[(j + k) % nums.length] = temp[j];
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }
}