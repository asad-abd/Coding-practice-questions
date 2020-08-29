//easy, BUT DON'T FORGET 0!
class _263_UglyNumber {
    public boolean isUgly(int n) {
        if (n == 1)
            return true;

        while ((n % 2 == 0 || n % 3 == 0 || n % 5 == 0) && n != 0) {
            if (n % 2 == 0)
                n /= 2;
            if (n % 3 == 0)
                n /= 3;
            if (n % 5 == 0)
                n /= 5;
        }
        if (n == 1)
            return true;
        else
            return false;
    }
}