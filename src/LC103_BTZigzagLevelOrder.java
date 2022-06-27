import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103_BTZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        boolean flag = true;

        if(root == null){
            return res;
        }

        que.add(root);

        while(!que.isEmpty()){
            int qSize = que.size();
            List<Integer> list = new LinkedList<>();

            flag = !flag;

            for(int i = 0; i < qSize; i++) {
                TreeNode curr = que.poll();

                if(curr.left != null) {
                    que.add(curr.left);
                }
                if(curr.right != null) {
                    que.add(curr.right);
                }

                list.add(curr.val);
            }

            if(flag) {
                Collections.reverse(list);
            }

            res.add(list);
        }

        return res;
    }
}
