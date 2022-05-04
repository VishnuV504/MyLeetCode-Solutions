The greedy part of the solution is that, we also notice that we only need minSize since if the minSize satisfies the constraints to have distinct letters <= maxLetters any substring greater than that size would only add at max a new distinct letter.
Which esentially means that since the substring of size greater than minSize starisfies the constraint of distinct letters <= maxLetters there will be a substring of this selected substring of size minSize that'll satisfy the same constraint and the frequency of this substring will be atleast as much as the parent substring.
We also know that number of shorter substrings are more than the longer ones , thus we only need to check for substrings of minSize satisfying the condition.
​
​