we can do this is many ways
if inplace is not allowed we can use boolean array wether we are visited or not
or we can use bitmask as number of cells also very less , make the bit as set
the cell which you have to visit like if i want to visit the cell i will make the first bit
as set, whenever i visits that cell i make it as zero(unset) and backtrack whenever mask becomes zero
and grid[i][j]=2 return 1 i found a path
​
approach insted i count the no of cells i have to visit whenever ever count becomes zero and grid[i][j]=2 i found a path return 1;   whenever you visit the cell make count-- and
again again backtrack as count++;