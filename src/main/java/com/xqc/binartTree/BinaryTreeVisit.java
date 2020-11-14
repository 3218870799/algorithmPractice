package com.xqc.binartTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 二叉树遍历方式
 */
public class BinaryTreeVisit {

    /**
     * @author xqc
     * @data 2020年5月24日
     * Description:
     * 二叉树节点
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode(int value, BinaryTreeNode left,
                BinaryTreeNode right) {
            super();
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    // 访问树的节点
    public static void visit(BinaryTreeNode node) {
        System.out.println(node.value);
    }

    /** 递归实现二叉树的先序遍历 */
    public static void preOrder(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /** 递归实现二叉树的中序遍历 */
    public static void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    /** 递归实现二叉树的后序遍历 */
    public static void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    /** 
     * 先序遍历——非递归实现二叉树的
     * 当栈不为空时，
     * 先取出节点，访问，右节点入栈，左节点入栈	
     * 
     */
    public static void iterativePreorder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        //如果二叉树不为空
        if (root != null) {
        	//将根节点入栈
            stack.push(root);
            //当栈不为空时
            while (!stack.empty()) {
            	//出栈
                root = stack.pop();
                // 先访问节点
                visit(root);
                // 把右结点压入栈
                if (root.right != null) {
                    stack.push(root.right);
                }
                // 把左子结点压入栈
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    /** 
     * 中序遍历——非递归实现
     * 
     */
    public static void iterativeInOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        //节点不为空或者栈不为空
        while (node != null || stack.size() > 0) {
            // 依次将把当前节点的所有左侧子结点压入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 访问节点，处理该节点的右子树
            if (stack.size() > 0) {
            	//获得栈顶元素，即先访问左节点，又一循环访问根节点
                node = stack.pop();
                visit(node);
                //指向右节点
                node = node.right;
            }
        }
    }

    /** 非递归使用单栈实现二叉树后序遍历 */
    public static void iterativePostOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        // 访问根节点时判断其右子树是够被访问过
        BinaryTreeNode preNode = null;
        while (node != null || stack.size() > 0) {
            // 把当前节点的左侧节点全部入栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                BinaryTreeNode temp = stack.peek().right;
                // 一个根节点被访问的前提是：无右子树或右子树已被访问过
                if (temp == null || temp == preNode) {
                    node = stack.pop();
                    visit(node);
                    preNode = node;// 记录刚被访问过的节点
                    node = null;
                } else {
                    // 处理右子树
                    node = temp;
                }
            }
        }
    }

    /** 非递归使用双栈实现二叉树后序遍历 */
    public static void iterativePostOrderByTwoStacks(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> temp = new Stack<>();
        BinaryTreeNode node = root;
        while (node != null || stack.size() > 0) {
            // 把当前节点和其右侧子结点推入栈
            while (node != null) {
                stack.push(node);
                temp.push(node);
                node = node.right;
            }
            // 处理栈顶节点的左子树
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.left;
            }
        }
        while (temp.size() > 0) {
            node = temp.pop();
            visit(node);
        }
    }

    /** 
     * 二叉树广度优先遍历——层序遍历 
     * 使用队列
     * 当队列不为空时
     * 取出对头节点，访问，做不为空左入队，右不为空右入队
     * 
     * */
    public static void layerTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTreeNode currentNode = queue.poll();
                visit(currentNode);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }
        }
    }

    public static void main(String[] args) {

        // 构造二叉树
        // 1
        // / \
        // 2 3
        // / / \
        // 4 5 7
        // \ /
        // 6 8
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node7;
        node5.right = node6;
        node7.left = node8;
        System.out.println("二叉树先序遍历");
        preOrder(root);
        System.out.println("二叉树先序遍历非递归");
        iterativePreorder(root);
        System.out.println("二叉树中序遍历");
        inOrder(root);
        System.out.println("二叉树中序遍历非递归");
        iterativeInOrder(root);
        System.out.println("二叉树后序遍历");
        postOrder(root);
        System.out.println("二叉树单栈非递归后序遍历");
        iterativePostOrder(root);
        System.out.println("二叉树双栈非递归后序遍历");
        iterativePostOrderByTwoStacks(root);
        System.out.println("二叉树层树序遍历");
        layerTraversal(root);
    }
}
