import java.util.ArrayList;
import java.util.List;

public class E271_EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.size() == 0) {
            return sb.toString();
        }
        for (int i = 0; i < strs.size(); ++i) {
            sb.append(strs.get(i));
            sb.append((char) 258);
        }
        return sb.toString();



    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        //实际上使用split
        //retrun Arrays.asList(s.split(d, -1));
        if (s.length() == 0) {
            return res;
        }
        int l = 0;
        int r = 0;
        while (l <= r && r < s.length()) {
            if (s.charAt(r) == (char) 258) {

                StringBuilder sb = new StringBuilder();
                if (l == r) {
                    sb.append("");
                } else {
                    for (int i = l; i < r; i++) {
                        sb.append(s.charAt(i));
                    }
                }
                res.add(sb.toString());
                l = r + 1;
                r = l;
            } else {
                r++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        E271_EncodeAndDecodeStrings temp = new E271_EncodeAndDecodeStrings();
        List<String> strs = new ArrayList<>();
        strs.add("");
        strs.add("");
        String ss = temp.encode(strs);
        temp.decode(ss);
    }

}
