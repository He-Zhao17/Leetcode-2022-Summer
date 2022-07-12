import javax.swing.plaf.IconUIResource;

/**
 * <p></p>
 * <p></p>
 *
 * @author: He Zhao
 * @create: 2022-07-12 18:52
 */
public class E201_BitwiseANDofNUmbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        int res = left ^ right;
        int num0 = 0;
        for (int i = 31; i >=0; --i) {
            if (res >> i == 1) {
                break;
            } else {
                num0++;
            }
        }
        num0 = 31 - num0;
        return (left >> num0) <<num0;


    }
}
