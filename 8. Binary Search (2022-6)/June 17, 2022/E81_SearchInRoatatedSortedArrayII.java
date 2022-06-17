import com.sun.jdi.connect.Connector;

public class E81_SearchInRoatatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        outer1:
        while (l < r) {
            int mid = l + (r - l) / 2;
            int m = nums[mid];
            if (nums[l] == nums[r]) {
                if (m == nums[l]) {
                    if (m == target) {
                        return true;
                    } else {
                        l = l + 1;
                        r = r - 1;
                    }
                } else {
                    if (m == target) {
                        return true;
                    } else {
                        if (m > target) {
                            if (m > nums[l]) {
                                if (target > nums[l]) {
                                    r = mid;
                                } else if (target == nums[l]) {
                                    return true;
                                } else {
                                    l = mid + 1;
                                }
                            } else {
                                r = mid;
                            }
                        } else {
                            if (m > nums[r]) {
                                l = mid + 1;
                            } else {
                                if (target > nums[r]) {
                                    r = mid;
                                } else if (target == nums[r]) {
                                    return true;
                                } else {
                                    l = mid + 1;
                                }
                            }
                        }
                    }
                }
            } else if (nums[l] > nums[r]) {
                if (target == m) {
                    return true;
                } else if (target > m) {
                    if (m == nums[r]) {
                        r = mid;
                    } else if (m < nums[r]) {
                        if (target == nums[r]) {
                            return true;
                        } else if (target > nums[r]) {
                            r = mid;
                        } else {
                            l = mid + 1;
                        }
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (m == nums[l]) {
                        l = mid + 1;
                    } else if (m < nums[l]) {
                        r = mid;
                    } else {
                        if (target == nums[l]) {
                            return true;
                        } else if (target < nums[l]) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                }

            } else {
                if (m == target) {
                    return true;
                } else if (m < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        if (l < 0 || l >= len) {
            return false;
        }
        if (nums[l] == target) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        E81_SearchInRoatatedSortedArrayII temp = new E81_SearchInRoatatedSortedArrayII();
        temp.search(new int[] {1, 3, 5}, 1);
    }

}
