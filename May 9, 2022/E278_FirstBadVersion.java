public class E278_FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n <= 1) {
            return n;
        }

        int l = 1;
        int r = n;
        int mid;
        while (l < r) {
            //此处不能用 !!!!!!!!!!!!!!!!!!!!!!!!!
            //mid = (l + r) / 2;
            //会溢出 因为l & r很大
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
