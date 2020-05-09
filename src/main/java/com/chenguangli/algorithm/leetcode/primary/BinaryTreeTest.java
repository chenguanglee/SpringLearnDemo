package com.chenguangli.algorithm.leetcode.primary;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树
 *
 * @author chenguangli
 * @date 2019/8/15 23:47
 */
public class BinaryTreeTest {

    /**
     * 根据前序和中序遍历获取后序遍历
     *
     * @param firstOrder
     * @param mediumOrder
     */
    public BinaryTreeNode reConstruct(String firstOrder, String mediumOrder) {
        if (StringUtils.isEmpty(firstOrder) || StringUtils.isEmpty(mediumOrder)) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(String.valueOf(firstOrder.charAt(0))), null, null);
        for (int i = 0; i < mediumOrder.length(); i++) {
            if (firstOrder.charAt(0) == mediumOrder.charAt(i)) {
                node.setLeftNode(reConstruct(firstOrder.substring(1, i + 1 > firstOrder.length() ? firstOrder.length() : i + 1), mediumOrder.substring(0, i)));
                node.setRightNode(reConstruct(firstOrder.substring(i + 1 > firstOrder.length() ? firstOrder.length() : i + 1), mediumOrder.substring(i + 1 > mediumOrder.length() ? mediumOrder.length() : i + 1)));
            }
        }
        return node;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * I. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

    @Test
    public void testLowestCommonAncestor1() {
        int[] pre = {6, 2, 0, 4, 3, 5, 8, 7, 9};
        int[] in = {0, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode treeNode = buildTree(pre, in);
        TreeNode treeNode1 = lowestCommonAncestor1(treeNode, new TreeNode(10), new TreeNode(11));
        System.out.println(treeNode1.val);
    }

    /**
     * 翻转二叉树
     * 翻转一棵二叉树。
     * <p>
     * 示例：
     * <p>
     * 输入：
     * <p>
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     * 输出：
     * <p>
     * 4
     * /   \
     * 7     2
     * / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree1(root);
        return root;
    }

    public void invertTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    @Test
    public void testInvertTree() {
        int[] pre = {4, 2, 1, 3, 7, 6, 9};
        int[] in = {1, 2, 3, 4, 6, 7, 9};
        TreeNode treeNode = buildTree(pre, in);
        invertTree2(treeNode);
        invertTree(treeNode);
        System.out.println();
    }

    /**
     * I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * <p>
     *  
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回：
     * <p>
     * [3,9,20,15,7]
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                count--;
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }


    /**
     * II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * <p>
     *  
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                count--;
            }
            res.add(list);
        }
        return res;
    }


    /**
     * III. 从上到下打印二叉树 III
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * <p>
     *  
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [20,9],
     * [15,7]
     * ]
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int row = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                count--;
            }
            if (row % 2 == 0) {
                Collections.reverse(list);
            }
            row++;
            res.add(list);
        }
        return res;
    }


    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        TreeNode node = new TreeNode(root);
        int[] leftPre, leftIn, rightPre, rightIn;
        int inLength = inorder.length;
        int preLength = preorder.length;
        for (int i = 0; i < inLength; i++) {
            if (inorder[i] == root) {
                leftPre = Arrays.copyOfRange(preorder, 1, i + 1 > preLength ? preLength : i + 1);
                leftIn = Arrays.copyOfRange(inorder, 0, i);
                rightPre = Arrays.copyOfRange(preorder, i + 1 > preLength ? preLength : i + 1, preLength);
                rightIn = Arrays.copyOfRange(inorder, i + 1 > inLength ? inLength : i + 1, inLength);
                node.left = buildTree(leftPre, leftIn);
                node.right = buildTree(rightPre, rightIn);
                break;
            }
        }
        return node;
    }


    /**
     * 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     * <p>
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     * <p>
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        change(root);
        return root;
    }

    public void change(TreeNode root) {
        if (root == null) {
            return;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    /**
     * 二叉搜索树的第k大节点
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> integers = kthLargest1(root, new ArrayList<>());
        return integers.get(integers.size() - k);
    }

    public List<Integer> kthLargest1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        kthLargest1(root.left, list);
        list.add(root.val);
        kthLargest1(root.right, list);
        return list;
    }

    /**
     * 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 平衡二叉树
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int abs = Math.abs(left - right);
        return abs <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    @Test
    public void test2() {
        int[] pre = {1, 2, 3, 4, 2, 3, 4};
        int[] in = {4, 3, 2, 1, 2, 3, 4};
        TreeNode treeNode = buildTree(pre, in);
        boolean balanced = isBalanced(treeNode);
        int i = kthLargest(treeNode, 1);
        TreeNode treeNode1 = mirrorTree(treeNode);
        System.out.println();
    }


    /**
     * 树的子结构
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * <p>
     * 例如:
     * 给定的树 A:
     * <p>
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     * <p>
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || A != null) {
            while (A != null) {
                stack.push(A);
                A = A.left;
            }
            if (!stack.empty()) {
                A = stack.pop();
                if (isEqual(A, B)) {
                    return true;
                }
                A = A.right;
            }
        }
        return false;
    }

    public boolean isEqual(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        if (A.val != B.val) {
            return false;
        }
        return isEqual(A.left, B.left) && isEqual(A.right, B.right);
    }

    /**
     * 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null){
            return null;
        }
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }

    public TreeNode findNode(TreeNode root, TreeNode a) {
        if (root == null) {
            return null;
        }
        if (root.val == a.val) {
            return root;
        }
        TreeNode node = findNode(root.left, a);
        if (node == null) {
            node = findNode(root.right, a);
        }
        return node;
    }

    public boolean findPath(TreeNode root, TreeNode a, Stack<Integer> stack) {
        if (root == null) {
            return false;
        }
        stack.push(root.val);
        if (root.val == a.val) {
            return true;
        }
        boolean p = findPath(root.left, a, stack);
        if (!p && root.right != null) {
            p = findPath(root.right, a, stack);
        }
        if (!p) {
            stack.pop();
        }
        return p;
    }


    /**
     * 二叉树中和为某一值的路径
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * <p>
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \    / \
     * 7    2  5   1
     * 返回:
     * <p>
     * [
     * [5,4,11,2],
     * [5,8,4,5]
     * ]
     *
     * @param root
     * @param sum
     * @return
     */
    private List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        path(root, sum);
        return resList;
    }

