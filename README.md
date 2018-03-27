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


