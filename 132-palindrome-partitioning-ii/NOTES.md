consider a string aabcd
i can make a cut 1,2,3,4(upto end -1) index means  i will try every possibility and if and only if left substring is a palindrome i will do for right substring assume i made a cut at 1st index
string will become a | abcd  i will check the cut part is palindrome or not and again i will do for the right substring (recursively)  and whenever i cut i will track the number of cuts.
​
now assume  i made a cut at 2nd index it will become aa | bcd  since the cut part is a palindrome i will do for right substring and later bcd will divided into b | cd and again cd to c |d
until it hits the base case ? base the substring itself is a palindrome we dont need to make
any cuts .
​
now assume i made a cut at 3rd index it will become aab | cd since aab  is not a palindrome
it is not a intelligent cut we avoid that .
time complexity is O(N^3)  we will upto string length and intenally a for loop and to check palindrome another loop.
​