

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
public class E374_GuessNumberHigherOrLower extends GuessGame{
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        if (n == 1); {
            return 1;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;

    }

}
