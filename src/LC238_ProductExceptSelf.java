public class LC238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // https://www.youtube.com/watch?v=bNvIQI2wAjk
        int l = nums.length;
        int[] after = new int[l];
        int[] before = new int[l];
        int[] res = new int[l];

        before[0] = nums[0];
        for(int i = 1; i < l; i++) {
            before[i] = before[i - 1] * nums[i];
        }

        after[l - 1] = nums[l - 1];
        for(int i = l - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i];
        }

        for(int i = 0; i < l; i++) {
            if(i == 0) {
                res[i] = 1 * after[i + 1];
            } else if (i == (l - 1)) {
                // No postfix
                res[i] = 1 * before[i - 1];
            } else {
                res[i] = after[i + 1] * before[i - 1];
            }
        }
        return res;

    }
}
