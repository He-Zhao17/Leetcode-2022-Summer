import java.util.ArrayList;
import java.util.Arrays;

public class E34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> set = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int curr = 0;
        int[] sho, lon;
        if (nums1.length >= nums2.length) {
            sho = nums2;
            lon = nums1;
        } else {
            sho = nums1;
            lon = nums2;
        }
        while (curr < sho.length) {
            int p = sho[curr];
            int l = 0;
            int r = lon.length - 1;
            int b = -1;
            int f = 0;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int m = lon[mid];
                if (m == p) {
                    int temp = mid - 1;
                    while (temp >= l) {
                        if (lon[temp] != m) {
                            break;
                        }
                        temp--;
                    }
                    b = temp + 1;
                    temp = mid + 1;
                    while (temp <= r) {
                        if (lon[temp] != m) {
                            break;
                        }
                        temp++;
                    }
                    f = temp - 1;
                    break;
                } else if (m > p) {
                    r = mid;
                } else {
                    l = mid + 1;

                }
            }
            int end = curr + 1;
            while (end <= sho.length  - 1) {
                if (sho[end] != p) {
                    break;
                }
                end++;
            }
            if (b == -1) {
                if (lon[l] == p) {
                    set.add(p);
                }
            } else {
                int numLon = f - b + 1;
                int numSho = end - curr;
                int min = Math.min(numLon, numSho);
                for (int i = 0; i < min; ++i) {
                    set.add(p);
                }
            }
            curr = end;
        }
        int[] ans = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            ans[i] = set.get(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        E34_FindFirstAndLastPositionOfElementInSortedArray temp  = new E34_FindFirstAndLastPositionOfElementInSortedArray();
        temp.intersect(new int[] {1,2,2,1}, new int[]{2,2});
    }

}
