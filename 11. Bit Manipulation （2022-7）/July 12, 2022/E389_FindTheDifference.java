/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-07-12 18:19
 */
public class E389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        int len = s.length();
        int sc = 0;
        int lc = 0;
        for (int i = 0; i < len; ++i) {
            sc += s.charAt(i) - 'a';
        }
        lc += sc + t.charAt(len) - 'a';
        sc = lc - sc;
        return (char) (sc + 'a');

    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        E389_FindTheDifference temp = new E389_FindTheDifference();
        temp.findTheDifference(s, t);
    }
}
