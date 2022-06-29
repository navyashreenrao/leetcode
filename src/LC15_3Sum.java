import java.util.*;

public class LC15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < l; i++) {
            List<List<Integer>> r1 = twoSum(nums, -nums[i], i + 1);
            for(int j = 0; j < r1.size(); j++) {
                List<Integer> l1 = r1.get(j);
                // Check for duplicates
                if(l1.size() == 2) {
                    r1.get(j).add(nums[i]);
                }
            }
            res.addAll(r1);
        }
        List<List<Integer>> res2 = new ArrayList<>();
        res2.addAll(res);
        return res2;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        int end = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(start < end) {
            if(nums[start] + nums[end] == target) {
                if(start != end) {
                    List<Integer> lis = new ArrayList<>();
                    lis.add(nums[start]);
                    lis.add(nums[end]);
                    res.add(lis);
                    start++;
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
