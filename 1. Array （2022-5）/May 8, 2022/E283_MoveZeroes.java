import java.lang.reflect.Array;
import java.util.Arrays;

public class E283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int l = 0;
        int r = 0;
        int check = 0;

        while (l + r < nums.length) {
            for (int i = l; i < nums.length - r; ++i) {
                if (nums[i] == 0) {
                    l = i;
                    check = 1;
                    break;
                }
            }
            if (check == 1 ){
                for (int i = l; i < nums.length - r - 1; ++i) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = 0;
                }
                r++;
                check = 0;
            } else {
                break;
            }
        }
    }

    //Better: 两次遍历
    public void moveZeroes2 (int[] nums) {
            int i = 0;
            int j = 0;
            while (j < nums.length) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    j++;
                    i++;
                } else {
                    j++;
                }
            }
            for (int k = i; k < nums.length; k++) {
                nums[k] = 0;
            }
    }

    public static void main(String[] args) {
        E283_MoveZeroes temp = new E283_MoveZeroes();
        int[] nums = {0,1,0,3,12};
        temp.moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
