public class E7_ReverseInteger {

    //2^31 = 2147483648
    public int reverse(int x) {
        String temp = String.valueOf(x);
        // nega == 0 posi == 1;
        int isNega = 1;

        if (temp.charAt(0) == '-') {
            temp = temp.substring(1);
            isNega = 0;
        }
        int[] border = {2,1,4,7,4,8,3,6,4,8 - isNega};

        if (temp.length() < 10) {
            String temp2 = new StringBuilder(temp).reverse().toString();
            return isNega == 1 ? Integer.parseInt(temp2) : -1 *Integer.parseInt(temp2);
        } else {
            char[] arr = temp.toCharArray();
            for (int i = 0; i < 10; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(arr[arr.length - 1 - i]);
                String tt = sb.toString();
                int digit = Integer.parseInt(tt);
                if (digit > border[i]) {
                    return 0;
                } else if (digit < border[i]) {
                    String temp2 = new StringBuilder(temp).reverse().toString();
                    return isNega == 1 ? Integer.parseInt(temp2) : -1 *Integer.parseInt(temp2);
                }
            }
            String temp2 = new StringBuilder(temp).reverse().toString();
            return isNega == 1 ? Integer.parseInt(temp2) : -1 *Integer.parseInt(temp2);
        }
    }

    public static void main(String[] args) {
        int test = 1534236469;
        E7_ReverseInteger temp = new E7_ReverseInteger();
        int res = temp.reverse(test);
        System.out.println(res);
    }


}
