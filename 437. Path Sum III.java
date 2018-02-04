class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        map.put(0, 1);//Default sum = 0 has one count
        return helper(root, sum, 0);
    }
    public int helper(TreeNode node, int target, int cur) {
        if (node == null) return 0;
        cur += node.val;
        int res = map.getOrDefault(cur - target, 0);//See if there is a subarray sum equals to target
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res += helper(node.left, target, cur) + helper(node.right, target, cur);
        map.put(cur, map.get(cur) - 1);//Remove the current node so it wont affect other path
        return res;
    }
}


public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
