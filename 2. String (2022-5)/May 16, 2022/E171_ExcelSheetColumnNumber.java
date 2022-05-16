public class E171_ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        char[] arr = columnTitle.toCharArray();
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            res += (arr[i] - 'A' + 1) * Math.pow(26, arr.length - 1 - i);
        }
        return res;

    }
}
