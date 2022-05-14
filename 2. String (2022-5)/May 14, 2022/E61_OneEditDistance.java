public class E61_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            int key = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != t.charAt(i)) {
                    key++;
                    if (key > 1) {
                        return false;
                    }
                }
            }
            if (key == 1) {
                return true;
            } else {
                return false;
            }
        } else if (s.length() - t.length() == 1 || t.length() - s.length() == 1) {
            String lon;
            String sho;
            if (s.length() > t.length()) {
                lon = s;
                sho = t;
            } else {
                lon = t;
                sho = s;
            }
            int i = 0;
            int j = 0;
            boolean check = false;
            while (i < lon.length() && j < sho.length()) {
                if (lon.charAt(i) != sho.charAt(j)) {
                    if (!check) {
                        i++;
                        check = true;
                        continue;
                    } else {
                        return false;
                    }
                }
                i++;
                j++;
            }
            return true;
        } else {
            return false;
        }

    }

}
