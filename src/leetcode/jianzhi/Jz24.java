package jianzhi;

import TreeNode.TreeNode;

import java.util.ArrayList;

public class Jz24 {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        find(root, target, new ArrayList<>());
        return res;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> temp) {
        if (root == null) return;
        temp.add(root.val);
        if (target-root.val == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
//            return; 这个return不能写，因为会影响后面的remove，从而造成路径内有其他的节点未被清除，反正最上面已经有return了
        }
        find(root.left, target-root.val, temp);
        find(root.right, target-root.val, temp);
        temp.remove(temp.size()-1);
    }
}
