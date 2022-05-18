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
        int next = 0;
        while (next < words.length) {
            int len = 0;
            len += words[next].length();
            next++;
            while (len < maxWidth && next < words.length) {
                len += words[next].length() + 1;

            }



        }

    }
}
