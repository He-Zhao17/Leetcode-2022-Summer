import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-05-18 15:39
 */
public class E68_TextJustfication {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int next = 0;
        while (next < words.length) {
            int nums = 0;
            int len = 0;
            ArrayList<String> kk = new ArrayList<String>();;
            len += words[next].length();
            kk.add(words[next]);
            next++;
            nums++;
            while (len < maxWidth && next < words.length) {
                kk.add(words[next]);
                len += (words[next].length() + 1);
                nums++;
                next++;
            }
            if (len < maxWidth) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < nums; k++) {
                    if (k > 0) {
                        sb.append(" ");
                    }
                    sb.append(kk.get(k));
                }
                for (int i = 0; i < maxWidth - len; ++i) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                return res;
            } else if (len == maxWidth) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < nums; k++) {
                    if (k > 0) {
                        sb.append(" ");
                    }
                    sb.append(kk.get(k));
                }
                res.add(sb.toString());
                if (next == words.length) {
                    return res;
                }
            } else {
                kk.remove(nums - 1);
                len--;
                len -= words[next - 1].length();
                nums--;
                next--;
                if (nums == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(kk.get(0));
                    for (int i = 0; i < maxWidth - kk.get(0).length(); ++i) {
                        sb.append(" ");
                    }
                    res.add(sb.toString());
                } else {
                    int numSpace = maxWidth - len;
                    int p = numSpace / (nums - 1);
                    int q;
                    if (p == 0) {
                        q = numSpace;
                    } else {
                        q = numSpace % (nums - 1);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < nums; k++) {
                        if (k > 0) {
                            if (k <= q) {
                                for (int i = 0; i < p + 2; ++i) {
                                    sb.append(" ");
                                }
                            } else if (k < nums) {
                                for (int i = 0; i < p + 1; ++i) {
                                    sb.append(" ");
                                }
                            }
                        }
                        sb.append(kk.get(k));
                    }
                    res.add(sb.toString());
                }

            }
        }
        return res;

    }

    public static void main(String[] args) {
        E68_TextJustfication temp = new E68_TextJustfication();
        String[] kk = {"The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."};
        List<String> res = temp.fullJustify(kk, 17);
    }
}