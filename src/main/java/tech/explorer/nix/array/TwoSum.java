package tech.explorer.nix.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import javafx.util.Pair;

public class TwoSum {
	// using HashMap
	// TC O(n)
	// SC O(n)
	class Approach_1 {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> set = new HashMap<Integer, Integer>();

			for (int i = 0; i < nums.length; i++) {
				if (set.containsKey(target - nums[i])) {
					return new int[] { i, set.get(target - nums[i]) };
				}
				set.put(nums[i], i);
			}
			return new int[] {};
		}
	}

	// brute force approach
	// TC O(n^2)
	// SC O(1)
	class Approach_2 {
		public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length; i++)
				for (int j = 0; j < nums.length && i != j; j++)
					if (nums[i] + nums[j] == target)
						return new int[] { i, j };
			return new int[0];
		}
	}

	// using 2 pointers
	//TC O(n log n)
	//SC O(n) //it can be O(1) but we have to return index so we are storing n elements in Pair[]
	class Approach_3 {
		class Pair {
			int i, val;

			Pair(int i, int val) {
				this.i = i;
				this.val = val;
			}
		}

		public int[] twoSum(int[] nums, int target) {
			Pair[] pairs = new Pair[nums.length];
			for (int i = 0; i < nums.length; i++) {
				pairs[i] = new Pair(i, nums[i]);
			}

			Arrays.sort(pairs, (x, y) -> x.val - y.val);
			int left = 0, right = nums.length - 1;
			while (left < right) {
				int sum = pairs[left].val + pairs[right].val;
				if (sum == target) {
					return new int[] { pairs[left].i, pairs[right].i };
				}
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
			return new int[] {};
		}
	}
}