    public void path(TreeNode root, int sum) {
        if (root == null) return;
        res.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            resList.add(new ArrayList<>(res));
        }
        path(root.left, sum);
        path(root.right, sum);
        res.remove(res.size() - 1);
    }

    @Test
    public void test4() {
        TreeNode root = buildTree(new int[]{5, 4, 11, 7, 2, 8, 13, 4, 5, 1}, new int[]{7, 11, 2, 4, 5, 13, 8, 5, 4, 1});
        List<List<Integer>> lists = pathSum(root, 22);
        Stack<Integer> stack = new Stack<>();
        findPath(root, new TreeNode(7), stack);
        System.out.println(stack);
    }

    @Test
    public void test3() {
        TreeNode A = buildTree(new int[]{3, 4, 1, 2, 5}, new int[]{1, 4, 2, 3, 5});
        TreeNode B = buildTree(new int[]{4, 1}, new int[]{1, 4});
        boolean subStructure = isSubStructure(A, B);
        System.out.println();
    }




    @Test
    public void test1() {
        String firstOrder = "1245367";
        String mediumOrder = "4251637";
        BinaryTreeNode node = reConstruct(firstOrder, mediumOrder);
        BinaryTree tree = new BinaryTree(node);
        System.out.println("前序遍历");
        tree.firstOrder(node);
        System.out.println();
        System.out.println("中序遍历");
        tree.mediumOrder(node);
        System.out.println();
        System.out.println("后序遍历");
        tree.lastOrder(node);
        System.out.println();
        System.out.println("use no recursive 中序遍历");
        tree.mediumOrderNoRecursive(node);
        System.out.println();
        System.out.println("-----------");
        System.out.println("二叉树交换后的前序遍历结果");
        tree.exchangeBinaryTree(node);
        tree.firstOrder(node);
        System.out.println();
        System.out.println("二叉树交换后的中序遍历结果");
        tree.mediumOrder(node);

    }
}
