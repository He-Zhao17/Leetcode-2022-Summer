import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class E316_RemoveDuplicateLetters {

    //看了答案
    /*遍历字符串元素并维护一个栈
            当准备入栈的元素比栈顶大的时候顺利压入
    当准备压入栈的元素比栈顶小的时候将栈顶元素弹出直至满足比栈顶元素大
    当准备弹出栈的元素在后续的字符串遍历中无法再出现(该元素的最后一个幸存者)则拒绝弹出，元素压入，遍历继续
    对被压入的元素做记录，在后续遍历中若该元素已经压入过了，则跳过
            具体请见代码块

    作者：richard-az
    链接：https://leetcode.cn/problems/remove-duplicate-letters/solution/by-richard-az-5xmv/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }

    //自己实现一遍
    public String removeDuplicateLetters2(String s) {
        int[] letters = new int[26];
        //Stack<Character> sta = new Stack<>();
        //这里可以直接使用String作为栈
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            letters[ch - 'a']++;
        }
        Set<Character> cc = new HashSet<>();

        outer1:
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (cc.contains(ch)) {
                letters[ch - 'a']--;
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                if (letters[sb.charAt(sb.length() - 1) - 'a'] == 0) {
                    sb.append(ch);
                    cc.add(ch);
                    letters[ch - 'a']--;
                    continue outer1;
                } else {
                    char temp = sb.charAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    cc.remove(temp);
                }
            }
            if (sb.length() == 0 ||
                    (sb.length() > 0 && sb.charAt(sb.length() - 1) < ch)) {
                sb.append(ch);
                cc.add(ch);
                letters[ch - 'a']--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        E316_RemoveDuplicateLetters temp = new E316_RemoveDuplicateLetters();
        String res = temp.removeDuplicateLetters2("cbacdcbc");
    }


}
