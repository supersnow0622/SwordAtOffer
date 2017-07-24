package chapter2;

/**
 * @Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author:鐜嬩附闆?-Dosgi.requiredJavaVersion=1.6
 * @time:2017年7月20日下午4:28:53
 */
public class JumpFloorII {
	public int JumpFloorII(int target) {
        return (int) Math.pow(2, target-1);
    }
}
