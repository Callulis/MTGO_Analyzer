import java.math.BigInteger;

public class Probability_Distributions
{
    public Probability_Distributions(){}

    static BigInteger binomial( int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

    static double hypergeometric_dist_equal_or_less(int N, int K, int n, int k)
    {
        double total_prob = 0.0;

        for(int i =0; i <= k; i++ )
            total_prob += hypergeometric_dist(N, K, n, i);

        return total_prob;

    }

    static double hypergeometric_dist_less(int N, int K, int n, int k)
    {
        double total_prob = 0.0;

        for(int i =0; i < k; i++ )
            total_prob += hypergeometric_dist(N, K, n, i);

        return total_prob;

    }

    static double hypergeometric_dist_at_least(int N, int K, int n, int k)
    {
        return 1.0 - hypergeometric_dist_less(N, K, n, k);
    }



    static double hypergeometric_dist(int N, int K, int n, int k)
    {
        double a = binomial(K,k).doubleValue();
        double b = binomial(N- K, n-k).doubleValue();
        double c = binomial(N,n).doubleValue();

        return (a * b) / c;
    }

    public static void main(String[] args)
    {
        System.out.println(hypergeometric_dist_at_least(60,4, 27, 1));

    }


}
