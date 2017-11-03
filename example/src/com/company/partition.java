package com.company;

/**
 * Created by rvenkatesh on 10/13/17.
 */
public class partition {

    public static void main(String[] args) {
        int arr[] =  {1,5, 6, 8, 2};
        System.out.println(isSubsetSum(arr, 19));
    }

    static boolean isSubsetSum(int set[], int sum)
    {
        int n = set.length;
        // The value of subset[i][j] will be true if there
        // is a subset of set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1])
                    subset[i][j] = subset[i][j] ||
                            subset[i - set[j-1]][j-1];
            }
        }

        /* // uncomment this code to print table
         for (int i = 0; i <= sum; i++)
         {
           for (int j = 0; j <= n; j++)
              printf ("%4d", subset[i][j]);
           printf("n");
         } */

        return subset[sum][n];
    }
}
