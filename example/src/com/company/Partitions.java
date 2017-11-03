package com.company;

public class Partitions {

    public static void main(String[] args) {
        int digits[] = {700000,20000,30000,200000,70000};
        int num[] = {1, 3, 4};
        long count;

        for(int k = 0 ; k < digits.length; k++) {
            long a[] = new long[digits[k]+1];
            a[0]=1;
            for (int i = 1; i <= digits[k]; i++) {
                count = 0;
                for (int j = 0; j < num.length; j++) {
                    if (i >= num[j]) {
                        count += a[i - num[j]];
                    }
                }
                a[i] = count;
            }
            System.out.println(digits[k]+" ==> "+a[digits[k]]);
        }

    }


}

