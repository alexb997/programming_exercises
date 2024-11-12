public class MinimumSpeed {
    static int findmax(int[] A)
    {
        int r = A[0];
        for(int i = 1; i < A.length; i++)
            r = Math.max(r, A[i]);
        return r;
    }
    static boolean isPossible(int[] A, int n,
                              int H, int K)
    {
        int time = 0;

        for (int i = 0; i < n; ++i)
            time += (A[i] - 1) / K + 1;

        return time <= H;
    }
    static int minJobSpeed(int[] A, int n, int H) {
        if (H < n)
            return -1;

        int max = findmax(A);
        int lo = 1, hi = max;
        while (lo < hi)
        {
            int mi = lo + (hi - lo) / 2;
            if (!isPossible(A, n, H, mi))
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }
    public static void main(String[] args)
    {
        int[] A = { 3, 6, 7, 11 };
        int H = 8;

        int n = A.length;
        System.out.println(minJobSpeed(A, n, H));
    }
}
