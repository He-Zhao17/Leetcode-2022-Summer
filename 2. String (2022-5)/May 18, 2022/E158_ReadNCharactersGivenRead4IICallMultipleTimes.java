public class E158_ReadNCharactersGivenRead4IICallMultipleTimes {
    char[] buf4 = new char[4];
    int j = 0;
    int re = 0;
    int ans = read4(buf4);

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    //我的解法 稍微麻烦
    public int read(char[] buf, int n) {
        int index = 0;
        if (j > 0 && j < re) {
            int k = re - j;
            for (int i = 0; i < k && index < n; ++i) {
                buf[index] = buf4[j];
                j++;
                index++;
            }
        }
        if (index == n) {
            return index;
        }

        re = read4(buf4);
        j = 0;
        while (re != 0 && index < n) {
            for (int i = 0; i < re && index < n; ++i) {
                buf[index] = buf4[i];
                j++;
                index++;
            }
            if (index < n) {
                re = read4(buf4);
                j = 0
            }
        }

        return index;

    }

    //Answer:
    public int read2(char[] buf, int n) {
        int i = 0;
        while(i < n && ans > 0) {
            while(i < n && j < ans) {
                buf[i++] = buf4[j++];
            }
            //如果buf4数据读完了就再从文件中读
            if(j == ans) {
                j = 0;
                ans = read4(buf4);
            }
        }
        return i;

    }


    }
