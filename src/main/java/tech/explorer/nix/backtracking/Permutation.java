package tech.explorer.nix.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//LC-46
//https://leetcode.com/problems/permutations/
public class Permutation {
	class Approach_1 {
	    List<List<Integer>> op;
	    public List<List<Integer>> permute(int[] nums) {
	        op = new LinkedList<List<Integer>>();
	        permute(nums, 0);
	        return op;
	    }
	    
	    void permute(int[] nums, int i){
	        if(i>=nums.length){
	            List<Integer> list = new LinkedList<Integer>();
	            for(int num: nums)
	                list.add(num);
	            op.add(list);
	            return;
	        }
	        
	        permute(nums, i+1);
	        for(int j=i+1; j<nums.length; j++){
	            swap(nums, i , j);
	            permute(nums, i+1);
	            swap(nums, i , j);
	        }
	    }
	    
	    void swap(int nums[] ,int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	}

	class Approach_2 {
	    List<List<Integer>> output = null;
	    public List<List<Integer>> permute(int[] nums) {
	        boolean visited[] = new boolean[nums.length];
	        output = new LinkedList<List<Integer>>();
	        dfs(nums, new ArrayList<Integer>(), visited);
	        return output;
	    }
	    
	    void dfs(int[] nums,List<Integer> list, boolean[] visited){
	        if(list.size()==nums.length){
	            output.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int j=0; j<nums.length; j++){
	            if(visited[j]){
	                continue;
	            }

	            visited[j]=true;
	            list.add(nums[j]);
	            dfs(nums, list, visited);
	            list.remove(list.size()-1);
	            visited[j]=false;
	        }
	    }
	    
	}
}
//time complexity O(n!)
//space complexity O(n!) for output list