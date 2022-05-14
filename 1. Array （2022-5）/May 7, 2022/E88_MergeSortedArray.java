public class E88_MergeSortedArray {

    //所有玩家都全力向前冲刺, 却不知道向后才是胜利之门。-《头号玩家》
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        if (m == 0 && n != 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (m != 0 && n == 0) {
            return;
        }

        int m1 = m - 1;
        int n1 = n - 1;
        int count = 0;

        while (m1 >= 0 && n1 >= 0) {
            if (nums1[m1] >= nums2[n1]) {
                nums1[m + n - 1 - count] = nums1[m1];
                m1--;
                count++;
                continue;
            } else if (nums1[m1] < nums2[n1]) {
                nums1[m + n -1 - count] = nums2[n1];
                n1--;
                count++;
                continue;
            }
        }
        if (n1 >= 0) {
            for (int i = 0; i <= n1; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}
