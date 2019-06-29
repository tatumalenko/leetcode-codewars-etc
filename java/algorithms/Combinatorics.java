/**
 * Combinatorics
 */
public class Combinatorics {
    public static void main(String[] args) {
        System.out.println(count(4)); // 6
        System.out.println(count(10)); // 9496
        System.out.println(combinations(4, 2)); // 6
        System.out.println(combinations(10, 2)); // 45
        System.out.println(combinations(10000, 2)); // 49995000
        System.out.println(permutations(4, 2)); // 12
        System.out.println(permutations(10, 4)); // 5040
        System.out.println(permutations(1000, 2)); // 999000
    }

    /**
     * 
     * @param n
     * @return
     * 
     * @see <a href=
     *      "https://www.geeksforgeeks.org/counting-pairs-person-can-form-pair-one/">Link</a>
     * 
     */
    static int count(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];

        return dp[n];
    }

    /**
     * 
     * @param n
     * @param k
     * @return
     * 
     * @see <a href=
     *      "https://stackoverflow.com/questions/11809502/which-is-better-way-to-calculate-ncr">Link</a>
     */
    static long combinations(int n, int k) {
        long ans = 1;
        k = k > n - k ? n - k : k;
        for (int j = 1; j <= k; j++, n--) {
            if (n % j == 0) {
                ans *= n / j;
            } else if (ans % j == 0) {
                ans = ans / j * n;
            } else {
                ans = (ans * n) / j;
            }
        }
        return ans;
    }

    /**
     * 
     * @param n
     * @param k
     * @return
     * 
     * @see <a href=
     *      "https://stackoverflow.com/questions/11809502/which-is-better-way-to-calculate-ncr">Link</a>
     */
    static long permutations(int n, int k) {
        long ans = 1;
        k = k > n - k ? n - k : k;
        for (int j = 1; j <= k; j++, n--) {
            if (n % j == 0) {
                ans *= n / j;
            } else if (ans % j == 0) {
                ans = ans * n; // Only this changed (removed / j)
            } else {
                ans = (ans * n) / j;
            }
        }
        return ans;
    }

}