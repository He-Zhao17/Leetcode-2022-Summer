import java.util.*;

public class E336_PalindromePairs {
    //莫名其妙总会hash碰撞 反正领会精神好吧
    //https://leetcode.cn/problems/palindrome-pairs/solution/zi-fu-chuan-ha-xi-yi-dian-dian-hui-wen-z-0wqj/
    //上述答案先把所有的hash值记录在hashmap里 遍历每个string 一个个字母计算hash值 寻找hashmap里是否有前缀/后缀 再比较多余的部分
    //我的代码不一样 很奇怪 但是领会精神好吧 这样不是常用解。
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int base = 29;
        long mod = 1000000007;
        for (int i = 0; i < words.length; ++i) {
            int currL = words[i].length();

            for (int j = 0; j < words.length; ++j) {

                if (i == j) {
                    continue;
                }
                int compL = words[j].length();
                String rest = "";
                String comp = "";
                String curr = "";
                if (currL > compL) {
                    curr = compL == 0 ? "" : words[i].substring(0, compL);
                    rest = compL == 0 ? words[i] : words[i].substring(compL);
                    comp = new StringBuilder(words[j]).reverse().toString();
                } else if (currL < compL) {
                    curr = words[i];
                    rest = currL == 0 ? words[j] : words[j].substring(0, compL - currL);
                    comp = currL == 0 ? "" : new StringBuilder(words[j].substring(words[j].length() - currL)).reverse().toString();
                } else {
                    curr = words[i];
                    comp = new StringBuilder(words[j]).reverse().toString();
                }
                long hash = 0;
                for (int k = 0; k < curr.length(); ++k) {
                    hash = (hash * base + (curr.charAt(k) - 'a' + 1)) % mod;
                }


                long compHash = 0;
                for (int k = 0; k < comp.length(); ++k) {
                    compHash = (compHash * base + (comp.charAt(k) - 'a' + 1)) % mod;
                }

                if (hash == compHash) {
                    long restHash = 0;
                    String currReverse = new StringBuilder(rest).reverse().toString();
                    for (int k = 0; k < rest.length(); ++k) {
                        restHash = (restHash * base + (rest.charAt(k) - 'a' + 1)) % mod;
                    }
                    long restReverseHash = 0;
                    for (int k = 0; k < rest.length(); ++k) {
                        restReverseHash = (restReverseHash * base + (currReverse.charAt(k) - 'a' + 1)) % mod;
                    }
                    if (restHash == restReverseHash) {
                        List<Integer> kk = new ArrayList<>();
                        kk.add(i);
                        kk.add(j);
                        res.add(kk);
                    }
                }
            }
        }
        return res;


    }

    public static void main(String[] args) {
        String[] test = {"abcd","dcba","lls","s","sssll"};
        E336_PalindromePairs temp = new E336_PalindromePairs();
        temp.palindromePairs(test);
    }

    class Node {
        int[] ch = new int[26];
        int flag;

        public Node() {
            flag = -1;
        }
    }

    //答案：字典树记录 还可以用Hashmap
    //https://leetcode.cn/problems/palindrome-pairs/solution/hui-wen-dui-by-leetcode-solution/
    List<Node> tree = new ArrayList<Node>();

    public List<List<Integer>> palindromePairs2(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(words[i], j, m - 1)) {
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }




}
