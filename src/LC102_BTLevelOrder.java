import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102_BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return res;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> list = new LinkedList<Integer>();

            // becaue each entry should be an array of all nodes in that level
            for(int i = 0; i<qSize; i++) {
                TreeNode currNode = queue.poll();

                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                if(currNode.right != null) {
                    queue.add(currNode.right);
                }
                list.add(currNode.val);
            }
            res.add(list);
        }
        return res;
    }
}
