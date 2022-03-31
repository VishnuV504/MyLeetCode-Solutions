there are total 2^n subsequences in total
lets assume i th pointer is pointing at some character in 1st string
and jth pointer is pointing at some character in 2nd string
if they both are equal it will contribute to lcs but there is case what if both are not equal
i have two choices like 'ith pointer will wait and j will move further or j will wait and 'i' will move further why becuase either i or j will contribute or may not but one thing is for sure both will never contribute  because it is a subsequence. ex: ab  ba both will never contribute