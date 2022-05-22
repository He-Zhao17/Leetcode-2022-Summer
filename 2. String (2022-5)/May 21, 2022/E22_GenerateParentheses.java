import java.lang.reflect.Array;
import java.util.*;

public class E22_GenerateParentheses {
    //我的答案 很慢很占内存 ---ps 其实是最快的orz
    HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            if (!map.containsKey(n)) {
                map.put(n, res);
            }
            return res;
        }
        if (n == 1) {
            res.add("()");
            if (!map.containsKey(n)) {
                map.put(n, res);
            }
            return res;
        }


        Set<String> set = new HashSet<>();
        for (int i = 0; i <= n - 1; i++) {
            int in = n - 1 - i;
            int out = n - 1 - in;
            List<String> resIn = map.containsKey(in) ? map.get(in) : generateParenthesis(in);
            List<String> resOut = map.containsKey(out) ? map.get(out) : generateParenthesis(out);

            for (int p = 0; p < resIn.size(); p++) {
                for (int q = 0; q < resOut.size(); q++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(resIn.get(p));
                    sb.append(")");
                    String inAll = sb.toString();
                    sb.append(resOut.get(q));
                    set.add(sb.toString());
                    sb = new StringBuilder();
                    sb.append(resOut.get(q));
                    sb.append(inAll);
                    set.add(sb.toString());
                }
            }
        }
        res.addAll(set);
        if (!map.containsKey(n)) {
            map.put(n, res);
        }
        return res;
    }

    public List<String> generateParenthesis2(int n) {
        LinkedList<List<String>> help = new LinkedList<>();
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        temp.add("");
        if (n == 0) {
            return temp;
        }
        help.add(temp);
        temp = new ArrayList<>();
        temp.add("()");
        if (n == 1) {
            return temp;
        }
        help.add(temp);

        for (int k = 2; k <= n; k++) {
            ArrayList<String> temp1 = new ArrayList<>();
            for (int i = 0; i <= k - 1; ++i) {
                List<String> in = help.get(i);
                List<String> out = help.get(k - 1 - i);
                for (String str : in) {
                    for (String str2 : out) {
                        temp1.add("(" + str + ")" + str2);
                    }
                }
            }
            help.add(temp1);
        }


        return help.get(n);



    }




    public static void main(String[] args) {
        int n = 2;
        E22_GenerateParentheses temp = new E22_GenerateParentheses();
        List<String> res = temp.generateParenthesis(n);
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
    }
}
