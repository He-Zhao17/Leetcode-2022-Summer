public class E278_FirstBadVersion {
    /*public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean is = isBadVersion(mid);
            if (!is) {
                if (mid == l ){
                    return l;
                } else {
                    r = mid - 1;
                }

            } else {
                l = mid + 1;
            }
        }
        if (isBadVersion(l)) {
            return l + 1;
        } else {
            return l;
        }

    }*/

}
