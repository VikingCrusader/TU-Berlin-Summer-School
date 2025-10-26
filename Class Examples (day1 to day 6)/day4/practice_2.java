package day4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice_2 {
	public static void main(String[] args) {
		//写一个程序，给定一个 List<Integer>，删除其中所有的偶数。
		List<Integer> nums = new ArrayList<>(Arrays.asList(4, 7, 10, 3, 9, 12));
		// 移除所有偶数
		// 输出最终 List
		for (int i = 0 ; i < nums.size(); i++) {
			if (nums.get(i) % 2 == 0) {
				nums.remove(i);
			}
		}
		System.out.println(nums);
	}
}
