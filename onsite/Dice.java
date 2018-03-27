package onsite;
import java.util.*;
/* =============================================================================
Question：
=============================================================================
Now you have a dice, and throw it multiple times.
Find the possibility the sum of points is a target number
=============================================================================
code
=============================================================================*/
//简单DFS了一下,还是很容易实现的。
//下一步需要看DP和记忆化搜索怎么搞。
public class Dice {
	public double possible(int dice_time, int target) {
		int count = (int) Math.pow(6, dice_time);
//		int a =simpledfs(dice_time,target);
//		System.out.println(a);
		int[][] memo = new int[dice_time + 1][target + 1];
		//int a = memoization(dice_time, target, memo);
		int a = dp(dice_time, target);
		System.out.println(a);
		return (double) a/count;
	}
	public int simpledfs(int dice_time, int target) {
		int res = 0;
		if(dice_time == 0 && target == 0) {
			//res ++;//same
			return 1;
		}
		if(target < dice_time || dice_time < 0)
			return 0;
		for(int i = 1; i <= 6 ; i ++) {
			res += simpledfs(dice_time - 1, target - i);
		}
		return res;
	}
	//memo
	public int memoization(int dice_time, int target, int[][] memo)
	{
		int res = 0;
		if(dice_time == 0 && target == 0) {
			//res ++;//same
			return 1;
		}
		if(target < dice_time || dice_time < 0)
			return 0;
		if(memo[dice_time][target] != 0) {
			return memo[dice_time][target];
		}
		for(int i = 1; i <= 6 ; i ++) {
			res += simpledfs(dice_time - 1, target - i);
		}
		memo[dice_time][target] = res;
		return res;
	}
	
	//dp
	public int dp(int dice_time, int target) {
		int[][] dp = new int[dice_time+1][target+1];
		for(int j = 1; j <= 6; j++) {
			dp[1][j] = 1;
		}
		for(int i = 2; i <= dice_time; i++) {
			for(int j = i; j <= target; j++) {
				for(int k = 1; k <= 6; k ++) {
					if(j - k >= i - 1)
						dp[i][j] += dp[i - 1][j - k];
				}
			}
		}
		return dp[dice_time][target];
	}
	public static void main(String[] args) {
		Dice b = new Dice();
		double res = b.possible(3, 6);
		System.out.println(res);
	}
}
