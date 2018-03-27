# Indeed-Onsite 面经
# auto complete
* Question Description. 
 * Say I'm typing on a phone. Given a prefix String,and a dictionary
 * Find all auto-complete word for the given prefix string
 */
 
//if follow up: 优先输出高频词。
//思路就是每个trie node加上一个数字，向下遍历的时候优先输出高频的child即可。
//但是写出了trie 解法后，面试官一定要我想个其他的解法，然后我写了bst，然后他还要我想个解法

# Using Binary Search in Auto Complete
* Like the upper one's description
* All we need to do is Fill the prefix with the Logn time, using BS
* Sort the arr, and find left bond(the start of prefix), right bond(the max result of prefix)
* For eg, prefix: "ap"
* arr: "apple, code, fill, pre, app, apped, appled"

# dice
/* =============================================================================
Question：
=============================================================================*/

Now you have a dice, and throw it multiple times.
Find the possibility the sum of points is a target number

/* =============================================================================
code
=============================================================================*/

//简单DFS了一下,还是很容易实现的。
//下一步需要看DP和记忆化搜索怎么搞。

/* =============================================================================
题目内容：
=============================================================================*/

投dice次数的骰子，求这么多次的点数和为target的概率是多大。
暴力就是求和的概率就是combination sum（1<->6），比较容易，然后总数就是6的dice次方。

这题的关键点就在于怎么优化了。记忆化搜索优化的挺好。
复杂度应该和dp一样，O（6*dice*target）

/* =============================================================================
地里面经总结
=============================================================================*/

写一个函数float sumPossibility(int dice, int target)，就是投dice个骰子，求最后和为target的概率。
因为总共的可能性是6^dice，所以其实就是combination sum。
求dice个骰子有多少种组合，使其和为target。先用brute force的dfs来一个O(6^dice)指数复杂度的，
然后要求优化，用dp，最后结束代码写的是两者结合的memorized search吧


