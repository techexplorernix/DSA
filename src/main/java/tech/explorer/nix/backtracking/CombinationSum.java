package tech.explorer.nix.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//LC-39
//TC (2^target)*k  here k=length of each combination 
public class CombinationSum {
	class Approach_1 {
		List<List<Integer>> output;

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			output = new LinkedList<>();
			combine(candidates, 0, target, new ArrayList<>());
			return output;
		}

		void combine(int[] nums, int i, int target, List<Integer> list) {
			if (i >= nums.length || target < 0) {
				return;
			}
			if (target == 0) {
				output.add(new ArrayList<>(list));
				return;
			}
			combine(nums, i + 1, target, list);

			list.add(nums[i]);
			combine(nums, i, target - nums[i], list);
			list.remove(list.size() - 1);
		}
	}

	class Approach_2 {
		List<List<Integer>> output;

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			output = new LinkedList<>();
			combine(candidates, 0, target, new ArrayList<>());
			return output;
		}

		void combine(int[] nums, int i, int target, List<Integer> list) {
			if (i >= nums.length || target < 0) {
				return;
			}
			if (target == 0) {
				output.add(new ArrayList<>(list));
				return;
			}
			for (int j = i; j < nums.length; j++) {
				list.add(nums[j]);
				combine(nums, j, target - nums[j], list);
				list.remove(list.size() - 1);
			}
		}
	}

}
