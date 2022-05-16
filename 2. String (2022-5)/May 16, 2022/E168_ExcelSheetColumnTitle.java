public class E168_ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        int k =(int) Math.floor(Math.log(columnNumber) / Math.log(27)) ;
        StringBuffer sb = new StringBuffer();
        //引申自进制标准解法 从1开始就向左偏移
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();

    }

    public static void main(String[] args) {
        E168_ExcelSheetColumnTitle temp = new E168_ExcelSheetColumnTitle();
        temp.convertToTitle(701);
    }
}
