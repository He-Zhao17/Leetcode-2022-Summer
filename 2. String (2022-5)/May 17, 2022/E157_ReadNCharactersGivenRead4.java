import java.util.Arrays;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */
public class E157_ReadNCharactersGivenRead4 extends Reader4{

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        int re = 4;
        char[] buf4 = new char[4];

        while (index < n && re != 0) {
            re = read4(buf4);
            for (int i = 0; i < re && index < n; ++i) {
                buf[index] = buf4[i];
                index++;
            }
        }
        return index;

    }
}
