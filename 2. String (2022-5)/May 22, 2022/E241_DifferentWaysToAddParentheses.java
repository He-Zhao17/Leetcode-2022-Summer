import java.util.*;

public class E241_DifferentWaysToAddParentheses {
    //我的答案 能算出所有答案 但是去重太麻烦了 放弃
    class express {
        int[] numbers;
        char[] operators;

        public express(int[] ex, char[] op) {
            this.numbers = ex;
            this.operators = op;
        }
    }
    public List<Integer> diffWaysToCompute(String expression) {
        Set<Integer> set = new HashSet<>();

        String[] arr = expression.split("\\+|\\-|\\*");
        int[] numbers = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            numbers[i] = Integer.parseInt(arr[i]);
        }
        char[] operators = new char[arr.length - 1];
        int point = 0;
        for (int i = 0; i < expression.length(); ++i) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                operators[point] = ch;
                point++;
            }
        }
        ArrayList<express> arr1 = new ArrayList<>();
        arr1.add(new express(numbers, operators));
        ArrayList<express> arr2 = new ArrayList<>();
        while (arr1.get(0).numbers.length > 1) {
            arr2 = new ArrayList<>();
            for (express ex : arr1) {
                for (int i = 0; i < ex.numbers.length - 1; ++i) {
                    arr2.add(shortExpression(ex, i));
                }
            }
            arr1 = arr2;
        }

        List<Integer> res = new ArrayList<>();
        for (express ex : arr1) {
            res.add(ex.numbers[0]);
        }
        return res;
    }
    private express shortExpression (express ex, int l) {
        int[] numbers1 = new int[ex.numbers.length - 1];
        char[] operators1 = new char[ex.operators.length - 1];
        for (int i = 0; i < l; ++i) {
            numbers1[i] = ex.numbers[i];
            if (i < operators1.length) {
                operators1[i] = ex.operators[i];
            }
        }
        int res = 0;
        switch (ex.operators[l]) {
            case '+' :
                res = ex.numbers[l] + ex.numbers[l + 1];
                break;
            case '-' :
                res = ex.numbers[l] - ex.numbers[l + 1];
                break;
            case '*' :
                res = ex.numbers[l] * ex.numbers[l + 1];
                break;
        }
        numbers1[l] = res;
        if (l + 1 < ex.numbers.length) {
            for (int i = l + 2; i < ex.numbers.length; ++i) {
                numbers1[i - 1] = ex.numbers[i];
                operators1[i - 2] = ex.operators[i - 1];
            }
        }
        return new express(numbers1, operators1);
    }



    //自己实现一下答案中的分治法
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute2(String expression) {
        if (map.containsKey(expression)){
            return map.get(expression);
        }

        List<Integer> res = new ArrayList<>();


        //corner case
        if (expression.length() == 0) {
            return new ArrayList<Integer>();
        }

        //corner case
        int num = 0;
        int index = 0;
        while (index < expression.length() && !isOp(expression.charAt(index))) {
            num = num * 10 + expression.charAt(index) - '0';
            index++;
        }

        //corner case
        if (index == expression.length()) {
            res.add(num);
            map.put(expression, res);
            return res;
        }


        for (int i = 0; i < expression.length(); ++i) {
            if (isOp(expression.charAt(i))) {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                char op = expression.charAt(i);

                List<Integer> resL = diffWaysToCompute2(left);
                List<Integer> resR = diffWaysToCompute2(right);

                for (int p = 0; p < resL.size(); ++p) {
                    for (int q = 0; q < resR.size(); ++q) {
                        res.add(cal(resL.get(p), op, resR.get(q)));
                    }
                }
            }
        }
        map.put(expression, res);
        return res;
    }

    private int cal (int num1 , char op, int num2) {
        switch (op) {
            case '-' :
                return num1 - num2;
            case '+' :
                return num1 + num2;
            case '*' :
                return num1 * num2;
        }
        return 0;
    }
    private boolean isOp(char ch) {
        if (ch == '+' || ch == '-' || ch == '*'){
            return true;
        } else {
            return false;
        }
    }




    public static void main(String[] args) {
        String test = "2-1-1";
        E241_DifferentWaysToAddParentheses temp = new E241_DifferentWaysToAddParentheses();
        temp.diffWaysToCompute2(test);
    }



}
